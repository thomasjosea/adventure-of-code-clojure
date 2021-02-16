## Problem description

Suppose you have the following list:

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc

Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.

In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.

How many passwords are valid according to their policies?

## Solution

To help solving this problem I ended up parsing the input text file into a clj variable using [this helper bash script](./helper/convert-to-clojure-hashmap.sh).
It outputs a file that I can use in my solution and have all entries properly formatted in a hashmap.

The proposed solution consists of creating a map where each key is a letter and the value is how many times this letter appears in the password, using the reduce method. Once that has been computed, it's a matter of checking whether the target letter is within the desired range.
