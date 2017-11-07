#lang racket

(define (square x) (* x x))

(define (compose f1 f2)
  (lambda (x) (f1 (f2 x)))
)

(define (repeated f t)
(define (comp c)
    (if (= t c)
        f
        (compose f (comp (+ 1 c)))
    )
)
(comp 1)
)

((repeated square 3) 4)