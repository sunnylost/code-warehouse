#lang racket

(define (add-interval x y)
    (make-interval 
        (+ (lower-bound x) (lower-bound y))
        (+ (upper-bound x) (upper-bound y))))

(define (mul-interval x y)
    (let ((p1 (* (lower-bound x) (lower-bound y)))
            (p2 (* (lower-bound x) (upper-bound y)))
            (p3 (* (upper-bound x) (lower-bound y)))
            (p4 (* (upper-bound x) (upper-bound y))))
    (make-interval 
        (min p1 p2 p3 p4)
        (max p1 p2 p3 p4))))

(define (div-interval x y)
    (mul-interval 
        x
        (make-interval 
            (/ 1.0 (upper-bound y))
            (/ 1.0 (lower-bound y)))))

(define (print-interval p)
    (display "[")
    (display (lower-bound p))
    (display "-")
    (display (upper-bound p))
    (display "]")
    (newline))

;2.7
(define (make-interval a b)
    (cons a b))

(define (upper-bound p)
    (cdr p))

(define (lower-bound p)
    (car p))

(define p1 (make-interval 2 15.6))
(define p2 (make-interval 8.6 12.9))

(print-interval p1)
(print-interval p2)
(display "add:")
(print-interval (add-interval p1 p2))
(display "mul:")
(print-interval (mul-interval p1 p2))
(display "div:")
(print-interval (div-interval p1 p2))

;2.8
(define (sub-interval x y)
    (let ((v1 (abs (- (lower-bound x) (lower-bound y))))
          (v2 (abs (- (upper-bound x) (upper-bound y)))))
        (make-interval 
            (min v1 v2)
            (max v1 v2)))
    )

(display "sub:")
(print-interval (sub-interval p1 p2))