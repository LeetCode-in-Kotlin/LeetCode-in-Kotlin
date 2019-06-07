package s0003.longest.substring.without.repeating.characters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longest = 0
        var f = 0
        val charArray = IntArray(128)
        for (i in 0 until s.length) {
            if (charArray[s.get(i).toInt()] == 0) {
                longest = if (longest < (i + 1 - f)) (i + 1 - f) else longest
                charArray[s.get(i).toInt()] += 1
            } else {
                while (s.get(f) != s.get(i)) {
                    charArray[s.get(f).toInt()] = 0
                    f++
                }
                f++
            }
        }
        return longest
    }
}