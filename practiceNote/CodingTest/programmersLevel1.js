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
function solution(s){
    let answer = true;
    
    return answer;
}