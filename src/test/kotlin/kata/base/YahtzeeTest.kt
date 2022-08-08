package kata.base

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class YahtzeeTest : WordSpec({
    "score" When {
        "category chance" should {
            "add all numbers" {
                val result = Yahtzee.score(1, 2, 3, 4, 5)

                result shouldBe 1 + 2 + 3 + 4 + 5
            }
        }
    }
})
