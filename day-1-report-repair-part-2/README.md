## Problem description

In your expense report, what is the product of the three entries that sum to 2020?


## Solution

The proposed solution generates a cartesian product from the input set, to create all possible 2 element combination, similar to what a double foor loop would do. It then tries to find a number that makes the sum be 2020 in a hash containing all elements.
The result is then filtered for all distinct results and printed.
The solution tries leverage filters and maps instead of for loops, which would be more memory friendly in this case.