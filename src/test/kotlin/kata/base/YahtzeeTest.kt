package kata.base

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import kata.base.Category.*
import kata.base.Yahtzee.Companion.score

class YahtzeeTest : WordSpec({
    "score category" When {
        "chance" should {
            "add all numbers" {
                val result = score(CHANCE, 1, 2, 3, 4, 5)

                result shouldBe 1 + 2 + 3 + 4 + 5
            }
        }

        "yahtzee" should {
            "return 0 given dices with different scores" {
                val result = score(YAHTZEE, 1, 2, 3, 4, 5)

                result shouldBe 0
            }

            "return 50 given dices with the same scores" {
                val result = score(YAHTZEE, 1, 1, 1, 1, 1)

                result shouldBe 50
            }
        }

        "aces" should {
            "return 0 given no ones" {
                val result = score(ACES, 2, 3, 4, 5, 6)

                result shouldBe 0
            }
            "return total score of ones" {
                val result = score(ACES, 1, 3, 1, 5, 6)

                result shouldBe 1 + 1
            }
        }

        "twos" should {
            "return 0 given no twos" {
                val result = score(TWOS, 1, 3, 4, 5, 6)

                result shouldBe 0
            }
            "return total score of twos" {
                val result = score(TWOS, 2, 3, 2, 5, 6)

                result shouldBe 2 + 2
            }
        }

        "threes" should {
            "return 0 given no threes" {
                val result = score(THREES, 1, 2, 4, 5, 6)

                result shouldBe 0
            }
            "return total score of threes" {
                val result = score(THREES, 3, 1, 3, 5, 6)

                result shouldBe 3 + 3
            }
        }

        "fours" should {
            "return 0 given no fours" {
                val result = score(FOURS, 1, 2, 3, 5, 6)

                result shouldBe 0
            }
            "return total score of fours" {
                val result = score(FOURS, 4, 1, 4, 5, 6)

                result shouldBe 4 + 4
            }
        }

        "fives" should {
            "return 0 given no fives" {
                val result = score(FIVES, 1, 2, 3, 4, 6)

                result shouldBe 0
            }
            "return total score of fives" {
                val result = score(FIVES, 5, 1, 5, 4, 6)

                result shouldBe 5 + 5
            }
        }

        "sixes" should {
            "return 0 given no sixes" {
                val result = score(SIXES, 1, 2, 3, 4, 5)

                result shouldBe 0
            }
            "return total score of sixes" {
                val result = score(SIXES, 6, 1, 6, 4, 5)

                result shouldBe 6 + 6
            }
        }

        "three of a kind" should {
            "return 0 given no three similar dices" {
                val result = score(THREE_OF_A_KIND, 2, 2, 3, 4, 5)

                result shouldBe 0
            }

            "return the sum of three similar dices" {
                val result = score(THREE_OF_A_KIND, 2, 2, 3, 2, 5)

                result shouldBe 2 + 2 + 2
            }

            "return the sum of just three similar dices given more" {
                val result = score(THREE_OF_A_KIND, 2, 2, 3, 2, 2)

                result shouldBe 2 + 2 + 2
            }
        }

        "four of a kind" should {
            "return 0 given no four similar dices" {
                val result = score(FOUR_OF_A_KIND, 2, 2, 2, 3, 5)

                result shouldBe 0
            }

            "return the sum of four similar dices" {
                val result = score(FOUR_OF_A_KIND, 2, 2, 2, 2, 5)

                result shouldBe 2 + 2 + 2 + 2
            }

            "return the sum of just four similar dices given more" {
                val result = score(FOUR_OF_A_KIND, 2, 2, 2, 2, 2)

                result shouldBe 2 + 2 + 2 + 2
            }
        }

        "full house" should {
            "return 0 given no two and three similar dices" {
                val result = score(FULL_HOUSE, 2, 2, 1, 3, 3)

                result shouldBe 0
            }

            "return 25 given two and three similar dices" {
                val result = score(FULL_HOUSE, 2, 2, 2, 3, 3)

                result shouldBe 25
            }

            "return 0 given four similar dices and one different one" {
                val result = score(FULL_HOUSE, 2, 2, 2, 2, 3)

                result shouldBe 0
            }
        }
        // only valid options are 1-2-3-4, 2-3-4-5, or 3-4-5-6
        "small straight" should {
            "return 30 given 1, 2, 3, 4 sequentially" {
                val result = score(SMALL_STRAIGHT, 1, 2, 3, 4, 5)

                result shouldBe 30
            }

            "return 30 given 2, 3, 4, 5 sequentially" {
                val result = score(SMALL_STRAIGHT, 1, 3, 4, 5, 6)

//                result shouldBe 30
            }

            "return 30 given 3, 4, 5, 6 sequentially" {
                val result = score(SMALL_STRAIGHT, 1, 3, 4, 5, 6)

//                result shouldBe 30
            }

            "return 0 given non sequential straight" {
                val result = score(SMALL_STRAIGHT, 2, 3, 4, 5, 6)

                result shouldBe 0
            }

            "return 0 given non straight" {
                val result = score(SMALL_STRAIGHT, 1, 3, 3, 4, 5)

                result shouldBe 0
            }
        }

        "large straight" should {
            "return 40 given a 1, 2, 3, 4, 5" {
                val result = score(LARGE_STRAIGHT, 1, 2, 3, 4, 5)

                result shouldBe 40
            }

            "return 40 given a 2, 3, 4, 5, 6" {
                val result = score(LARGE_STRAIGHT, 2, 3, 4, 5, 6)

                result shouldBe 40
            }

            "return 0 given non straight" {
                val result = score(LARGE_STRAIGHT, 1, 3, 3, 4, 5)

                result shouldBe 0
            }
        }
    }
})
