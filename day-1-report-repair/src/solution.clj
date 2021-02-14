(use '[input :as i])

(def inputset (set i/input))
(def expectedsum 2020)

(println
    (distinct
    (map #(apply * %)
    (filter #(= expectedsum (apply + %))
    (map 
        #(vector % (get inputset (- expectedsum %) 0))
        inputset)))))