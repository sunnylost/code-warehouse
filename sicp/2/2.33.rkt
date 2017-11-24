#lang racket

(define nil `())

(define (divide? a b)
  (= (remainder a b) 0))

(define (smallest-divisor n)
  (define (divine n a)
    (cond ((> (square a) n) n)
          ((divide? n a) a)
          (else (divine n (+ a 1)))))
  
  (divine n 2))

(define (prime? n)
  (if (= (smallest-divisor n) n)
      #t
      #f))

(define (square x) (* x x))

(define (get-nth items index)
    (define (iter sets count)
        (cond 
            ((null? sets) nil)
            ((= index count) (car sets))
            (else (iter (cdr sets) (+ count 1)))
        ))
    (iter items 0))

(define (filter predicate sequence)
    (cond ((null? sequence) nil)
          ((predicate (car sequence))
            (cons (car sequence)
                  (filter predicate (cdr sequence))))
           (else (filter predicate (cdr sequence)))))

(define (accumulate op initial sequence)
    (if (null? sequence)
        initial
        (op (car sequence)
            (accumulate op initial (cdr sequence)))))

(define (enumerate-interval low high)
    (if (> low high)
        nil
        (cons low (enumerate-interval (+ low 1) high))))

(define (enumerate-tree tree)
    (cond ((null? tree) nil)
          ((not (pair? tree)) (list tree))
          (else (append (enumerate-tree (car tree))
                        (enumerate-tree (cdr tree))))))

;(filter odd? (list 1 2 3 4 5))
;(accumulate + 0 (list 1 2 3 4 5))
;(enumerate-interval 2 7)
;(enumerate-tree (list 1 (list 2 (list 3 4)) 5))

(define (sum-odd-squares tree)
    (accumulate +
                0
                (map square 
                    (filter odd? 
                        (enumerate-tree tree)))))

(define (map p sequence)
    (accumulate (lambda (x y) (cons (p x) y)) nil sequence))

(define (append seq1 seq2)
    (accumulate cons seq2 seq1))

;(map square (list 1 2 3 4))

;2.34
(define (horner-eval x coefficient-sequence)
    (accumulate (lambda (this-coeff higher-terms) (+ this-coeff (* higher-terms x)))
                0
                coefficient-sequence))

;(horner-eval 2 (list 1 3 0 5 0 1))

;2.35
(define (count-leaves t)
    (accumulate 
        (lambda (a b)
            (if (null? a) 1 (+ a b))) 0 
        (map (lambda (x) 
            (if (pair? x)
                 (count-leaves x) 
                 1)
        ) t)))

(define x (cons (list 1 2) (list 3 4)))
;(count-leaves (list x x))

;2.36
(define (accumulate-n op init seqs)
    (if (null? (car seqs))
        nil
        (cons (accumulate op init (map car seqs))
              (accumulate-n op init (map cdr seqs)))))

;(define s (list (list 1 2 3) (list 4 5 6) (list 7 8 9) (list 10 11 12)))
;(accumulate-n + 0 s)

;2.38
(define (fold-left op initial sequence)
    (define (iter result rest)
        (if (null? rest)
            result
            (iter (op result (car rest))
                  (cdr rest))))
    (iter initial sequence))

(define fold-right accumulate)

;(fold-right / 1 (list 1 2 3 4))
;(fold-left / 1 (list 1 2 3 4))
;(fold-right list nil (list 1 2 3))
;(fold-left list nil (list 1 2 3))

;2.39
(define (reverse sequence)
    (fold-right (lambda (x y) (append y (list x))) nil sequence))

(define (reverse1 sequence)
    (fold-left (lambda (x y) (append (list y) x)) nil sequence))

;(reverse (list 1 2 3 4))
;(reverse1 (list 1 2 3 4))

(define (prime-sum? pair)
    (prime? (+ (car pair) (cadr pair))))

(define (make-pair-sum pair)
    (list (car pair) (cadr pair)))

(define (flatmap proc seq)
    (accumulate append nil (map proc seq)))

(define (prime-sum-pairs n)
    (map make-pair-sum
            (filter prime-sum?
                (flatmap
                    (lambda (i)
                        (map (lambda (j) (list i j))
                                (enumerate-interval 1 (- i 1))))
                (enumerate-interval 1 n)))))

;(prime-sum-pairs 5)

(define (remove item sequence)
    (filter (lambda (x) (not (= x item)))
            sequence))

(define (permutations s)
    ;(display s)
    ;(newline)
    (if (null? s)
        (list nil)
        (flatmap (lambda (x)
                    (map (lambda (p) (cons x p))
                          (permutations (remove x s))))
                s)))

;(flatmap 
;    (lambda (i) (map (lambda (j) (list i j)) (enumerate-interval 1 (- i 1))))
;    (enumerate-interval 1 10))
;(permutations (list 1 2 3))

;2.40
(define (unique-pair n)
    (flatmap (lambda (x)
            (map 
                (lambda (y) (list x y))
                (enumerate-interval 1 (- x 1)))
            )
        (enumerate-interval 1 n)))

(define (prime-sum-pairs-1 n)
    (map make-pair-sum
        (filter prime-sum? (unique-pair n))))

;(prime-sum-pairs-1 5)

;2.41
(define (filter-sum items n)
    (= n (+ (car items) (get-nth items 1) (get-nth items 2))))

(define (find-triple-tuple n)
    (filter
        (lambda (v) (filter-sum v n))
        (flatmap
            (lambda (x)
                (map (lambda (y) (list x y))
                (enumerate-interval 1 (- x 1))))
            (enumerate-interval 1 n))
    ))

;(find-triple-tuple 6)
(define n 4)
(define (generate-triple-tuple n)
    (flatmap
        (lambda (x)
            (map 
                (lambda (y)
                    (map 
                        (lambda (z) (list x y z))
                        (enumerate-interval 1 (- n 2))
                    ))
                (enumerate-interval 1 (- n 1))))
        (enumerate-interval 1 n)))
;TODO
; (filter
    ; (lambda (items)
        ;  (and
            ; (= (car items) (get-nth items 1))
            ;(not (= (car items) (get-nth items 2)))
            ;(not (= (get-nth items 1) (get-nth items 2)))
        ; ))
    ; (generate-triple-tuple n))