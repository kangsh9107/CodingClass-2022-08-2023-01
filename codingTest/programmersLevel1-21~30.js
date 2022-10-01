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
// function solution(s) {
//     if(s.length!==4 && s.length!==6) {
//         return false;
//     } else {
//         return s.split('').every( v => !isNaN(v) );
//     }
// }
// console.log(solution("a234"));
// console.log(solution("1234"));

// every()는 배열 안의 모든 요소가 주어진 판별함수를 만족하면 true 아니면 false 반환

// 다른 사람 코드
//function solution(s) {
//    let reg = /^\d{6}$|^\d{4}$/;
//    return reg.test(s);
//}

// 26. 약수의 개수와 덧셈
// function solution(left, right) {
//     let answer = 0;
//     let yak = [1];
//     for(let i=left; i<=right; i++) {
//         yak = [1];
//         for(let k=2; k<=i; k++) {
//             if(i%k===0) yak.push(k);
//         }
//         if(yak.length%2===0) answer += i;
//         else                 answer -= i;
//     }
//     return answer;
// }
// let left = 13;
// let right = 17;
// console.log(solution(left, right));

// 27. 행렬의 덧셈
// 다른 사람 풀이
// function solution(arr1, arr2) {
//     let answer = [];
//     for(let i=0; i<arr1.length; i++) {
//         let temp = [];
//         for(let k=0; k<arr1[i].length; k++) {
//             temp.push(arr1[i][k] + arr2[i][k]);
//         }
//         answer.push(temp);
//     }
//     return answer;
// }
// let arr1 = [[1,2], [2,3]];
// let arr2 = [[3,4], [5,6]];
// console.log(solution(arr1, arr2));

/*
0,0 0,1
0,0+0,0   0,1+0,1

0,0 0,1   1,0 1,1
0,0+0,0   0,1+0,1
1,0+1,0   1,1+1,1

0,0 0,1 0,2   1,0 1,1 1,2   2,0 2,1 2,2
0,0+0,0+0,0   0,1+0,1+0,1   0,2+0,2+0,2
1,0+1,0+1,0   1,1+1,1+1,1   1,2+1,2+1,2
2,0+2,0+2,0   2,1+2,1+2,1   2,2+2,2+2,2
*/

// 28. 부족한 금액 계산하기
// function solution(price, money, count) {
//     let answer = 0;
//     let a = 0;
//     for(i=1; i<=count; i++) {
//         a += price * i;
//     }
//     if(money-a>=0) return answer;
//     else           return answer = a - money;
// }
// let price = 3;
// let money = 20;
// let count = 4;
// console.log(solution(price, money, count));

// 29. 직사각형 별찍기 //////////////////////////////////////////////////
// function solution(n, m) {
//     let answer = "";
//     let answer2 = "";
//     for(let i=1; i<=n; i++) {
//         answer += "*";
//     }
//     answer += "\n";
//     for(let k=1; k<=m; k++) {
//         answer2 += answer;
//     }
//     return answer2;
// }
// console.log(solution(6, 3));

// 다른 사람 풀이
// process.stdin.setEncoding('utf8');
// process.stdin.on('data', data => { // 입력받은 숫자를 'data'에 받는다
//     const n = data.split(" ");     // data(입력받은 숫자)를 배열로 변경
//     const a = Number(n[0]), b = Number(n[1]); // a는 한 줄에 대한 별의 갯수, b는 몇 줄 출력
//     for(let i=0; i<b; i++){
//         let str = "";
//         for(let j=0; j<a; j++){
//             str = str + "*"
//         } 
//     console.log(str)
//     }
// });

// 30. 최대공약수와 최소공배수 //////////////////////////////////////////////////
function solution(n, m) {
    let yakMax = 0;
    let gongMin = 2;

    for(let i=1; i<=Math.min(n,m); i++) {
        if(n%i===0 && m%i===0) yakMax = i;
    }

    for(let i=gongMin; true; i++) {
        if(i%n===0 && i%m===0) {
            gongMin = i;
            break;
        }
    }

    return [yakMax, gongMin];
}
console.log(solution(3, 12));