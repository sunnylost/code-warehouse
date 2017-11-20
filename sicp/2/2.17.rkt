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
 
;(for-each (lambda (x) (newline) (display x)) (list 239 32 2))


;
(define (length items) (
    if (null? items)
        0
        (+ 1 (length (cdr items))))
)

(define (count-leave items)
    (cond ((null? items) 0)
        ((not (pair? items)) 1)
        (else (+ 
                (count-leave (car items))
                (count-leave (cdr items)))))
)

;(define x (cons (list 1 2) (list 3 4)))
;(count-leave x)

;2.25
(define x1 (list 1 3 (list 5 7) 9))
(define x2 (list (list 7)))
(define x3 (list 1 (list 2 (list 3 (list 4 (list 5 (list 6 7)))))))

;(car (cdr (car (cdr (cdr x1)))))
;(car (car x2))
;(car (cdr (car (cdr (car (cdr (car (cdr (car (cdr (car (cdr x3))))))))))))

;(define x (list 1 2 3))
;(define y (list 4 5 6))

;(append x y)
;(cons x y)
;(list x y)

;2.27
(define (deep-reverse items)
    (if (list? items)
        (reverse (map deep-reverse items))
        items))

;(reverse (list (list 1 2) (list 3 4)))
;(deep-reverse (list (list 1 2) (list 3 4)))

;2.28
(define (fringe items)
    (cond ((null? items) `())
        ((not (pair? items)) (list items))
        (else (append (fringe (car items)) (fringe (cdr items))))))

;(define x (list (list 1 2) (list 3 4)))
;(fringe x)
;(fringe (list x x))

;2.29
(define (make-mobile left right)
    (list left right))

(define (make-branch length structure)
    (list length structure))

(define (left-branch mobile)
    (car mobile))

(define (right-branch mobile)
    (car (cdr mobile)))

(define (filter proc m)
    (if (proc m)
        m
        `()))

(define (branch-length branch)
    (append (list (car branch))
        (if (pair? (car (cdr branch)))
            (branch-length (car (cdr branch)))
            `())
))

;(define (branch-structure branch))
(define m
    (make-mobile
        (make-branch 1 2)
        (make-branch 3 4)))

(define mm 
    (make-mobile
        (make-branch 5 (list 1 2))
        (make-branch 6 (list 3 4))))

;(left-branch mm)
;(right-branch mm)
;(branch-length (left-branch mm))

;2.30
(define (square-tree tree)
    (cond 
        ((null? tree) `())
        ((not (pair? tree)) (* tree tree))
        (else (cons 
            (square-tree (car tree))
            (square-tree (cdr tree))))))

(define (square-tree-map tree)
    (map (lambda (x) 
        (if (pair? x) 
            (square-tree-map x)
            (* x x))
    ) tree))

(define list-1
    (list 1 
        (list 2 (list 3 4) 5)
        (list 6 7)))

;(square-tree list-1)
;(square-tree-map list-1)

;2.31

(define (tree-map proc tree)
    (cond 
        ((null? tree) `())
        ((not (pair? tree)) (proc tree))
        (else (cons
            (tree-map proc (car tree))
            (tree-map proc (cdr tree))))))

(define (square-tree-1 tree)
    (tree-map square tree))

;(square-tree-1 list-1)