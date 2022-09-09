// 1. String concatenation
// console.log("my" + " cat");
// console.log("1" + 2);
// console.log(`string literals: 1 + 2 = ${1 + 2}`);

// 2. Numberic operators
// console.log(1 + 1); // add
// console.log(1 - 1); // substarct
// console.log(1 / 1); // divide
// console.log(1 * 1); // multiply
// console.log(5 % 2); // remainder
// console.log(2 ** 3); // exponentiation 거듭제곱

// 3. Increment and decrement operators
// let counter = 2;
// const preIncrement = ++counter;
// console.log(`perIncrement: ${preIncrement}, counter: ${counter}`);
// let counter = 2;
// const postIncrement = counter++;
// console.log(`postIncrement: ${postIncrement}, counter: ${counter}`);

// 4. Assignment operators
// let x = 3;
// let y = 6;
// x += y;
// x -= y;
// x *= y;
// x /= y;

// 5. Comparison operators
// console.log(10 < 6);
// console.log(10 <= 6);
// console.log(10 > 6);
// console.log(10 >= 6);

// 6. Logical operators: || (or), && (and), ! (not)
// const value1 = false;
// const value2 = 4 < 2;

// || (or)
// console.log(`or: ${value1 || value2 || check()}`);

// && (and)
// console.log(`or: ${value1 && value2 && check()}`);

// function check() {
//   for (let i = 0; i < 10; i++) {
//     // wasting time
//     console.log("ok");
//   }
//   return true;
// }

// ! (not)
// console.log(!value1);

// 7. Equality
// const stringFive = '5';
// const numberFive = 5;

// // == loose equality, with type conversion
// console.log(stringFive == numberFive);
// console.log(stringFive != numberFive);

// // === strict equality, no type conversion
// console.log(stringFive === numberFive);
// console.log(stringFive !== numberFive);

// object equlity by reference
// const ellie1 = { name: "ellie" };
// const ellie2 = { name: "ellie" };
// const ellie3 = ellie1;
// console.log(ellie1 == ellie2);
// console.log(ellie1 === ellie2);
// console.log(ellie1 === ellie3);

// equality - puzzler
// console.log(0 == false);
// console.log(0 === false);
// console.log("" == false);
// console.log("" === false);
// console.log(null == undefined);
// console.log(null === undefined);

// 8. Conditional operators: if
// if, else if, else
// const name = "code";
// if (name === "ellie") {
//   console.log("Welcome, Ellie!");
// } else if (name === "coder") {
//   console.log("You are amazing coder");
// } else {
//   console.log("unknown");
// }

// 9. Ternary operator: ?
// condition ? value1 : value2;
// console.log(name === "ellie" ? "yes" : "no");

// 10. Switch statement
// use for multiple if checks
// use for enum-like value check
// use for multiple type checks in TS
// const browser = "IE";
// switch (browser) {
//   case "IE":
//     console.log("go away!");
//     break;
//   case "Chrome":
//   case "Firefox":
//     console.log("love you!");
//     break;
//   default:
//     console.log("same all!");
//     break;
// }

// 11. Loops
// while loop, while the condition is truthy,
// body code is executed;
let i = 3;
