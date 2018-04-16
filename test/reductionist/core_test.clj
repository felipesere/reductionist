(ns reductionist.core-test
  (:require [clojure.test :refer :all]
            [reductionist.core :refer :all :as core]))

(deftest reducer-tests
    (is (= 0 (core/fs-reduce #(+ %1 %2) [] 0)))
    (is (= 10 (core/fs-reduce  #(+ %1 %2) [1 2 3 4] 0))))

(deftest any-tests
    (is (= false (core/fs-any?  #(> %1 1) [])))
    (is (= true (core/fs-any?  #(> %1 1) [4])))
    (is (= false (core/fs-any?  #(> %1 10) [4 5 8]))))

(deftest filter-test
    (is (= [] (core/fs-filter #(> %1 1) [])))
    (is (= [2 7] (core/fs-filter #(> %1 1) [2 1 7]))))
