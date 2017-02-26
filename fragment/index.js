'use strict';



var s = 'Hello';

function greet(name) {
    console.log(s + ', ' + name + '!');
}

function foo(a, b, rest) {
    var i, rest = [];

    console.log(arguments);

    if (arguments.length > 2) {
        for (i = 2; i < arguments.length; i++) {
            rest.push(arguments[i]);
        }
    }
    console.log('a = ' + a);
    console.log('b = ' + b);
    console.log(rest);
}

// foo(2,3,4,5);

// foo(1)

function sum() {

    if (arguments.length === 0) {
        return 0;
    }

    if (arguments.length === 1) {
        return arguments[0];
    }
    var sum = 0;
    for (var i = 0; i < arguments.length; i++) {

        sum = arguments[i] + sum;
    }
    return sum;
}


// 测试:
var args = [],args2 = [];
for (var i = 1; i <= 100; i++) {
    args.push(i);
};
if (sum() !== 0) {
    console.log('测试失败: sum() = ' + sum());
} else if (sum(1) !== 1) {
    console.log('测试失败: sum(1) = ' + sum(1));
} else if (sum(2, 3) !== 5) {
    console.log('测试失败: sum(2, 3) = ' + sum(2, 3));
} else if (sum.apply(null, args) !== 5050) {
    console.log('测试失败: sum(1, 2, 3, ..., 100) = ' + sum.apply(null, args));
} else {
>     console.log(sum.apply(null, args));
    console.log('测试通过!');
}


function area_of_circle(r, pi) {
    var s = 0;
    if (pi) {
        s = pi * r * r;
    } else {
        s = 3.14 * r * r;
    }
    return s;

}
// 测试:
if (area_of_circle(2) === 12.56 && area_of_circle(2, 3.1416) === 12.5664) {

} else {    console.log('测试失败');
}

var jason = {
    name: '小明',
    birth: 1990,
    age: function () {
        var y = new Date().getFullYear();
        return y - this.birth;
    }
};

;


console.log(jason.age);
console.log(jason.age());