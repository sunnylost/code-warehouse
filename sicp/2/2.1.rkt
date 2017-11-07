#lang racket

(define (negative x)
  (if (< x 0)
    x
    (- x)
  )
)

(define (make-rat n d) 
  (if (or (< n 0) (< d 0))
    (cons (negative n) (abs d))
    (cons n d)
  )
)
(define (numer x) (car x))
(define (denom x) (cdr x))