#lang racket
(define (timed-prime-test n)
  (newline)
  (start-prime-test n (current-inexact-milliseconds)))

(define (start-prime-test n start-time)
  (if (prime? n)
      (report-prime (- (current-inexact-milliseconds) start-time))
      " is not a prime."))

(define (report-prime elapsed-time)
  (display " *** ")
  (display elapsed-time))

(define (smallest-divisor n)  
  (define (divine n a)
    (cond ((>= a n) n)
          ((divide? n a) a)
          (else (divine n (next a)))))
  
  (divine n 2))

(define (next a)
  (if (= a 2)
      3
      (+ a 2)))

(define (even? n)
  (= (remainder n 2) 0))

(define (divide? a b)
  (= (remainder a b) 0))

(define (prime? n)
  (if (= (smallest-divisor n) n)
      (display n)
      (if (even? n)
          (prime? (+ n 1))
          (prime? (+ n 2)))))

(timed-prime-test 1000)
(timed-prime-test 10000)
(timed-prime-test 100000)
(timed-prime-test 1000000)