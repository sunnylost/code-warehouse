#lang racket
(define (identity n) n)

(define (inc n)
  (+ n 1))

(define (add a b)
  (+ a b))

(define (accumulate combiner null-value term a next b)
  (define (inner-pass n)
    (if (> n b) null-value
        (combiner (term n)
                  (inner-pass (next n)))))

  (inner-pass a))

(define (sum a b)
  (accumulate add 0 identity a inc b))

(sum 2 6)

