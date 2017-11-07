#lang racket
(define (fib n)
  (define (inner-fib a b c)
    (if (= 0 c) b
        (inner-fib (+ a b) a (- c 1))))
  
  (inner-fib 1 0 n)
)

(define (even? n)
  (= 0 (remainder n 2)))

(define (fib2 n)
  (fib-iter 1 0 0 1 n))

(define (fib-iter a b p q count)
  (cond ((= count 0) b)
        ((even? count)
         (fib-iter a
                   b 
                   (+ (* p p) (* q q))
                   (+ (* q q) (* 2 p q))
                   (/ count 2)))
        (else (fib-iter (+ (* b q) (* a q) (* a p))
                        (+ (* b p) (* a q))
                        p
                        q
                        (- count 1)))))

(define n 25)
(fib n)
(fib2 n)