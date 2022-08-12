package kata.base

fun chance(dices: List<Dice>) = dices.sum()
fun yahtzee(dices: List<Dice>) =
    if (dices.toSet().size == 1) 50
    else 0

fun aces(dices: List<Dice>) = dices.sumAllOfNumber(Dice.ONE)
fun twos(dices: List<Dice>) = dices.sumAllOfNumber(Dice.TWO)
fun threes(dices: List<Dice>) = dices.sumAllOfNumber(Dice.THREE)
fun fours(dices: List<Dice>) = dices.sumAllOfNumber(Dice.FOUR)
fun fives(dices: List<Dice>) = dices.sumAllOfNumber(Dice.FIVE)
fun sixes(dices: List<Dice>) = dices.sumAllOfNumber(Dice.SIX)
fun threeOfAKind(dices: List<Dice>) = dices.nOfAKind(3)
fun fourOfAKind(dices: List<Dice>) = dices.nOfAKind(4)
fun fullHouse(dices: List<Dice>): Int {
    return if (dices.isFullHouse()) 25
    else 0
}

fun List<Dice>.isFullHouse(): Boolean {
    val unique = distinct()
    if (unique.size != 2) return false

    val firstDice = unique.first()
    val secondDice = unique.last()

    return countDices(firstDice) <= 3 && countDices(secondDice) <= 3
}


fun smallStraight(dices: List<Dice>): Int {
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

fun largeStraight(dices: List<Dice>): Int {
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

