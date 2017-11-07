#lang racket

(define tolerance 0.00001)

(define (average a b)
  (/ (+ a b) 2))

(define (average-damp f)
  (lambda (x) (average x (f x))))

(define (fixed-point f first-guess)
  (define (close-enough? a1 a2) (< (abs (- a1 a2)) tolerance))
  (define (try guess)
    (newline)
    (display "guessed number:")
    (display guess)
    (let ((next (f guess)))
      (if (close-enough? guess next)
          next
          (try next))))
    (try first-guess))

(fixed-point (lambda (x) (/ (log 1000) (log x))) 2.0)
(newline)
(display "after using average damp...")
(newline)
(fixed-point (average-damp (lambda (x) (/ (log 1000) (log x)))) 2.0)