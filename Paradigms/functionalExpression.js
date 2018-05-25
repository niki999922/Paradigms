"use strict"

var VARIABLES = {
    "x": 0,
    "y": 1,
    "z": 2
};

var operation = function (action) {
    return function () {
        var operands = arguments;
        return function () {
            var result = [];
            for (var i = 0; i < operands.length; i++) {
                result.push(operands[i].apply(null, arguments));
            }
            return action.apply(null, result);
        }
    }
}

var variable = function (name) {
    return function () {
        return arguments[VARIABLES[name]];
    }
}

var cnst = function (value) {
    return function () {
        return value;
    };
};

var add = operation(function (a, b) {
    return a + b;
});

var subtract = operation(function (a, b) {
    return a - b;
});

var multiply = operation(function (a, b) {
    return a * b;
});

var divide = operation(function (a, b) {
    return a / b;
});

var negate = operation(function (a) {
    return -a;
});

var cube = operation(function (a) {
    return Math.pow(a, 3);
    ;
});

var cuberoot = operation(function (a) {
    return Math.pow(a, 1 / 3);
});

var parse = function (s) {
    var tokens = s.split(" ").filter(function (t) {
        return t.length > 0;
    });
    var stack = [];
    var OP = {
        "+": add,
        "-": subtract,
        "*": multiply,
        "/": divide,
        "negate": negate,
        "cube": cube,
        "cuberoot": cuberoot
    };
    var ARGS_SIZE = {
        "+": 2,
        "-": 2,
        "*": 2,
        "/": 2,
        "negate": 1,
        "cube": 1,
        "cuberoot": 1
    };
    for (var i = 0; i < tokens.length; i++) {
        if (tokens[i] in VARIABLES) {
            stack.push(variable(tokens[i]));
        } else if (tokens[i] in OP) {
            var args = [];
            for (var j = 0; j < ARGS_SIZE[tokens[i]]; j++) {
                args.push(stack.pop());
            }
            args.reverse();
            stack.push(OP[tokens[i]].apply(null, args));
        } else {
            stack.push(cnst(Number(tokens[i])));
        }
    }
    return stack.pop();
}
