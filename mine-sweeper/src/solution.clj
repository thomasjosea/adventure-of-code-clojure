(def mine-row [0 1 0 1])
(def mine-column [0 1 1 0])
(def grid-size 5)

(def coord-offsets (filter #(not-every? (fn[v] (= v 0)) %) (for [x (range -1 2) y (range -1 2)] [x y])))

;returns a vector with coordinates that are neighbour of 'coord'.
;Filters out all coordinates that fall outside the grid.
(defn valid-offset-coords [coord grid-size] 
  (filter (fn [[x y]] (and (>= (min x y) 0) (< (max x y) grid-size))) (map #(mapv + coord %) coord-offsets)))

(defn create-grid [grid-size] (for [x (range grid-size) y (range grid-size)] [x y]))

;increments a and if a is nil, returns 1
(defn inc-nil [a] (inc (or a 0)))

;for all neighbours of coord, increments their counts of nearby mines
(defn update-nearby-mines [grid coord]	
		(reduce (fn [grid coord](update-in grid [coord :nearby-mines] inc-nil)) grid (valid-offset-coords coord grid-size)))
	
;this method is passed in two vectors of equal length, containing the location of bombs in a grid. 
;the ith index of both vectors form a coordinate where a bomb lies in a grid of size 'grid-size'
(defn create-mine-sweeper-board [rows columns grid-size]
	;mines holds a hash of coords [x y] of bombs
	(let [mines (apply hash-set (map vector rows columns))
		grid-map (reduce 
         		(fn [grid coord] (assoc grid coord {:is-mine (contains? mines coord)}))
      			{}
     			(create-grid grid-size))]
			(reduce update-nearby-mines grid-map mines)))

(let [board (create-mine-sweeper-board mine-row mine-column grid-size)]
	(doseq [row (partition grid-size (create-grid grid-size))]
		(doseq [coord row]
			(let [is-mine (get-in board [coord :is-mine] false)
				  nearby-mines (get-in board [coord :nearby-mines] 0)]
					(print (if (= is-mine true) "B" nearby-mines))))
		(prn)))