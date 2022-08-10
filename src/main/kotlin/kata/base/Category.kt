package kata.base

enum class Category {
    CHANCE {
        override fun calculateScore(dices: List<Int>) = dices.sum()
    },
    YAHTZEE {
        override fun calculateScore(dices: List<Int>) =
            if (dices.toSet().size == 1) 50
            else 0
    },
    ACES {
        override fun calculateScore(dices: List<Int>) = dices.sumAllOfNumber(1)
    },
    TWOS {
        override fun calculateScore(dices: List<Int>) = dices.sumAllOfNumber(2)
    },
    THREES {
        override fun calculateScore(dices: List<Int>) = dices.sumAllOfNumber(3)
    },
    FOURS {
        override fun calculateScore(dices: List<Int>) = dices.sumAllOfNumber(4)
    },
    FIVES {
        override fun calculateScore(dices: List<Int>) = dices.sumAllOfNumber(5)
    },
    SIXES {
        override fun calculateScore(dices: List<Int>) = dices.sumAllOfNumber(6)
    },
    THREE_OF_A_KIND {
        override fun calculateScore(dices: List<Int>) = dices.nOfAKind(3)
    },
    FOUR_OF_A_KIND {
        override fun calculateScore(dices: List<Int>) = dices.nOfAKind(4)
    },
    FULL_HOUSE {
        override fun calculateScore(dices: List<Int>): Int {
            return if (dices.isFullHouse()) 25
            else 0
        }

        private fun List<Int>.isFullHouse(): Boolean {
            val unique = distinct()
            if (unique.size != 2) return false

            val firstDice = unique.first()
            val secondDice = unique.last()

            return countDices(firstDice) <= 3 && countDices(secondDice) <= 3
        }
    },
    SMALL_STRAIGHT {
        private val option1 = listOf(1, 2, 3, 4)
        private val option2 = listOf(2, 3, 4, 5)
        private val option3 = listOf(3, 4, 5, 6)

        override fun calculateScore(dices: List<Int>): Int {
            val firstFour = dices.subList(0, dices.size - 1)
            val lastFour = dices.subList(1, dices.size)

            return if (firstFour.isSmallStraight() || lastFour.isSmallStraight()) 30
            else 0
        }

        private fun List<Int>.isSmallStraight() =
            this == option1 || this == option2 || this == option3
    },
    LARGE_STRAIGHT {
        private val option1 = listOf(1, 2, 3, 4, 5)
        private val option2 = listOf(2, 3, 4, 5, 6)

        override fun calculateScore(dices: List<Int>): Int {
            return if (dices == option1 || dices == option2) 40
            else 0
        }
    };

    internal abstract fun calculateScore(dices: List<Int>): Int

    private companion object {
        private fun List<Int>.countDices(number: Int) = count { it == number }
        private fun List<Int>.sumAllOfNumber(number: Int) = countDices(number) * number

        fun List<Int>.nOfAKind(numberOfSimilarDices: Int): Int {
            val unique = distinct()

            val numberWithNOfAKind = unique.firstOrNull { u ->
                countDices(u) >= numberOfSimilarDices
            } ?: 0

            val scoringDices = filter { it == numberWithNOfAKind }.take(numberOfSimilarDices)

            return scoringDices.sum()
        }
    }
}
