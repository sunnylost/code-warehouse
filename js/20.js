//http://www.51nod.com/favorite/index.html#!favoriteId=25

var a = '99999jjjjj',
    b = '9999900001';

function nToC(n) {
    return n >= 10 ? String.fromCharCode(97 + n - 10) : '' + n;
}

function cToN(c) {
    return parseInt(c, 20);
}

function sum(a, b) {
    var tmp, ta, tb, sum = [], carry = false,
        max = a.length;
    if(b.length != a.length) {
        max = Math.max(a.length, b.length);
        a = Array(max - a.length).join('0') + a;
        b = Array(max - b.length).join('0') + b;
    }
    while(max--) {
        ta = cToN(a.substring(max, max + 1));
        tb = cToN(b.substring(max, max + 1));
        tmp = ta + tb + (carry ? 1 : 0);
        if(tmp < 20) {
            carry = false;
            sum.push(nToC(tmp));
        } else {
            carry = true;
            sum.push(nToC(tmp - 20));
        }
    }

    if(carry) {
        sum.push(1);
    }

    sum = sum.reverse().join('');
    console.log(sum);
}

sum(a, b);
