/*
    Unsigned number ——> Two's-complement
*/
function U2T(u) {
    if(u < 0) throw new Error(u + ' can\'t be negative.');

    var b   = (u).toString(2),
        len = b.length,
        i   = 0,
        t   = 0;

    while(len-- > 0) {
        t += Math.pow(2, i++) * (+b[len]);
    }
    t += -1 * Math.pow(2, i) * b[0];
    console.log(t);
}

/*
    Two's-complement ——> Unsigned number
*/
function T2U(t) {
    if(t >= 0) return t;

    var b   =  (-1 * t).toString(2),
        len = b.length,
        i   = 0,
        nb  = '',
        tmp;

    if(tmp = len % 4) {
        b = Array(5 - tmp).join('0') + b;
        len += tmp;
    }

    for(; i < len; i++) {
        nb += +(b[i] == 0);
    }
    
    nb = (parseInt(nb, 2) + 1).toString(2);

    if(nb.length < len) {
        nb = Array(len - nb.length + 1).join('0') + nb;
    }

    nb = '1' + nb.substring(1, len);
    
    b = i = 0;
    while(len--) {
        b += Math.pow(2, i++) * (+nb[len]);
    }

    return b;
}

console.log(T2U(-12345));
console.log(T2U(12345));
