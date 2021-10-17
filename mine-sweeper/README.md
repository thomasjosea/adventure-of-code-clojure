This is a clojure solution for an interview code challenge I came across a while ago.

The input for it are two vectors, the X position of bombs, and the Y position of bombs, and a grid size.

Its output is printing a mine sweeper board with bomb positions and the amount of nearby bombs for each grid element that is not a bomb.

For example, if the input was:

* X = [0 1]
* Y = [1 1]
* grid size = 4

The output would be:

2B20

2B20

1110

0000
