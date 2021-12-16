package s0011_container_with_most_water

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class SolutionTest {
    @Test
    fun isPalindrome() {
        assertThat(Solution().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)), equalTo(49))
    }
}
