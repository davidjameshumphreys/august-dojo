(ns rock.tic
  (:gen-class))

(defn break-string [a]
  (map identity a))


(defn which-side? [game-string]
  (let [os (get (frequencies game-string) \0 0)
        xs (get (frequencies game-string) \x 0)]
    (if
     (> os xs) :x :o)
    ))

(defn random-hyphen-index [game-string]
  (rand-nth (let [z (zipmap (range) game-string)] (filter #(= \- (get z %)) (keys z)))))

(defn parse-rows [board]
  (map #(apply str %) (partition 3 board)))

(defn parse-column [rows x]
  (apply str (map #(nth % x) rows)))

(defn parse-cols [game-string]
  (apply map  (fn [x y z] [x y z]) (partition 3 game-string))
  )
(defn parse-diagonals [board]
  [(map #(nth board %) [0 4 8])
   (map #(nth board %) [2 4 6])])

(defn index-game [game-string]
  (map-indexed hash-map (seq game-string)))

(defn choose-move [game-string]
  (let [rows (parse-rows (index-game game-string))
        columns (parse-cols (index-game game-string) )
        diags (parse-diagonals (index-game game-string))
        lines (concat rows columns diags)]
    (println lines)
    ))


(defn -main [args]
  (println (random-hyphen-index args)))
