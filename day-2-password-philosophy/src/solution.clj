(use '[input :as i])

(defn mapSymbolToOccurrences [x] (reduce (fn [map cur] (update map cur (fnil inc 0))) {} x))

(defn isValidPassword [x] (let [occ (mapSymbolToOccurrences (get x :value))
                                    min (get x :min-occurrences)
                                    max (get x :max-occurrences)
                                    targetLetter (get (get x :letter) 0) ;; simplest way I found to convert string to character
                                    occurrences (get occ targetLetter 0)]
                                (and (>= occurrences min) (<= occurrences max))))

(println (count (filter isValidPassword i/input)))