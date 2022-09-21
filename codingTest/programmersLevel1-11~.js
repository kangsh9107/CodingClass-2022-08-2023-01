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
function solution(arr, divisor) {
    let answer = [];
    return answer;
}
let array = [5, 9, 7, 10];
console.log(solution(array, 5));