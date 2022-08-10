# Yahtzee Kata Kotlin 🎲

- [Code kata](https://codingdojo.org/kata/Yahtzee/)
- [Yahtzee rules](https://en.wikipedia.org/wiki/Yahtzee#Rules)

## Todo List

- ~~Chance~~
- ~~Yahtzee~~
- ~~Numerics~~
  - ~~aces~~
  - ~~twos~~
  - ~~threes~~
  - ~~fours~~
  - ~~fives~~
  - ~~sixes~~
- ~~Straights~~
  - ~~small~~
  - ~~large~~
- ~~Kinds~~
  - ~~Three of a kind~~
  - ~~Four of a kind~~
  - ~~Full house~~
- ~~Try to break it~~
  - ~~Negative dices~~
  - ~~Dices larger than six~~

## Reflection

Some reflections in order to learn from the code kata.

### What did I learn?

* **Solutions can be easier than you think**.
  For full house and straights I thought of very complex scenarios first.
  The tests helped me see that there weren't that many scenarios possible to begin with.
  This meant I could keep the solution much simpler.
* **Enums are excellent for cases where you know the variations at compile time.**
  I solved the categories and the dices with enums. After doing that, I noticed that categories
  each correspond to a score calculation. This made the enum itself a nice place to hold the logic.

### What would I do differently?

* Solve this using objects and a sealed interface (scala enum style).
* Solve this using functions, instead of with enums.
