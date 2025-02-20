package g0101_0200.s0175_combine_two_tables

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.zapodot.junit.db.annotations.EmbeddedDatabase
import org.zapodot.junit.db.annotations.EmbeddedDatabaseTest
import org.zapodot.junit.db.common.CompatibilityMode
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.sql.SQLException
import java.util.stream.Collectors
import javax.sql.DataSource

@EmbeddedDatabaseTest(
    compatibilityMode = CompatibilityMode.MySQL,
    initialSqls = [
        "CREATE TABLE Person(personId INTEGER PRIMARY KEY, lastName VARCHAR(512)" +
            ", firstName VARCHAR(512)); " +
            "INSERT INTO Person(personId, lastName, firstName)" +
            " VALUES (1, 'Wang', 'Allen'); " +
            "INSERT INTO Person(personId, lastName, firstName)" +
            " VALUES (2, 'Alice', 'Bob'); " +
            "CREATE TABLE Address(addressId INTEGER PRIMARY KEY, personId INTEGER" +
            ", city VARCHAR(512), state VARCHAR(512)); " +
            "INSERT INTO Address(addressId, personId, city, state)" +
            " VALUES (1, 2, 'New York City', 'New York'); " +
            "INSERT INTO Address(addressId, personId, city, state)" +
            " VALUES (2, 3, 'Leetcode', 'California'); ",
    ],
)
internal class MysqlTest {
    @Test
    @Throws(SQLException::class, FileNotFoundException::class)
    fun testScript(@EmbeddedDatabase dataSource: DataSource) {
        dataSource.connection.use { connection ->
            connection.createStatement().use { statement ->
                statement.executeQuery(
                    BufferedReader(
                        FileReader(
                            "src/main/kotlin/g0101_0200/s0175_combine_two_tables/script.sql",
                        ),
                    )
                        .lines()
                        .collect(Collectors.joining("\n"))
                        .replace("#.*?\\r?\\n".toRegex(), ""),
                ).use { resultSet ->
                    assertThat(resultSet.next(), equalTo(true))
                    assertThat(resultSet.getNString(1), equalTo("Allen"))
                    assertThat(resultSet.getNString(2), equalTo("Wang"))
                    assertThat(resultSet.getNString(3), equalTo(null))
                    assertThat(resultSet.getNString(4), equalTo(null))
                    assertThat(resultSet.next(), equalTo(true))
                    assertThat(resultSet.getNString(1), equalTo("Bob"))
                    assertThat(resultSet.getNString(2), equalTo("Alice"))
                    assertThat(resultSet.getNString(3), equalTo("New York City"))
                    assertThat(resultSet.getNString(4), equalTo("New York"))
                    assertThat(resultSet.next(), equalTo(false))
                }
            }
        }
    }
}
