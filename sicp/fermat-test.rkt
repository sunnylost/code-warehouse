#lang racket
(define (fast-prime? n times)
  (cond ((= times 0) #t)
        ((fermat-test n) (fast-prime? n (- times 1)))
        (else #f)))

(define (fermat-test n)
  (define (try-it a)
    (= (expmod a n n) a))
  (try-it (+ 1 (random (- n 1)))))

(define (expmod base exp m)
  (cond ((= exp 0) 1)
        ((even? exp)
         (remainder (square (expmod base (/ exp 2) m))
                    m))
         (else
          (remainder (* base (expmod base (- exp 1) m)) m))
         ))

(define (even? n)
  (= (remainder n 2) 0)
  )

(define (square n)
  (* n n)
  )

(fast-prime? 6 5)