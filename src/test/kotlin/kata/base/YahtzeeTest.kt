package kata.base

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import kata.base.Category.*

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

            "return 50 given dices with the same scores" {
                val result = Yahtzee.score(YAHTZEE, 1, 1, 1, 1, 1)

                result shouldBe 50
            }
        }

        "aces" should {
            "return 0 given no ones" {
                val result = Yahtzee.score(ACES, 2, 3, 4, 5, 6)

                result shouldBe 0
            }
            "return total score of ones" {
                val result = Yahtzee.score(ACES, 1, 3, 1, 5, 6)

                result shouldBe 1 + 1
            }
        }

        "twos" should {
            "return 0 given no twos" {
                val result = Yahtzee.score(TWOS, 1, 3, 4, 5, 6)

                result shouldBe 0
            }
            "return total score of twos" {
                val result = Yahtzee.score(TWOS, 2, 3, 2, 5, 6)

                result shouldBe 2 + 2
            }
        }

        "threes" should {
            "return 0 given no threes" {
                val result = Yahtzee.score(THREES, 1, 2, 4, 5, 6)

                result shouldBe 0
            }
            "return total score of ones" {
                val result = Yahtzee.score(THREES, 3, 1, 3, 5, 6)

                result shouldBe 3 + 3
            }
        }
    }
})
