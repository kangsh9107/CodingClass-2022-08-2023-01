// 31. 같은 숫자는 싫어
function solution(arr) {
    let answer = [];

    answer = arr.filter((v, i) => arr.indexOf(v) === i);

    return answer;
}
let arr = [1,1,3,3,0,1,1];
console.log(solution(arr));