#lang racket

(define (exp a b)
    (define (inner-iter r count)
        (if (= b count)
            r
            (inner-iter (* r a) (+ 1 count)))
    )
    (inner-iter a 1))

(define (cons x y)
    (* (exp 2 x)
        (exp 3 y))
)

(define (car c)
    (if (= 0 (remainder c 2))
        (+ 1 (car (/ c 2)))
        0
    )
)

(define (cdr c)
    (if (= 0 (remainder c 3))
        (+ 1 (cdr (/ c 3)))
        0
    )
)

(define c (cons 8 6))
(car c)
(cdr c)