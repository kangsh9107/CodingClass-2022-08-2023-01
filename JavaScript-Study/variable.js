'use strict';

// 1. Use stirict
// added in ES 5
// use this for Vanilla JavaScript

// 2. Variable
// let (added in ES6)
// let globalName = 'global name';
// {
//   let name = 'ellie';
//   console.log(name);
//   name = 'hello';
//   console.log(name);
//   console.log(globalName);
// }
// console.log(name);
// console.log(globalName);

// var (don't ever use this!)
// var hoisting (move declaration from bottom to top)
// has no block scope
// console.log(age);
// age = 4;
// console.log(age);
// var age;

// {
//   age2 = 5;
//   var age2;
// }
// console.log(age2);

// 3. Contants
// favor immutable data type always for a few reasons:
// - security
// - thread safety
// - reduce human mistakes
// const daysInWeek = 7;
// const maxNumber = 5;

// 4. Variable types
// primitive, single item: number, string, boolean, null, undefiedn, symbol
// object, box container
// function, first-class function: 함수를 변수에 할당 가능. 파라미터로도 가능. 리턴도 가능.

// const count = 17; // integer
// const size = 17.1; // decimal number
// console.log(`value: ${count}, type: ${typeof count}`);
// console.log(`value: ${size}, type: ${typeof size}`);

// number - special numeric values: infinity, -infinity, NaN
// const infinity = 1 / 0;
// const negativeInfinity = -1 / 0;
// const nAn = 'not a numer' / 2;
// console.log(infinity);
// console.log(negativeInfinity);
// console.log(nAn);

// string
// const char = 'c';
// const brendan = 'brendan';
// const greeting = 'hello ' + brendan;
// console.log(`value: ${greeting}, type: ${typeof greeting}`);
// const helloBob = `hi ${brendan}!`; // template literals (string)
// console.log(`value: ${helloBob}, type: ${typeof helloBob}`);

// boolean
// false: 0, null, undefined, NaN, ''
// true: any other value
// const canRead = true;
// const test = 3 < 1; // false
// console.log(`value: ${canRead}, type: ${typeof canRead}`);
// console.log(`value: ${test}, type: ${typeof test}`);

// null
// let nothing = null;
// console.log(`value: ${nothing}, type: ${typeof nothing}`);

// undefined
// let x;
// console.log(`value: ${x}, type: ${typeof x}`);

// symbol, create unique identifiers for objects
// const symbol1 = Symbol('id');
// const symbol2 = Symbol('id');
// console.log(symbol1 === symbol2);
// const gSymbol1 = Symbol.for('id');
// const gSymbol2 = Symbol.for('id');
// console.log(gSymbol1 === gSymbol2); // true
// console.log(`value: ${symbol1.description}, type: ${typeof symbol1}`);

// object, real-life object, data structure
// const라서 오브젝트는 변경 불가능한데 안의 name과 age는 다른 값으로 할당 가능
// const ellie = { name: 'ellie', age: 20};
// console.log(ellie.age);
// ellie.age = 21;
// console.log(ellie.age);

// 5. Dynamic typing: dynamically typed language
// let text = 'hello';
// console.log(text.charAt(0)); // h
// console.log(`value: ${text}. type: ${typeof text}`);
// text = 1;
// console.log(`value: ${text}. type: ${typeof text}`);
// text = '7' + 5;
// console.log(`value: ${text}. type: ${typeof text}`);
// text = '8' / '2';
// console.log(`value: ${text}. type: ${typeof text}`);
// console.log(text.charAt(0)); // error