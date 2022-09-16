# John Conway's Game of Life

Simulating the popular 0 player game of Game of Life using Java. The simulation allows you to initialize the cell with a Random pattern, a Simkin glider run or a Penta-devathlon Oscillator.

## Try it out

To compile: javac *.java

To run: java Life n s p

- where n is the number of iterations (any integer)
- where s is the size of the square grid (any integer)
- where p is which pattern type to initialize the cells with: P, S or R
o Penta-decathlon Oscillator (enter P)
o Simkin glider gun (enter S)
o Random (enter R)

example: java Life 500 80 R

## Author

Life.java = Apurva Acharya
Picture.java = Robert Sedgewick and Kevin Wayne
