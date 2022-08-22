<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p220822.jsp</title>
</head>
<body>
<!-- 인터넷 연습문제 1.
<p>
	if..else와 프롬프트 대화상자를 사용해 사용자로부터 숫자 하나를 입력받고,<br/>
	아래 조건에 따라 그 결과를 alert 창에 출력해 보세요.<br/>
	(1) 입력받은 숫자가 0보다 큰 경우 1을 출력<br/>
	(2) 입력받은 숫자가 0보다 작은 경우 -1을 출력<br/>
	(3) 입력받은 숫자가 0인 경우 0을 출력<br/>
</p>
<label>숫자</label>
<input type='text' placeholder='숫자를 입력해주세요.' id='number'/><br/>
<input type='button' value='확인' id='btn'/><br/>
------
<label>몸무게</label>
<input type='text' size='2' value='80' id='weight'/><br/>
<label>키</label>
<input type='text' size='2' value='190' id='height'/><br/>
<label>탑승여부</label>
<output id='ok'></output><br/>
<input type='button' value='확인' id='btn'/>
------
<p>
	지역과, 성별을 input 태그로 입력받아 서울여자라면 "참"을
	아니면 "거짓"을 console창에 출력하시오.
</p>
<span>지역</span>
<input type='text' value='서울' size='3' id='zone'/><br/>
<span>성별</span>
<input type='text' value='여자' size='3' id='gender'/><br/>
<span>진실 혹은 거짓: </span>
<output id='result'></output><br/>
<input type='button' value='확인' id='btn'/>
 -->
 <p>
	3개의 점수를 입력하세요.
</p>
<span>국어</span>
<input type='text' id='kor' size='2' value='100'/><br/>
<span>영어</span>
<input type='text' id='eng' size='2' value='100'/><br/>
<span>수학</span>
<input type='text' id='mat' size='2' value='100'/><br/>
<input type='button' id='btn' value='계산'/><br/>
<span>총점</span>
<output id='tot'></output><br/>
<span>평균</span>
<output id='avg'></output><br/>
<span>학점</span>
<output id='grade'></output><br/>
<script>
/* 
let zone;
let km;
let price;
let amt;
zone = prompt("시내? 시외?", "시외");
km = prompt("주행 거리는 ?", 20);
price = prompt("기본 단가", 2000);

document.write('<li>zone :' + zone);
document.write('<li>km :' + km);
document.write('<li>price :' + price);
 */
/* 
let number = document.querySelector('#number');
let btn = document.querySelector('#btn');
btn.onclick = function(){
	console.log('버튼을 클릭했습니다.');
	if(number.value > 0){
		document.write(1);
	}else if(number.value < 0){
		document.write(-1);
	}else{
		document.write(0);
	}
}
 */
/* 
let number = prompt('숫자를 입력하세요.', 0);
if(number > 0){
	alert(1);
}else if(number < 0){
	alert(-1);
}else{
	alert(0);
}
 */
/* 
let w = document.querySelector('#weight');
let h = document.querySelector('#height');
let btn = document.querySelector('#btn');
let ok = document.querySelector('#ok');
btn.onclick = function(){
	console.log('버튼을 클릭했습니다.');
	let a = Number(w.value);
	let b = Number(h.value);
	let c;
	if(a>=150 && b>=200){
		c = '탑승가능';
	}else{
		c = '탑승불가능';
	}
	ok.innerHTML = c;
}
 */
/* 
let zone = document.querySelector('#zone');
let gender = document.querySelector('#gender');
let btn = document.querySelector('#btn');
let result = document.querySelector('#result');
btn.onclick = function(){
	let a = zone.value;
	let b = gender.value;
	let c;
	if(a=='서울' && b=='여자'){
		c = '진실'
	}else{
		c = '거짓'
	}
	result.innerHTML = c;
}
 */
let tot2 = Number(kor) + Number(eng) + Number(mat);
let avg2 = Number(tot) / Number(3.0);
let grade2;

let kor = document.querySelector('#kor');
let eng = document.querySelector('#eng');
let mat = document.querySelector('#mat');
let btn = document.querySelector('#btn');
let tot = document.querySelector('#tot');
let avg = document.querySelector('#avg');
let grade = document.querySelector('#grade');
btn.onclick = function(){
	if(avg > 90){
		grade = 'A';
	}else if(avg > 80){
		grade = 'B';
	}else if(avg > 70){
		grade = 'C';
	}else if(avg > 60){
		grade = 'D';
	}else{
		grade = 'F';
	}
	tot.innerHTML = tot2;
	avg.innerHTML = avg2;
	grade.innerHTML = grade2;
}
</script>

</body>
</html>


