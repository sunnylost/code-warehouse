#lang racket

;Exercise 1.3: Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(define (square x)
    (* x x)
  )

(define (square-sum a b)
  (+
   (square a)
   (square b)
     )
  )

(define (sum-of-two a b c)
    (cond 
        ((and (> a b) (> c b)) (square-sum a c))
        ((and (> a c) (> b c)) (square-sum a b))
        (else (square-sum b c))
    )
  )

(sum-of-two 4 3 5)