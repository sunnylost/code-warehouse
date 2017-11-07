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

(define k 11)

(cont-frac-iter
    (lambda (i) 1.0)
    (lambda (i)
       (if (= (remainder (+ i 1) 3) 0)
          (- (+ i 1) (/ (+ i 1) 3))
          1
      ))
    k
)