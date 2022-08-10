package kata.base

import kata.base.Dice.*

enum class Category {
    CHANCE {
        override fun calculateScore(dices: List<Dice>) = dices.map(Dice::points).sum()
    },
    YAHTZEE {
        override fun calculateScore(dices: List<Dice>) =
            if (dices.toSet().size == 1) 50
            else 0
    },
    ACES {
        override fun calculateScore(dices: List<Dice>) = dices.sumAllOfNumber(ONE)
    },
    TWOS {
        override fun calculateScore(dices: List<Dice>) = dices.sumAllOfNumber(TWO)
    },
    THREES {
        override fun calculateScore(dices: List<Dice>) = dices.sumAllOfNumber(THREE)
    },
    FOURS {
        override fun calculateScore(dices: List<Dice>) = dices.sumAllOfNumber(FOUR)
    },
    FIVES {
        override fun calculateScore(dices: List<Dice>) = dices.sumAllOfNumber(FIVE)
    },
    SIXES {
        override fun calculateScore(dices: List<Dice>) = dices.sumAllOfNumber(SIX)
    },
    THREE_OF_A_KIND {
        override fun calculateScore(dices: List<Dice>) = dices.nOfAKind(3)
    },
    FOUR_OF_A_KIND {
        override fun calculateScore(dices: List<Dice>) = dices.nOfAKind(4)
    },
    FULL_HOUSE {
        override fun calculateScore(dices: List<Dice>): Int {
            return if (dices.isFullHouse()) 25
            else 0
        }

        private fun List<Dice>.isFullHouse(): Boolean {
            val unique = distinct()
            if (unique.size != 2) return false

            val firstDice = unique.first()
            val secondDice = unique.last()

            return countDices(firstDice) <= 3 && countDices(secondDice) <= 3
        }
    },
    SMALL_STRAIGHT {
        private val option1 = listOf(ONE, TWO, THREE, FOUR)
        private val option2 = listOf(TWO, THREE, FOUR, FIVE)
        private val option3 = listOf(THREE, FOUR, FIVE, SIX)

        override fun calculateScore(dices: List<Dice>): Int {
            val firstFour = dices.subList(0, dices.size - 1)
            val lastFour = dices.subList(1, dices.size)

            return if (firstFour.isSmallStraight() || lastFour.isSmallStraight()) 30
            else 0
        }

        private fun List<Dice>.isSmallStraight() =
            this == option1 || this == option2 || this == option3
    },
    LARGE_STRAIGHT {
        private val option1 = listOf(ONE, TWO, THREE, FOUR, FIVE)
        private val option2 = listOf(TWO, THREE, FOUR, FIVE, SIX)

        override fun calculateScore(dices: List<Dice>): Int {
            return if (dices == option1 || dices == option2) 40
            else 0
        }
    };

    internal abstract fun calculateScore(dices: List<Dice>): Int

    private companion object {
        private fun List<Dice>.countDices(number: Dice) = count { it == number }
        private fun List<Dice>.sumAllOfNumber(number: Dice) = countDices(number) * number.points

        fun List<Dice>.nOfAKind(numberOfSimilarDices: Int): Int {
            val unique = distinct()

            val numberWithNOfAKind = unique.firstOrNull { u ->
                countDices(u) >= numberOfSimilarDices
            } ?: 0

            val scoringDices = filter { it == numberWithNOfAKind }.take(numberOfSimilarDices)

            return scoringDices.map(Dice::points).sum()
        }
    }
}
