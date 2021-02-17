(use '[input :as i])

(defn xor [a b]
  (cond
    (and (not b) a) true
    (and (not a) b) true
    :else false))

(defn isValidPassword [x] (let [password (get x :value)
                                min (- (get x :min-index) 1)
                                max (- (get x :max-index) 1)
                                targetLetter (get (get x :letter) 0) ;; simplest way I found to convert string to character
                                ]
                            (xor (= targetLetter (get password min)) (= targetLetter (get password max)))))

(println (count (filter isValidPassword i/input)))