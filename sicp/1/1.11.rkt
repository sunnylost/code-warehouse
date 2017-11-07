#lang racket
(define (fn-rec n)
  (cond ((< n 3) n)
        ((>= n 3) (+ (fn-rec (- n 1))
                     (* 2 (fn-rec (- n 2)))
                     (* 3 (fn-rec (- n 3)))))))

(define (fn-iter n)
  (define (iter index a b c)
    (define x (+ a (* 2 b) (* 3 c)))
    (if (>= index n)
        x
        (iter (+ index 1) x a b)
    )
  )
  (iter 3 2 1 0)
  )

(define n 25)
(fn-rec n)
(fn-iter n)