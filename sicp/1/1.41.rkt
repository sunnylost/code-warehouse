#lang racket

(define (inc x) (+ 1 x))

(define (double f)
  (lambda (x) (f (f x))))


(((double (double double)) inc) 5)
((double inc) 5)