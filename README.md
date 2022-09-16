# John Conway's Game of Life

Simulating the popular 0 player game of Game of Life using Java. The simulation allows you to initialize the cells with a Random pattern, a Simkin glider run or a Penta-decathlon Oscillator.

## Try it out

To compile: javac *.java

To run: java Life n s p

- where n is the number of iterations (any integer)
- where s is the size of the square grid (any integer)
- where p is which pattern type to initialize the cells with: P, S or R
-- Penta-decathlon Oscillator (enter P)
-- Simkin glider gun (enter S)
-- Random (enter R)

example: java Life 500 80 R

## Author

- Life.java = Apurva Acharya
- Picture.java = Robert Sedgewick and Kevin Wayne
