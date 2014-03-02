#lang racket
(define (sqrt-iter x guess pre-guess)
  (if (good-enough? guess pre-guess)
      guess
      (sqrt-iter x (improve guess x) guess)))

(define min-offset 0.00001)

(define (good-enough? guess pre-guess)
  (< (/ (abs (- guess pre-guess)) guess) min-offset))

(define (improve guess x)
  (average guess (/ x guess)))

(define (average x y)
  (/ (+ x y) 2))

(sqrt-iter 4 1.0 0)