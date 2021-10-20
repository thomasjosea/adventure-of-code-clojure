Problem description:
Given the input file `src/input.txt` and a walking direction [x y], we need to compute all trees that exist in this path until the end of the file is reached. A tree is denoted by a #.
The input may need to be replicated in the x direction in order to avoid index out of range exception.

Problem solution:
For this problem I decided to generate a lazy sequence that creates all needed positions that the algorithm must visit. The number of positions I need to visit (and generate) is represented by the total lines in the path divided by how many lines down I walk in each step.

Then it's a matter of using the current x coordinate to determine the line, and the y coordinate to determine the column, which I need to mod by the length of each line to account for indices that would've been out of range otherwise.

--- 

To execute the problem, make sure you're one folder above the src/, and run `clj src/part_1.clj` or `src/part_2.clj` for each of the problem parts. Part 2 differs from the first by giving a set of directions that must be used, and needs to compute tree count for all such directions.
