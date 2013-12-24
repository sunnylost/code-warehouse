//question: http://www.51nod.com/question/index.html#!questionId=525

var start   = '1',
    r       = '',
    num     = 100,
    onesArr = [ 0 ],
    index   = { 0 : 1 },
    len     = 0;

//init
for(var i = 0; i < num; i++) {
    r += start;
    start += '0';
    len += i + 1;
}

//index one
var pre;
for(i = 1; i < num; i++) {
    pre = onesArr[i - 1];
    onesArr[i] = pre + i;
    index[onesArr[i]] = 1;
}

//find
var pos = 1230;
if(pos < len) {
    console.log('The position at ' + pos + ' is ' + (index[pos] ? 1 : 0));
} else {
    console.log('over the result\'s length! The length is ' + len);
}
