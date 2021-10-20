(ns toboggan-trajectory)

(def tree-symbol \#)

;creates lazy-seq walking towards a direction expressed by a length 2 vectors in the format [x y]
(defn walking-positions-in-direction
  ([dir] (walking-positions-in-direction [0 0] dir))
  ([pos dir] (lazy-seq (cons pos (walking-positions-in-direction (mapv + pos dir) dir)))))

;given a trajectory (vector of strings), and a walking direction (a vector in the format [x y]), outputs the number of trees
;encountered in the traversed directory until the end of the path.
(defn count-trees-in-path [trajectory dir]
  (let [necessary-steps (/ (count trajectory) (get dir 1))
        positions (take necessary-steps (walking-positions-in-direction dir))
        x-length (count (get trajectory 0))]
    (reduce
     (fn [total-trees [x y]] (let [row (or (get trajectory y) [])
                                   cur-element (or (get row (mod x x-length)) \.)]
                               (if (= cur-element tree-symbol) (inc total-trees) total-trees)))
     0 positions)))