(require '[toboggan-trajectory :as t])

(def directions [[1 1] [3 1] [5 1] [7 1] [1 2]])
(def path (clojure.string/split-lines (slurp "src/input.txt")))

(print "the product of all trees found in the traversed directions is" 
       (apply * (reduce #(conj %1 (t/count-trees-in-path path %2)) [] directions)))