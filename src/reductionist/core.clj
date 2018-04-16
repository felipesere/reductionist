(ns reductionist.core
  (:gen-class))

(defn fs-reduce [function collection accumulator]
    (if (empty? collection)
      accumulator
      (let [[one & others] collection
            new-acc (function one accumulator)]
        (recur function others new-acc))))

(defn fs-any? [function collection]
  (fs-reduce #(or (function %1) %2) collection false))


(defn fs-filter [function collection]
  (fs-reduce #(if (function %1) (concat %2 [%1]) %2) collection []))

