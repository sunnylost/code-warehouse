#lang racket

(define (append list1 list2)
    (if (null? list1)
        list2
        (cons (car list1) (append (cdr list1) list2))))

;2.17
(define (last-pair items)
    (if (null? (cdr items))
        (car items)
        (last-pair (cdr items))))

;(last-pair (list 23 32 93 23))

;2.18
(define (reverse items)
    (if (null? items)
        `()
        (append (reverse (cdr items)) (list (car items)))))

;(reverse (list 1 3 9 19 32))

;2.19
(define (cc amount coin-values)
    (cond ((= amount 0) 1)
            ((or (< amount 0) (no-more? coin-values)) 0)
            (else
                (+ (cc amount
                        (except-first-denomination coin-values))
                    (cc (- amount
                            (first-denomination coin-values))
                        coin-values)))))

(define (first-denomination coins)
    (if (null? coins)
        0
        (car coins)))

(define (except-first-denomination coins)
    (cdr coins))

(define (no-more? coins)
    (null? coins))

(define us-coins (list 50 25 10 5 1))

(define uk-coins (list 100 50 20 10 5 2 1 0.5))

;(cc 100 uk-coins)

;2.20
(define (same-parity a . b)
    (define (inner-filter items filter)
        (if (null? items)
            `()
            (append
                (if (filter (car items))
                    (list (car items))
                    `()
                )
            (inner-filter (cdr items) filter))))
    (inner-filter
        (cons a b)
        (if (even? a)
            even?
            odd?)
    )
)

;(same-parity 1 2 3 4 5 6 7 10)

;2.21
(define nil `())

(define (map proc items)
    (if (null? items)
        nil
        (cons (proc (car items))
              (map proc (cdr items)))))

;(map (lambda (x) (* x 10)) (list 1 2 3 4 5))
(define (square x) (* x x))

(define (square-list items)
    (map square items))

;(square-list (list 1 2 3 4))

(define (square-list1 items)
    (define (iter things answer)
        (if (null? things)
            answer
            (iter (cdr things)
                (cons (square (car things))
                        answer))))
    (iter items nil))

;(square-list1 (list 2 3 4 5))

;2.23
(define (for-each proc items)
    (if (null? (cdr items))
        (proc (car items))
        (begin
            (proc (car items))
            (for-each proc (cdr items))
        )
    )
)

(for-each (lambda (x) (newline) (display x)) (list 239 32 2))