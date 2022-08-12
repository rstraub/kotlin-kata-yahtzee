/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.base

import kata.base.Category.*

private fun chance(dices: List<Dice>) = dices.sum()
private fun yahtzee(dices: List<Dice>) =
    if (dices.toSet().size == 1) 50
    else 0

private fun aces(dices: List<Dice>) = dices.sumAllOfNumber(Dice.ONE)
private fun twos(dices: List<Dice>) = dices.sumAllOfNumber(Dice.TWO)
private fun threes(dices: List<Dice>) = dices.sumAllOfNumber(Dice.THREE)
private fun fours(dices: List<Dice>) = dices.sumAllOfNumber(Dice.FOUR)
private fun fives(dices: List<Dice>) = dices.sumAllOfNumber(Dice.FIVE)
private fun sixes(dices: List<Dice>) = dices.sumAllOfNumber(Dice.SIX)
private fun threeOfAKind(dices: List<Dice>) = dices.nOfAKind(3)
private fun fourOfAKind(dices: List<Dice>) = dices.nOfAKind(4)
private fun fullHouse(dices: List<Dice>): Int {
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


private fun smallStraight(dices: List<Dice>): Int {
    val firstFour = dices.subList(0, dices.size - 1)
    val lastFour = dices.subList(1, dices.size)

    return if (firstFour.isSmallStraight() || lastFour.isSmallStraight()) 30
    else 0
}

private fun List<Dice>.isSmallStraight(): Boolean {
    val option1 = listOf(Dice.ONE, Dice.TWO, Dice.THREE, Dice.FOUR)
    val option2 = listOf(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE)
    val option3 = listOf(Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.SIX)

    return this == option1 || this == option2 || this == option3
}

private fun largeStraight(dices: List<Dice>): Int {
    val option1 = listOf(Dice.ONE, Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE)
    val option2 = listOf(Dice.TWO, Dice.THREE, Dice.FOUR, Dice.FIVE, Dice.SIX)

    return if (dices == option1 || dices == option2) 40
    else 0
}

private fun List<Dice>.sum() = map(Dice::points).sum()
private fun List<Dice>.countDices(number: Dice) = count { it == number }
private fun List<Dice>.sumAllOfNumber(number: Dice) = countDices(number) * number.points

private fun List<Dice>.nOfAKind(numberOfSimilarDices: Int): Int {
    val unique = distinct()

    val numberWithNOfAKind = unique.firstOrNull { u ->
        countDices(u) >= numberOfSimilarDices
    } ?: 0

    val scoringDices = filter { it == numberWithNOfAKind }.take(numberOfSimilarDices)

    return scoringDices.sum()
}


class Yahtzee {
    companion object {
        fun score(
            category: Category,
            dice1: Dice,
            dice2: Dice,
            dice3: Dice,
            dice4: Dice,
            dice5: Dice
        ): Int {
            val dices = listOf(
                dice1,
                dice2,
                dice3,
                dice4,
                dice5
            )

            val scoringFn = when (category) {
                CHANCE -> ::chance
                YAHTZEE -> ::yahtzee
                ACES -> ::aces
                TWOS -> ::twos
                THREES -> ::threes
                FOURS -> ::fours
                FIVES -> ::fives
                SIXES -> ::sixes
                THREE_OF_A_KIND -> ::threeOfAKind
                FOUR_OF_A_KIND -> ::fourOfAKind
                FULL_HOUSE -> ::fullHouse
                SMALL_STRAIGHT -> ::smallStraight
                LARGE_STRAIGHT -> ::largeStraight
            }

            return scoringFn(dices)
        }
    }
}


fun main() = print("Hello, Yahtzee!")
