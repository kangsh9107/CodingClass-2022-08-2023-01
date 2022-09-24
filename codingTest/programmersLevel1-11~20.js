// 11. x만큼 간격이 있는 n개의 숫자
// function solution(x, n) {
//     let answer = [];
//     let a = x;

//     for(let i=0; i<n; i++) {
//         answer.push(x);
//         x += a;
//     }

//     return answer;
// }
// console.log(solution(-4, 2));

// // 다른 사람 풀이
// function solution(x, n) {
//     var answer = [];
//     for (let i = 1; i <= n; i++) {
//         answer.push(x*i)
//     }
//     return answer;
// }

// 12. 나머지가 1이 되는 수 찾기
// function solution(n) {
//     let answer = 0;

//     for(let x=2; x<n; x++) {
//         if(n%x===1) {
//             answer = x;
//             break;
//         }
//     }

//     return answer;
// }
// console.log(solution(12));

// 13. 콜라츠 추측
// function solution(num) {
//     let answer = 0;
    
//     for(let i=1; i<=500; i++) {
//         if(i===500) {
//             answer = -1;
//             break;
//         } else if(num===1) {
//             answer = i - 1;
//             break;
//         } else if(num%2===0) {
//             num = num / 2;
//         } else {
//             num = (num * 3) + 1;
//         }
//     }
//     return answer;
// }
// console.log(solution(626331));

// 14. 두 정수 사이의 합
// function solution(a, b) {
//     let answer = 0;

//     if(a<b) {
//         for(let i=a; i<=b; i++) {
//             answer += i;
//         }
//     } else if(a===b) {
//         answer = a;
//     } else {
//         for(let i=b; i<=a; i++) {
//             answer += i;
//         }
//     }
//     return answer;
// }
// console.log(solution(5, 3));

// 15. 서울에서 김서방 찾기
// function solution(seoul) {
//     let answer = '';
//     let index = seoul.findIndex( v => v=='Kim' );
//     answer = `김서방은 ${index}에 있다`
//     return answer;
// }

// 16. 핸드폰 번호 가리기
// function solution(phone_number) {
//     let answer = '';
//     let pLength = phone_number.length;
//     let a = '';
//     for(let i=0; i<pLength-4; i++) {
//         a += '*';
//     }
//     let b = phone_number.slice(-4);
//     answer = a + b;
//     return answer;
// }
// console.log(solution("01033334444"));

// 17. 나누어 떨어지는 숫자 배열
// function solution(arr, divisor) {
//     let answer = [];

//     for(v of arr) {
//         if(v%divisor===0) {
//             answer.push(v);
//         }
//     }

//     for(let i=0; i<answer.length-1; i++) {
//         for(let k=i+1; k<answer.length; k++) {
//             if(answer[i]>answer[k]) {
//                 let min = answer[k];
//                 answer[k] = answer[i];
//                 answer[i] = min;
//             }
//         }
//     }

//     if(answer.length===0) {
//         answer.push(-1);
//     }

//     return answer;
// }
// let array = [2, 36, 1, 3];
// console.log(solution(array, 1));

// 다시 짠 코드
// function solution(arr, divisor) {
//     let answer = [ ];
//     for(v of arr) if(v%divisor===0) answer.push(v);
//     if(answer.length===0) return answer = [-1];
//     else                  return answer.sort( (a, b) => a - b );
// }
// let array = [2, 36, 1, 3];
// console.log(solution(array, 1));

// // 다른 사람 풀이
// function arrDivisor(arr, divisor) {
//     let answer = arr.filter( v => v%divisor==0 );
//     return answer.length === 0 ? [-1] : answer.sort( (a, b) => a - b );
// }

// 18. 제일 작은 수 제거하기
// function solution(arr) {
//     let answer = [];
//     if(arr.length<=1) {
//         return answer = [-1];
//     } else {
//         for(v of arr) {
//             answer.push(v);
//         }
//         let a = answer.sort( (a, b) => (a - b) );
//         let min = a.shift();
//         return arr.filter(v => v!==min);
//     }
// }
// let array = [8, 50, 22, 15];
// console.log(solution(array));

// // 다른 사람 풀이
// function solution(arr) {
//     if(arr.length<=1) return [-1];
//     arr.splice(arr.indexOf(Math.min(...arr)), 1);
//     return arr;
// }
// // ES6/ES2016보다 낮은버전
// // Math.min.apply(Math, 배열명) 으로 사용한다.

// 19. 음양 더하기
// function solution(absolutes, signs) {
//     let arr = [];
//     for(let i=0; i<signs.length; i++) {
//         if(signs[i]===true) { arr.push(absolutes[i]); }
//         else { arr.push(absolutes[i]-absolutes[i]*2); }
//     }
//     return arr.reduce( (cur, now) => (cur + now) );
// }
// let arr1 = [4, 7, 12];
// let arr2 = [true, false, true];
// console.log(solution(arr1, arr2));

// 20. 수박수박수박수박수박수?
// function solution(n) {
//     let answer = '';
//     for(let i=1; i<=n; i++) {
//         if(i%2!==0) { answer += '수'; }
//         else        { answer += '박'; }
//     }
//     return answer;
// }
// console.log(solution(3));

// // 다른 사람 코드
// const waterMelon = n => "수박".repeat(n).slice(0,n);