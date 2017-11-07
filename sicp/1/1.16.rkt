#lang racket
(define (iter-expt b n)
  (define (inner-iter-expt b n r)
    (cond ((or (= n 0) (= n 1)) r)
          ((even? n) (inner-iter-expt b (/ n 2) (* r r)))
          (else (inner-iter-expt b (- n 1) (* r b))))
    )
  (inner-iter-expt b n b)
)

(define (even? a)
    (= (remainder a 2) 0)
)

(iter-expt 2 9)