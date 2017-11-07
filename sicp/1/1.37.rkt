#lang racket

(define (cont-frac-iter n d k)
    (define (comp k r)
        (if (= 0 k)
            r
            (comp (- k 1) (/ (n k) (+ (d k) r))
        )
    ))
    (comp k 0)
)

(define (cont-frac-rec n d k)
    (define (comp c)
        (if (= c k)
            (/ (n c) (d c))
            (/ (n c) (+ (d c) (comp (+ 1 c))))
            )
      )
    (comp 1)
)

(define k 11)

(cont-frac-iter
    (lambda (i) 1.0)
    (lambda (i) 1.0)
    k
)

(cont-frac-rec
    (lambda (i) 1.0)
    (lambda (i) 1.0)
    k
)