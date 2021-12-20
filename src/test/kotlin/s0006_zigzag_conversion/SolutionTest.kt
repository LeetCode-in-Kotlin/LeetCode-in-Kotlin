package s0006_zigzag_conversion

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SolutionTest {
    @Test
    fun convert() {
        assertThat(Solution().convert("PAYPALISHIRING", 3), equalTo("PAHNAPLSIIGYIR"))
    }
}
