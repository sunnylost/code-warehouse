#lang racket
(define (cube-root x guess pre-guess)
  (if (good-enough? guess pre-guess)
      guess
      (cube-root x (improve guess x) guess)))

(define min-offset 0.00001)

(define (good-enough? guess pre-guess)
  (< (/ (abs (- guess pre-guess)) guess) min-offset))

(define (improve guess x)
  (third (/ x (* guess guess)) (* 2 guess)))

(define (third x y)
  (/ (+ x y) 3))

(cube-root 27 1.0 0)