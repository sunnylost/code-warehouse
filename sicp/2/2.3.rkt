#lang racket

; (define (rect w h)
;     (cons w h))

; (define (width r)
;     (car r))

; (define (height r)
;     (cdr r))

(define (rect l t r b)
    (cons (cons l r)
        (cons t b)))

(define (width r)
    (car (car r)))

(define (height r)
    (car (cdr r)))

(define (perimeter r)
    (* 2 (+ ( width r)
        (height r))))

(define (area r)
    (* (width r) (height r)))

(define (print-rect r)
    (newline)
    (display "width:")
    (display (width r))
    (newline)
    (display "height:")
    (display (height r)))

;(define r (rect 5 10))
(define r (rect 5 10 5 10))
;(print-rect r)
(perimeter r)
(area r)