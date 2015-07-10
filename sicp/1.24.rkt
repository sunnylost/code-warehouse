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
    (if (fast-prime? num 5)
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


(define count 3)
(search-for-primes 1000 count)
(search-for-primes 10000 count)
(search-for-primes 100000 count)
(search-for-primes 1000000 count)
(search-for-primes 10000000 count)