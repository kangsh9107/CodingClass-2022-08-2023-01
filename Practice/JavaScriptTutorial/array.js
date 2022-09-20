// Array
// 1. Declaration
const arr1 = new Array();
const arr2 = [1, 2];

// 2. Index position
const fruits = ['사과', '바나나'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits[fruits.length - 1]);

// 3. Looping over an array
// print all fruits
console.clear();

for(let i=0; i<fruits.length; i++) {
    console.log(fruits[i]);
}
for(v of fruits) {
    console.log(v);
}
for(index in fruits) {
    console.log(fruits[index]);
}
console.clear();
fruits.forEach( (fruit) => console.log(fruit) );
// 배열의 밸류마다 내가 전달한 함수를 출력한다.

// 4. Addtion, deletion, copy
// push: add an item to the end
fruits.push('딸기', '복숭아');
console.log(fruits);
// pop: remove an item from the end
fruits.pop();
fruits.pop();
console.log(fruits);

// unshift: add an item to the benigging
fruits.unshift('딸기', '레몬');
console.log(fruits);
// shift: remove an item from the benigging
fruits.shift();
fruits.shift();
console.log(fruits);

// note!! shift, unshift are slower than pop, push
// 모든 배열의 밸류를 한칸씩 뒤로 밀고 앞에 넣거나 앞에껄 빼고 다 한칸씩 끌어와야해서
// 앞에 넣거나 빼는건 굉장히 느리다.

//splice: remove an item by index position
fruits.push('딸기', '오렌지', '레몬');
console.clear();
console.log(fruits);
fruits.splice(1, 1);
console.log(fruits);
fruits.splice(1, 1, '메론', '수박');
console.log(fruits);

// combine two arrays
const fruits2 = ['망고', '코코넛'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);

// 5. Searching
// indexOf: find the index
console.clear();
console.log(fruits);
console.log(fruits.indexOf('사과'));
console.log(fruits.indexOf('포도'));

// includes
console.log(fruits.includes('사과'));
console.log(fruits.includes('딸기'));

// lastIndeOf
console.clear();
fruits.push('사과');
console.log(fruits);
console.log(fruits.indexOf('사과'));
console.log(fruits.lastIndexOf('사과'));
let popped = fruits.pop();
console.log(popped);