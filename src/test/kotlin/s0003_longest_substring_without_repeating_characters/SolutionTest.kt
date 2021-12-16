package s0003_longest_substring_without_repeating_characters

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class SolutionTest {
    @Test
    fun lengthOfLongestSubstring() {
        assertThat(Solution().lengthOfLongestSubstring("abcabcbb"), equalTo(3))
    }
}
