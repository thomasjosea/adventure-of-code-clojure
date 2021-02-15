(use '[input :as i])

(def inputset (set i/input))
(def expected 2020)

;; Checks whether the sum of elements in vector returns the expected sum. All vector elements must be positive.
(defn sumsToExpected [a] (and (= expected (apply + a)) (every? pos? a)))

;; Gets a three-element vector where the 2 first are the cartesian product of the input set, and the third is either a compliment that makes the sum be the expected, or zero. 
(defn getVectorWithPossibleCompliment [pair] (let [sum (apply + pair)
                                                   complimentOrZero (get inputset (- expected sum) 0)]
                                               (conj pair complimentOrZero)))

(println (distinct (map #(apply * %) (filter sumsToExpected (map getVectorWithPossibleCompliment
                                                                 (for [x i/input y i/input]
                                                                   (vector x y)))))))