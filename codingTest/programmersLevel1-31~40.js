// 31. 같은 숫자는 싫어
function solution(arr) {
    let answer = [];
    for(let i=0; i<arr.length; i++) {
        if(arr[i]===arr[i+1]) answer.push(arr[i]);
    }

    return answer;
}
let arr = [1,1,3,3,0,1,1];
console.log(solution(arr));