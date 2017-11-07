#lang racket

;Exercise 1.3: Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(define (square a b)
    (+ (* a a) (* b b))
)

(define (sum-of-two a b c)
    (cond 
        ((and (> a b) (> c b)) (square a c))
        ((and (> a c) (> b c)) (square a b))
        (else (square b c))
    )
)

(sum-of-two 4 3 5)