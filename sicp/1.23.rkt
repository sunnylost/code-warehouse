#lang racket
(define (search-for-primes n times)
  (newline)
  (newline)
  (display "less than ")
  (display n)
  (display "'s prims is")
  (newline)
  (define start-time (current-inexact-milliseconds))
  
  (define (find-n-primes num index)
    (if (prime? num)
        (begin
          (display " *** ")
          (display num)
         (newline)
        (if (= index times)
            (time-cost start-time)
            (find-n-primes (next-odd num) (+ 1 index))))
        (find-n-primes (next-odd num) index)))
  
  (find-n-primes n 1)
  )

(define (next-odd n)
  (if (odd? n)
      (+ n 2)
      (+ n 1)))

(define (time-cost start)
  (display "time cost ")
  (display (- (current-inexact-milliseconds) start))
  )

(define (smallest-divisor n)
  (define (divine n a)
    (cond ((> (square a) n) n)
          ((divide? n a) a)
          (else (divine n (next a)))))
  
  (divine n 2))

(define (divide? a b)
  (= (remainder a b) 0))

(define (next n)
  (if (= n 2)
      3
      (+ n 2)))

(define (square n)
  (* n n))

(define (even? n)
  (= (remainder n 2) 0))

(define (prime? n)
  (if (= (smallest-divisor n) n)
      #t
      #f))

(define count 3)
(search-for-primes 1000 count)
(search-for-primes 10000 count)
(search-for-primes 100000 count)
(search-for-primes 1000000 count)