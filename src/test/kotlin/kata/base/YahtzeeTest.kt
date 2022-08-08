package kata.base

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import kata.base.Score.CHANCE
import kata.base.Score.YAHTZEE

class YahtzeeTest : WordSpec({
    "score category" When {
        "chance" should {
            "add all numbers" {
                val result = Yahtzee.score(CHANCE, 1, 2, 3, 4, 5)

                result shouldBe 1 + 2 + 3 + 4 + 5
            }
        }

        "yahtzee" should {
            "return 0 given dices with different scores" {
                val result = Yahtzee.score(YAHTZEE, 1, 2, 3, 4, 5)

                result shouldBe 0
            }
        }
    }
})
