(ns reductionist.core-test
  (:require [clojure.test :refer :all]
            [reductionist.core :refer :all :as core]))

(deftest a-test
  (testing "empty reducer"
    (is (= 0 (core/fs-reduce #(+ %1 %2) [] 0))))

  (testing "a reducer"
    (is (= 10 (core/fs-reduce  #(+ %1 %2) [1 2 3 4] 0)))))

(deftest any
  (testing "empty collection"
    (is (= false (core/fs-any?  #(> %1 1) []))))

  (testing "finds something"
    (is (= true (core/fs-any?  #(> %1 1) [4]))))

  (testing "finds nothing"
    (is (= false (core/fs-any?  #(> %1 10) [4 5 8])))))

(deftest filter
  (testing "empty collection"
    (is (= [] (core/fs-filter #(> %1 1) []))))

  (testing "filter stuff out"
    (is (= [2 7] (core/fs-filter #(> %1 1) [2 1 7])))))
