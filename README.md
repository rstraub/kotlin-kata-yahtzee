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

* **Testing behavior != Test per class**

This is an anti-pattern I have followed since the very beginning of my career.
Recently, I learned about another approach: to write tests for behavior. Sounds logical but it is
more complicated than that.
This code kata I tried to consciously apply it, in order to learn. What I've found in this case is
intriguing.

What I did was only test the API `Yahtzee` offers, which can be regarded as the public api for the
component. These are my observations:

1. It caused the test file to be larger than testing classes in isolation, which can be countered by
   having multiple test files exercising `Yahtzee`'s API.
2. Refactoring the implementation was noticeably easier, because there was almost no coupling to the
   internals due to tests.
3. Tests became much more functional, instead of technical.

All in all, I liked this approach and intend to apply it going forward.

* **Solutions can be easier than you think**

For full house and straights I thought of very complex scenarios first.
The tests helped me see that there weren't that many scenarios possible to begin with.
This meant I could keep the solution much simpler.

* **Enums are excellent for cases where you know the variations at compile time**

I solved the categories and the dices with enums. After doing that, I noticed that categories
each correspond to a score calculation. This made the enum itself a nice place to hold the logic.

### What would I do differently?

* Solve this using objects and a sealed interface (scala enum style).
* Solve this using functions, instead of with enums.
