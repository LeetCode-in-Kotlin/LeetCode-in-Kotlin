package g0901_1000.s0923_3sum_with_multiplicity

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun threeSumMulti() {
        assertThat(
            Solution().threeSumMulti(intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5), 8),
            equalTo(20),
        )
    }

    @Test
    fun threeSumMulti2() {
        assertThat(Solution().threeSumMulti(intArrayOf(1, 1, 2, 2, 2, 2), 5), equalTo(12))
    }
}
