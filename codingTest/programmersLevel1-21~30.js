// 21. 가운데 글자 가져오기
// function solution(s) {
//     if(s.length===1) {
//         return s;
//     } else if(s.length%2===0) {
//         return s.substr( (s.length/2 - 1), 2 );
//     } else {
//         return s.substr( (s.length/2), 1 );
//     }
// }
// console.log(solution("12345"));

// 22. 없는 숫자 더하기
// function solution(numbers) {
//     let answer = 0;
//     for(let i=1; i<=9; i++) {
//         let none = numbers.indexOf(i);
//         if(none===-1) answer += i;
//     }
//     return answer;
// }
// let arr = [1,2,3,4,6,7,8,0];
// console.log(solution(arr));

// // 다른 사람 풀이
// function solution(numbers) {
//     return 45 - numbers.reduce( (a, b) => (a + b) );
// }

// 23. 내적
// function solution(a, b) {
//     let answer = 0;
//     for(let i=0; i<a.length; i++) {
//         answer += a[i] * b[i];
//     }
//     return answer;
// }
// let arr1 = [1,2,3,4];
// let arr2 = [-3,-1,0,2];
// console.log(solution(arr1, arr2));

// 24. 문자열 내림차순으로 배치하기
// function solution(s) {
//     return s.split('').sort().reverse().join('');
// }
// console.log(solution("Zbcdefg"));

// 25. 문자열 다루기 기본
function solution(s) {
    if(s.length<4 || s.length>6) return false;
    let answer = Number(s);
    if(isNaN(answer)!==true) return true;
    else                     return false;
}
console.log(solution("1234"));