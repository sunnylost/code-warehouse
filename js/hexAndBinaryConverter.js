var map = function() {
    var b, h,
        begin = 0,
        max   = 16,
        m     = {
            b: {},
            h: {}
        };

    while(max--) {
        b = begin.toString(2);
        b = Array(5 - b.length).join('0') + b;
        h = begin.toString(16);
        m.b[b] = h;
        m.h[h] = b;
        begin++;
    }

    return m;
}(),

rnothex     = /[^0-9a-f]/g,
rnotbinary  = /[^01]/g,
rbinary     = /\d{4}/g,
rprefixzero = /^0*/;

function notValidHexNumberError(v) {
    throw Error(v + ' is not a valid hex number!');
}

function notValidBinaryNumberError(v) {
    throw Error(v + ' is not a valid binary number!');
}

function b2h(b) {
    var r = '',
        remain;
    if(b) {
        b = b.toString();
        if(b.match(rnotbinary)) notValidBinaryNumberError(b);
        if(remain = b.length % 4) {
            b = Array(5 - remain).join('0') + b;
        }
        b = b.match(rbinary);
        for(var i = 0, len = b.length; i < len; i++) {
            r += map.b[b[i]];
        }
        return r;
    }
}

function h2b(h) {
    var r = '';
    if(h) {
        h = h.toString();
        h = h.toLowerCase();
        if(h.indexOf('0x') != -1) {
            h = h.substring(2, h.length);
        }
        if(h.match(rnothex)) notValidHexNumberError(h);

        for(var i = 0, len = h.length; i < len; i++) {
            r += map.h[h[i]];
        }

        return r.replace(rprefixzero, '');
    }
}

function test() {
    var a = '0X39A7F8',
        b = '0xD5E4C',
        c = '1100100101111011',
        d = '1001101110011110110101'
    console.log(parseInt(a, 16).toString(2) === h2b(a));
    console.log(parseInt(b, 16).toString(2) === h2b(b));
    console.log(parseInt(c, 2).toString(16) === b2h(c));
    console.log(parseInt(d, 2).toString(16) === b2h(d));
}

test();
