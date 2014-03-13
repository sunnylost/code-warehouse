#lang racket
(define (smallest-divisor n)
  (define (divine n a)
    (cond ((>= a n) n)
          ((divide? n a) a)
          (else (divine n (+ a 1)))))
  
  (divine n 2))

(define (divide? a b)
  (= (remainder a b) 0))

(smallest-divisor 199)
(smallest-divisor 1999)
(smallest-divisor 19999)