#lang racket
(define (product term a next b)
  (if (> a b)
      1
      (* (term a)
         (product term (next a) next b))))

(define (iter-product term a next b)
  (define (iter a result)
    (if (> a b)
        result
        (iter (next a) (* result (term a)))))
  
  (iter a 1))

(define (inc n) (+ n 1))
(define (identity n) n)

(product identity 1 inc 20)
(iter-product identity 1 inc 20)