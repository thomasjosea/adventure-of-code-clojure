(require '[toboggan-trajectory :as t])

(def direction [3 1])
(def path (clojure.string/split-lines (slurp "src/input.txt")))

(print "there are" (t/count-trees-in-path path direction) "trees along the direction" direction)