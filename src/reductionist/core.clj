(ns reductionist.core
  (:gen-class))

(defn fs-reduce [function collection accumulator]
    (if (empty? collection)
      accumulator
      (let [one  (first collection)
            others (rest collection)
            new-acc (function one accumulator)]
        (recur function others new-acc))))


(defn fs-any? [function collection]
  (fs-reduce #(or (function %1) %2) collection false))


(defn fs-filter [function collection]
  (reverse 
    (fs-reduce #(if (function %1) (cons %1 %2) %2) collection [])))
