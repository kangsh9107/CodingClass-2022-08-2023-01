/* Level 1 */
// 1. 짝수와 홀수
// function solution(num) {
//     let answer = '';
//     if(num%2==0) { answer = "Even" }
//     else            { answer = "Odd" }
//     return answer;
// }
// console.log(solution(3));

// 2. 자릿수 더하기
// function solution(n) {
//     let answer = 0;
//     let a = String(n);
//     for(let i=0; i<a.length; i++) {
//         let b = a.slice(i, i+1);
//         answer += Number(b);
//     }
//     return answer;
// }
// console.log(solution(123));

// 3. 약수의 합
// function solution(n) {
//     let answer = 0;
//     for(let i=1; i<=n; i++) {
//         if(n%i===0) {
//             let b = i;
//             answer += b;
//         }
//     }
//     return answer;
// }
// console.log(solution(12));

// 4. 평균 구하기
// function solution(arr) {
//     let answer = 0;
//     let sum = 0;
//     for(v of arr) {
//         sum += v;
//     }
//     answer = sum / arr.length;
//     return answer;
// }

// let arr = [1,2,3,4];
// function avg(arr) {
//     let answer = 0;
//     let a = arr.reduce(function(cur, now) {
//         return cur + now;
//     }, 0);
//     answer = a / arr.length;
//     return answer;
// }

// 5. 정수 제곱근 판별
// function solution(n) {
//     let answer = -1;
//     let a = Math.sqrt(n);
//     if(a===parseInt(a)) {
//         answer = (a+1) * (a+1);
//     }
//     return answer;
// }

// 6. 자연수 뒤집어 배열로 만들기
// function solution(n) {
//     let answer = [];
//     let a = String(n);
//     for(let i=a.length-1; i>=0; i--) {
//         let b = Number( a.slice(i, i+1) );
//         answer.push(b);
//     }
//     console.log(answer);
//     return answer;
// }

// 7. 문자열 내 p와 y의 개수
// function solution(s){
//     let answer = true;
//     let a = s.split("");
//     let strP = 0;
//     let strY = 0;
//     for(v of a) {
//         if(v==="p" || v==="P") {
//             strP += 1;
//         } else if(v==="y" || v==="Y") {
//             strY += 1;
//         }
//     }
//     if(strP!==strY) {
//         answer = false;
//     }
//     return answer;
// }

// // 다른 사람 풀이. 충격적이다.
// function numPY(s) {
//     return s.toUpperCase().split("P").length === s.toUpperCase().split("Y").length;
// }

// 8. 하샤드 수
// function solution(x) {
//     let answer = true;
//     let a = String(x).split("");
//     let b = a.reduce(function(cur, now) {
//         return Number(cur) + Number(now);
//     });
//     let c = x % b;
//     if(c!==0) {
//         answer = false;
//     }
//     return answer;
// }

// 9. 정수 내림차순으로 배치하기
// function solution(n) {
//     let answer = 0;
//     let str = "";
//     let a = String(n);
//     let b = a.split("");
//     let c = b.map(Number);
//     let d = c.sort(function(x, y) {
//         return y - x;
//     });
//     for(v of d) {
//         str += String(v);
//     }
//     answer = Number(str);
//     return answer;
// }

// 다른 사람 풀이.
// function solution(n) {
//     let newN = n + ""; // 문자열로 변환
//     let newArr = newN
//         .split("")
//         .sort()
//         .reverse()
//         .join("");  // 배열을 다시 하나의 문자열로 변환
//     return +newArr; // 숫자로 리턴
// }

// 10. 문자열 s를 숫자로 변환한 결과를 반환
function solution(s) {
    let answer = 0;
    return answer;
}
// console.log( solution(-1234) );
let s = [-1234];
console.log( s.indexOf("-") );