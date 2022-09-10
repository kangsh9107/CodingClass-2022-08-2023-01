// Function
// - fundamental building block in the program
// - subprogram can be used multiple times
// - performs a task or calculates a value

// 1. Function declaration
// one function === one thing
// naming: doSomething, command, verb
// e.g. createCardAndPoint -> createCard, createPoint
// function is object in JS
// function printHello(){
//   console.log("Hello");
// }
// printHello();

// function log(message) {
//   console.log(message);
// }
// log("Hello~~");

// 2. Parameters
// premitive parameters: passed by value
// object parameters: passed by reference
// function changeName(obj) {
//   obj.name = "coder";
// }
// const ellie = { name: "ellie" };
// changeName(ellie);
// console.log(ellie);

// 3. Default parameters (added in ES6)
// function showMessage(message, from) {
//   if (from === undefined) {
//     from = "unknown";
//   }
//   console.log(`${message} by ${from}`);
// }
// showMessage("Hi");

// function showMessage2(message, from = "unknown") {
//   console.log(`${message} by ${from}`);
// }
// showMessage2("Hi2");

// 4. Rest parameters (added in ES6)
// function printAll(...args) {
//   for (let i = 0; i < args.length; i++) {
//     console.log(args[i]);
//   }

//   for(const arg of args) {
//     console.log(arg);
//   }

//   args.forEach((arg) => console.log(arg));
// }
// printAll("dream", "coding", "ellie");

// 5. Local scope
// let globalMessage = "global"; // global variable
// function printMessage() {
//   let message = "hello"; // local variable
//   var message2 = "Hi";
//   console.log(message);
//   console.log(globalMessage);
//   function printAnother() {
//     console.log(message);
//     console.log(message2);
//     let childMessage = "hello";
//     var childMessage2 = "Hi2";
//   }
//   printAnother();
//   // console.log(childMessage);
//   // console.log(childMessage2);
// }
// printMessage();

// var a = 1;
// if (true) {
//   let a = 5;
//   console.log(a);
// }
// console.log(a);

// console.log(b);
// let b;
// console.log(c);
// var c = 2;

// 6. Return a value
// function sum(a, b) {
//   return a + b;
// }
// const result = sum(1, 2);
// console.log(`sum: ${sum(1, 2)}`);

// // 7. Early return, early exit
// // bad
// function upgradeUser(user) {
//   if (user.point > 10) {
//     // long upgrade logic...
//   }
// }

// // good
// function upgradeUser(user) {
//   if (user.point <= 10) {
//     return;
//   }
//   // long upgrade logic...
// }

// Furst-class function
// functions are treated like any other variable
// can be assigned as a value to variable
// can be passed as an argument to other functions.
// can be returned by another function

// 1. Function expression
// a function declaration can be called earlier than it is defiend. (hoisted)
// a function expression is created when the execution reaches it.

// const print = function () { // anonymous function
//   console.log("print");
// };
// print();
// const printAgain = print;
// printAgain();
// const sumAgain = sum;
// console.log(sumAgain(1, 3));

// 2. Callback function using function expression
// function randomQuiz(answer, printYes, printNo) {
//   if (answer === "love you") {
//     printYes();
//   } else {
//     printNo();
//   }
// }
// // anonymous function
// const printYes = function () {
//   console.log("yes!");
// };
// // named function
// // better debugging in debugger's stack traces
// // recursions 함수안에서 자기가 자기를 부름.
// const printNo = function print() {
//   console.log("no!");
// };
// randomQuiz("wrong", printYes, printNo);
// randomQuiz("love you", printYes, printNo);

// Arrow function
// always anonymous
const simplePrint = function () {
  console.log("simplePrint!");
};

const simplePrint2 = () => console.log("simplePrint!2");
const add = (a, b) => a + b;