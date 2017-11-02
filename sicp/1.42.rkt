#lang racket

(define (square x) (* x x))
(define (inc x) (+ 1 x))

(define (compose f1 f2)
  (lambda (x) (f1 (f2 x))))

((compose square inc) 5)