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

;(product identity 1 inc 20)
;(iter-product identity 1 inc 20)

;factorial
(define (factorial n)
  (product identity 1 inc n))

;(factorial 5)

;pi
(define (even? n)
  (= (remainder n 2) 0))

(define (square n)
  (* n n))

(define (pi max)
  (define (next a)
    (+ a 3))

  (define (term a)
    (if (= a 2)
        (identity 2)
        (square a)))

  (define start 2)
  
  (define (quarter)
    (/ (product identity start next max)
       (* max (product identity (inc start) next max)
       )))
  
  (* 4 (quarter))
)

(pi 5)