#lang racket
(define (sum term a next b)
  (if (> a b)
      0
      (+ (term a)
         (sum term (next a) next b))))

(define (integral f a b dx)
  (define (add-dx x) (+ x dx))
  (* (sum f (+ a (/ dx 2.0)) add-dx b)
     dx))

(define (cube n)
  (* (* n n) n))

(define (even? n)
  (= (remainder n 2) 0))

#;Simpson
(define (simpson-sum f a b n)    
  (define h (/ (- b a) n))
  (define (term n)
     (* (if (even? n) 2 4) (f (+ a (* h n)))))
  (define (next n) (+ n 1))
  
   (* (/ h 3) (+ (/ (term 0) 2) (sum term 1 next (- n 1)) (/ (term n) (if (even? n) 2 4)))))

(integral cube 0 1 0.01)
(simpson-sum cube 0 1 100.0)
(integral cube 0 1 0.001)
(simpson-sum cube 0 1 1000.0)