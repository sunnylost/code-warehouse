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

(define k 100)
(define x 10.0)

(define (tan-cf x k)
  (cont-frac-iter
    (lambda (k)
      (if (= 1 k)
          x
          (- (* x x))))
    (lambda (i) (- (* 2 i) 1))
    k
    )
  )

(tan-cf
 x
 k
 )