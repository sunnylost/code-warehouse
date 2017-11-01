#lang racket
(define (* a b)
  (define (inner-mult a b r)
    (cond ((= 0 a) 0)
          ((= 1 a) (+ b r))
          ((even? a) (inner-mult (halve a) (double b) r))
          (else (inner-mult (- a 1) b (+ r b)))))
  
  (inner-mult a b 0)
)

(define (double n)
  (+ n n))

(define (halve n)
  (/ n 2))

(define (even? n)
  (= (halve n) 0))

(* 13 6)