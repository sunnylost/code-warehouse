#lang racket
(define (identity n) n)

(define (inc n)
  (+ n 1))

(define (add a b)
  (+ a b))

(define (pass a)
  #t)

(define (filtered-accumulate filter? combiner null-value term a next b)
  (define (inner-pass n)
    (define (lval n)
      (if (filter? n)
          n
          null-value))
    
    (if (> n b) null-value
        (combiner (lval (term n))
                  (inner-pass (next n)))))

  (inner-pass a))

(define (sum a b)
  (filtered-accumulate pass add 0 identity a inc b))

(sum 2 6)

