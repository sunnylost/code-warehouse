#lang racket

(define zero
  (lambda (f)
    (lambda (x) x)))

(define (add-1 n)
  (lambda (f)
    (lambda (x)
      (f ((n f) x)
         )
      )
    )
  )

(define (add-2 n)
  (lambda (f)
    (lambda (x)
      (f
       (f ((n f) x)))
      )
    )
  )

(define one
    (lambda (f) (lambda (x) (f x))))

(define two
    (lambda (f) (lambda (x) (f (f x)))))

(define three
    (lambda (f) (lambda (x) (f (f (f x))))))

(define (add a b)
  (lambda (f)
    (lambda (x)
      (
       (b f) ((a f) x))
      )
    )
  )

(define (mul a b)
  (lambda (f)
    (lambda (x)
      ((a (b f)) x)
      )
    )
  )

(define (power a b)
  (lambda (f)
    (lambda (x)
      (((b a) f) x)
      )
    )
  )

(((power three three) (lambda (x) 
        (print x)
        (newline)
        x))
 "a"
)