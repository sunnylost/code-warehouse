#lang racket
(define (pascal-tri row col)
  (cond ((= col 1) 1)
        ((= row col) 1)
        (else (+ (pascal-tri (- row 1) (- col 1)) (pascal-tri (- row 1) col)))
        )
  )

(pascal-tri 6 3)