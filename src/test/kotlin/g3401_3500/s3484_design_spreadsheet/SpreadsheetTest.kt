package g3401_3500.s3484_design_spreadsheet

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test

internal class SpreadsheetTest {
    @Test
    fun spreadsheet() {
        // Initializes a spreadsheet with 3 rows and 26 columns
        val spreadsheet = Spreadsheet(3)
        // returns 12 (5+7)
        MatcherAssert.assertThat<Int>(spreadsheet.getValue("=5+7"), CoreMatchers.equalTo<Int>(12))
        // sets A1 to 10
        spreadsheet.setCell("A1", 10)
        // returns 16 (10+6)
        MatcherAssert.assertThat<Int>(spreadsheet.getValue("=A1+6"), CoreMatchers.equalTo<Int>(16))
        // sets B2 to 15
        spreadsheet.setCell("B2", 15)
        // returns 25 (10+15)
        MatcherAssert.assertThat<Int>(spreadsheet.getValue("=A1+B2"), CoreMatchers.equalTo<Int>(25))
        // resets A1 to 0
        spreadsheet.resetCell("A1")
        // returns 15 (0+15)
        MatcherAssert.assertThat<Int>(spreadsheet.getValue("=A1+B2"), CoreMatchers.equalTo<Int>(15))
    }
}
