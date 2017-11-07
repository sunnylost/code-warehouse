#lang racket

(define (start-segment s)
    (car s))

(define (end-segment s)
    (cdr s))

(define (make-segment a b c d)
    (cons (cons a b)
        (cons c d)))

(define (x-point p)
    (car p))

(define (y-point p)
    (cdr p))

(define (print-point p)
    (newline)
    (display "(")
    (display (x-point p))
    (display ",")
    (display (y-point p))
    (display ")"))

(define (midpoint-segment s)
    (cons (/ (+ (car (start-segment s)) (car (end-segment s))) 2)
        (/ (+ (cdr (start-segment s)) (cdr (end-segment s))) 2)))

(define line (make-segment 3 4 93 120))
(print-point (start-segment line))
(print-point (end-segment line))
(print-point (midpoint-segment line))