#lang racket

(define tolerance 0.00001)

(define (fixed-point f first-guess)
  (define (close-enough? a1 a2) (< (abs (- a1 a2)) tolerance))
  (define (try guess)
    (let ((next (f guess)))
      (if (close-enough? guess next)
          next
          (try next))))
    (try first-guess))

(fixed-point (lambda (x) (+ 1 (/ 1 x))) 1.0)