(defn steps
  ([] (steps [1 1]))
  ([n] (let [x (first n) y (last n)]
         (lazy-seq (cons n (steps [(inc x) (+ 3 y)]))))))