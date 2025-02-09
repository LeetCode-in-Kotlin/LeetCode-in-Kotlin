package g2201_2300.s2288_apply_discount_to_prices

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun discountPrices() {
        assertThat(
            Solution().discountPrices("there are $1 $2 and 5$ candies in the shop", 50),
            equalTo("there are $0.50 $1.00 and 5$ candies in the shop"),
        )
    }

    @Test
    fun discountPrices2() {
        assertThat(
            Solution().discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100),
            equalTo("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"),
        )
    }

    @Test
    fun discountPrices3() {
        assertThat(
            Solution().discountPrices("$76111 ab $6 $", 48),
            equalTo("$39577.72 ab $3.12 $"),
        )
    }
}
