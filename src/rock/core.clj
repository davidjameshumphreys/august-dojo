(ns rock.core
  (:gen-class))

(defn -main [& args]
  (println (rand-nth ["rock" "paper" "scissors"]))
)
