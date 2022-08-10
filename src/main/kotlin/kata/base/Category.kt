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
        override fun calculateScore(dices: List<Int>) = numerics(dices, 1)
    },
    TWOS {
        override fun calculateScore(dices: List<Int>) = numerics(dices, 2)
    },
    THREES {
        override fun calculateScore(dices: List<Int>) = numerics(dices, 3)
    },
    FOURS {
        override fun calculateScore(dices: List<Int>) = numerics(dices, 4)
    },
    FIVES {
        override fun calculateScore(dices: List<Int>) = numerics(dices, 5)
    },
    SIXES {
        override fun calculateScore(dices: List<Int>) = numerics(dices, 6)
    },
    THREE_OF_A_KIND {
        override fun calculateScore(dices: List<Int>) = nOfAKind(3, dices)
    },
    FOUR_OF_A_KIND {
        override fun calculateScore(dices: List<Int>) = nOfAKind(4, dices)
    },
    FULL_HOUSE {
        override fun calculateScore(dices: List<Int>): Int {
            val unique = dices.distinct()
            if (unique.size != 2) return 0

            val firstDice = unique.first()
            val countOfFirstDices = dices.count { it == firstDice }

            val secondDice = unique[1]
            val countOfSecondDices = dices.count { it == secondDice }

            return if (countOfFirstDices > 3 || countOfSecondDices > 3) 0
            else 25
        }
    },
    SMALL_STRAIGHT {
        private val option1 = listOf(1, 2, 3, 4)
        private val option2 = listOf(2, 3, 4, 5)
        private val option3 = listOf(3, 4, 5, 6)

        override fun calculateScore(dices: List<Int>): Int {
            if (dices.subList(0, dices.size - 1) == option1) return 30
            return 0
        }
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
        private fun numerics(dices: List<Int>, score: Int) = dices.filter { it == score }.sum()

        fun nOfAKind(requiredSimilarDices: Int, dices: List<Int>): Int {
            val unique = dices.distinct()

            val numberWithNOfAKind = unique.firstOrNull { u ->
                dices.count { it == u } >= requiredSimilarDices
            } ?: 0

            val scoringDices = dices.filter { it == numberWithNOfAKind }.take(requiredSimilarDices)

            return scoringDices.sum()
        }
    }
}
