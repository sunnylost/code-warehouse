#lang racket
(define (smallest-divisor n)
  (define (divine n a)
    (cond ((> (square a) n) n)
          ((divide? n a) a)
          (else (divine n (+ a 1)))))
  
  (divine n 2))

(define (divide? a b)
  (= (remainder a b) 0))

(define (square n)
  (* n n))

(smallest-divisor 199)
(smallest-divisor 1999)
(smallest-divisor 19999)