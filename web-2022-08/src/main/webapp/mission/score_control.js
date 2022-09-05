/**
 * 
 */
let data = [
	{'stdId' : '1', 'subject' : '국어', 'score' : '100'},
	{'stdId' : '1', 'subject' : '영어', 'score' : '90'},
	{'stdId' : '2', 'subject' : '역사', 'score' : '95'},
	{'stdId' : '2', 'subject' : '국어', 'score' : '65'},
	{'stdId' : '3', 'subject' : '영어', 'score' : '35'},
	{'stdId' : '4', 'subject' : '역사', 'score' : '100'}
];

let m_index;   // 배열의 위치값을 모든 함수에서 사용하기 위해 선언. 전역형으로 선언해두면 함수가 끝나도 사라지지 않음.
let template;  // 배열 data의 맵구조를 보기 좋게 리스트에 띄우는 작업을 쉽게 하기 위해 선언.
let frm = document.frm_score;  // form에 있는 태그나 태그 속성들을 가져오기 쉽게 객체로 선언.
List();        // List 함수는 Hoisting되기 때문에 List 함수보다 위에 적어도 상관없다.

function List(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	let tot = 0;          // score의 value 값들의 평균을 구하기 위해 합계를 먼저 선언.
	for(index in data){   // 배열 data의 맵구조를 보기 좋게 리스트에 차례대로 띄움.
						  // 리스트를 클릭하면 해당 맵구조를 View 함수에 넣어서 실행.
		v = data[index];  // ${0}, ${1}, ... -> view('0'), view('1'), ...
		template = `<div class='item' onclick='view("${index}")'>
						<span class='stdId'>${v.stdId}</span>
						<span class='subjectject'>${v.subject}</span>
						<span class='score'>${v.score}</span>
					</div>`;
		items.innerHTML += template;
		tot += Number(v.score);
	}
	items.innerHTML += '평균: ' + (tot/data.length).toFixed(2);
}

/* 조회 */
function View(index){
	m_index = index;  // form에 표시되는 인덱스가 m_index. m_index에 클릭한 리스트에 표시되는 인덱스를 매개변수로 받아서 넣어라.
	frm.stdId.value = data[index].stdId;      // 선택한 리스트의 stdId키값의 value값을 form의 텍스트 박스에 넣어라.
	frm.subject.value = data[index].subject;  // 선택한 리스트의 subject키값의 value값을 form의 텍스트 박스에 넣어라.
	frm.score.value = data[index].score;      // 선택한 리스트의 score키값의 value값을 form의 텍스트 박스에 넣어라.
}

/* 입력 */
function Add(frm){
	let v;
	v = {  // form에 입력된 value값을 맵구조로 만든다.
		'stdId'    : frm.stdId.value,
		'subject'   : frm.subject.value,
		'score' : frm.score.value
		};
	
	let items = document.querySelector('#items');
	
	ChkId  = data.findIndex( d=>d.stdId==frm.stdId.value );
	ChkSub = data.findIndex( d=>d.subject==frm.subject.value );
	
	// 학번+과목 중복체크.
	if(ChkId>=0 && ChkSub>=0){
		alert('해당 학번에 이미 해당 과목의 점수가 입력되어 있습니다.');
		frm.stdId.focus();
		return;
	}
	// 학번 입력 여부 체크
	if(frm.stdId.value==''){
		alert('학번을 확인해 주세요.')
		frm.stdId.focus();
		return;
	}
	// 과목 입력 여부와 숫자인지 체크
	if(frm.subject.value==''){
		alert('과목을 확인해 주세요.');
		frm.subject.focus();
		return;
	}
	// 성적 입력 여부 체크
	if(frm.score.value=='' || isNaN(frm.score.value)){  // 입력하지 않았거나 문자라면
		alert('성적을 확인해 주세요')
		frm.score.focus();
		return;
	}
	
	data.push(v);  // 배열뒤에 추가
	List();        // 이미 뿌려진 화면 지우고 다시 뿌림. 별로 좋은 방법은 아님.
}

/* 수정 */
function Update(frm){  // 수정을 누르는 순간 입력 상자 안의 내용이 frm이 된다.
	let index = m_index;
	
	if(index>=0){      // 수정할 데이터가 있는경우. 바꿀 수 있는 이유가 m_index가 있어서.
		data[index].stdId = frm.stdId.value;
		data[index].subject = frm.subject.value;
		data[index].score = frm.score.value;
		List();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정할 데이터가 없습니다.');
	}
}

/* 데이터 삭제 */
function deleteFunc(frm){
	let index = m_index;
	
	if(index>=0){
		data.splice(index,1);  // 중요 포인트
		List();
		frm.stdId.value='';
		frm.subject.value='';
		frm.score.value='';
		alert('데이터가 삭제되었습니다.');
	}else{
		alert('삭제할 자료를 찾지 못했습니다.');
	}
}

/* 평균 계산 type2
function a(){
	let result = document.querySelector('#result');  // 평균 출력 위치
	let scoreData = data.map(v=>v.score);            // 배열 data에서 키값이 score인 밸류값들을 모아서 만든 배열
	let sum = scoreData.reduce(function(r,v){        // 합계
		r += stdId(v);
		return r;
	},0);
	
	let avg = sum/scoreData.length;
	result.innerHTML = '평균: ' + avg.toFixed(2);
}
a();  // 평균 계산 함수 실행
 */