package kata.base

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import kata.base.Category.*
import kata.base.Dice.*
import kata.base.Yahtzee.Companion.score

class YahtzeeTest : WordSpec({
    "score category" When {
        "chance" should {
            "add all numbers" {
                val result = score(CHANCE, ONE, TWO, THREE, FOUR, FIVE)

                result shouldBe 1 + 2 + 3 + 4 + 5
            }
        }

        "yahtzee" should {
            "return 0 given dices with different scores" {
                val result = score(YAHTZEE, ONE, TWO, THREE, FOUR, FIVE)

                result shouldBe 0
            }

            "return 50 given dices with the same scores" {
                val result = score(YAHTZEE, ONE, ONE, ONE, ONE, ONE)

                result shouldBe 50
            }
        }

        "aces" should {
            "return 0 given no ones" {
                val result = score(ACES, TWO, THREE, FOUR, FIVE, SIX)

                result shouldBe 0
            }
            "return total score of ones" {
                val result = score(ACES, ONE, THREE, ONE, FIVE, SIX)

                result shouldBe 1 + 1
            }
        }

        "twos" should {
            "return 0 given no twos" {
                val result = score(TWOS, ONE, THREE, FOUR, FIVE, SIX)

                result shouldBe 0
            }
            "return total score of twos" {
                val result = score(TWOS, TWO, THREE, TWO, FIVE, SIX)

                result shouldBe 2 + 2
            }
        }

        "threes" should {
            "return 0 given no threes" {
                val result = score(THREES, ONE, TWO, FOUR, FIVE, SIX)

                result shouldBe 0
            }
            "return total score of threes" {
                val result = score(THREES, THREE, ONE, THREE, FIVE, SIX)

                result shouldBe 3 + 3
            }
        }

        "fours" should {
            "return 0 given no fours" {
                val result = score(FOURS, ONE, TWO, THREE, FIVE, SIX)

                result shouldBe 0
            }
            "return total score of fours" {
                val result = score(FOURS, FOUR, ONE, FOUR, FIVE, SIX)

                result shouldBe 4 + 4
            }
        }

        "fives" should {
            "return 0 given no fives" {
                val result = score(FIVES, ONE, TWO, THREE, FOUR, SIX)

                result shouldBe 0
            }
            "return total score of fives" {
                val result = score(FIVES, FIVE, ONE, FIVE, FOUR, SIX)

                result shouldBe 5 + 5
            }
        }

        "sixes" should {
            "return 0 given no sixes" {
                val result = score(SIXES, ONE, TWO, THREE, FOUR, FIVE)

                result shouldBe 0
            }
            "return total score of sixes" {
                val result = score(SIXES, SIX, ONE, SIX, FOUR, FIVE)

                result shouldBe 6 + 6
            }
        }

        "three of a kind" should {
            "return 0 given no three similar dices" {
                val result = score(THREE_OF_A_KIND, TWO, TWO, THREE, FOUR, FIVE)

                result shouldBe 0
            }

            "return the sum of three similar dices" {
                val result = score(THREE_OF_A_KIND, TWO, TWO, THREE, TWO, FIVE)

                result shouldBe 2 + 2 + 2
            }

            "return the sum of just three similar dices given more" {
                val result = score(THREE_OF_A_KIND, TWO, TWO, THREE, TWO, TWO)

                result shouldBe 2 + 2 + 2
            }
        }

        "four of a kind" should {
            "return 0 given no four similar dices" {
                val result = score(FOUR_OF_A_KIND, TWO, TWO, TWO, THREE, FIVE)

                result shouldBe 0
            }

            "return the sum of four similar dices" {
                val result = score(FOUR_OF_A_KIND, TWO, TWO, TWO, TWO, FIVE)

                result shouldBe 2 + 2 + 2 + 2
            }

            "return the sum of just four similar dices given more" {
                val result = score(FOUR_OF_A_KIND, TWO, TWO, TWO, TWO, TWO)

                result shouldBe 2 + 2 + 2 + 2
            }
        }

        "full house" should {
            "return 0 given no two and three similar dices" {
                val result = score(FULL_HOUSE, TWO, TWO, ONE, THREE, THREE)

                result shouldBe 0
            }

            "return 25 given two and three similar dices" {
                val result = score(FULL_HOUSE, TWO, TWO, TWO, THREE, THREE)

                result shouldBe 25
            }

            "return 0 given four similar dices and one different one" {
                val result = score(FULL_HOUSE, TWO, TWO, TWO, TWO, THREE)

                result shouldBe 0
            }
        }

        "small straight" should {
            "return 30 given Dice.ONE, Dice.TWO, Dice.THREE, 4 sequentially" {
                val result = score(SMALL_STRAIGHT, ONE, TWO, THREE, FOUR, FIVE)

                result shouldBe 30
            }

            "return 30 given Dice.TWO, Dice.THREE, Dice.FOUR, 5 sequentially" {
                val result = score(SMALL_STRAIGHT, ONE, THREE, FOUR, FIVE, SIX)

                result shouldBe 30
            }

            "return 30 given Dice.THREE, Dice.FOUR, Dice.FIVE, 6 sequentially" {
                val result = score(SMALL_STRAIGHT, ONE, THREE, FOUR, FIVE, SIX)

                result shouldBe 30
            }

            "return 0 given non sequential straight" {
                val result = score(SMALL_STRAIGHT, THREE, TWO, FOUR, FIVE, SIX)

                result shouldBe 0
            }

            "return 0 given non straight" {
                val result = score(SMALL_STRAIGHT, ONE, THREE, THREE, FOUR, FIVE)

                result shouldBe 0
            }
        }

        "large straight" should {
            "return 40 given a Dice.ONE, Dice.TWO, Dice.THREE, Dice.FOUR, 5" {
                val result = score(LARGE_STRAIGHT, ONE, TWO, THREE, FOUR, FIVE)

                result shouldBe 40
            }

            "return 40 given a Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE, 6" {
                val result = score(LARGE_STRAIGHT, TWO, THREE, FOUR, FIVE, SIX)

                result shouldBe 40
            }

            "return 0 given non straight" {
                val result = score(LARGE_STRAIGHT, ONE, THREE, THREE, FOUR, FIVE)

                result shouldBe 0
            }
        }
    }
})
