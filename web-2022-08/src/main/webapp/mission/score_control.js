/**
 * 성적 CRUD
 * 작성일: 2022-08-30
 */
let data = [
	{'number' : '1', 'subject' : 'kor', 'score' : '100'},
	{'number' : '2', 'subject' : 'eng', 'score' : '90'},
	{'number' : '3', 'subject' : 'his', 'score' : '95'},
	{'number' : '4', 'subject' : 'kor', 'score' : '65'},
	{'number' : '5', 'subject' : 'eng', 'score' : '35'},
	{'number' : '6', 'subject' : 'his', 'score' : '100'}
];

let template;
let frm = document.frm_score;
function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	for(v of data){
		template = 
			`
			<div class = 'item' onclick = 'view("${v.number}")'>
				<span class = 'number'>${v.number}</span>
				<span class = 'subject'>${v.subject}</span>
				<span class = 'score'>${v.score}</span>
			</div>
			`
		items.innerHTML += template;
	}
}
list();

/* 평균 */
function a(){
	let result = document.querySelector('#result');  // 평균 출력 위치
	let scoreData = data.map(v=>v.score);            // 배열 data에서 키값이 score인 밸류값들을 모아서 만든 배열
	let sum = scoreData.reduce(function(r,v){        // 합계
		r += Number(v);
		return r;
	},0);
	
	let avg = sum/scoreData.length;
	result.innerHTML = '평균: ' + avg.toFixed(2);
}
a();  // 평균 계산 함수 실행

/* 조회 */
function view(number){
	let index = data.findIndex(d=>d.number==number);
	frm.number.value = data[index].number;
	frm.subject.value = data[index].subject;
	frm.score.value = data[index].score;
}

/* 입력 */
function add(frm){
	let v;
	v = {'number'  : frm.number.value,
		 'subject' : frm.subject.value,
		 'score'   : frm.score.value
	};
	
	index = data.findIndex( d=>d.number==frm.number.value );
	index2 = data.findIndex( d=>d.subject==frm.subject.value );
	if(index>=0 && index2>=0){		// 학번+과목 중복체크
		alert('해당 학번에 이미 해당 과목의 점수가 입력되어 있습니다.');
		frm.number.focus();
		return;
	}
	if(frm.number.value==''){		// 학번 입력 여부 체크
		alert('학번을 입력해 주세요.');
		frm.number.focus();
		return;
	}
	if(frm.subject.value==''){		// 과목 입력 여부 체크
		alert('과목을 입력해 주세요.');
		frm.subject.focus();
		return;
	}
	if(frm.score.value==''){		// 성적 입력 여부 체크
		alert('성적을 입력해 주세요.');
		frm.score.focus();
		return;
	}
	
	data.push(v);  // 배열 뒤에 추가
	template = 
		`
		<div class = 'item' onclick = 'view("${v.number}")'>
			<span class = 'number'>${v.number}</span>
			<span class = 'subject'>${v.subject}</span>
			<span class = 'score'>${v.score}</span>
		</div>
		`
	items.innerHTML += template;  // 목록 뒤에 추가
	a();  // 평균 계산 함수 실행
}

/* 수정 */
function update(frm){
	let index = data.findIndex( d=>d.number==frm.number.value);
	if(index>=0){
		data[index].number = frm.number.value;
		data[index].subject = frm.subject.value;
		data[index].score = frm.score.value;
		list();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정할 데이터가 없습니다.');
	}
	a();  // 평균 계산 함수 실행
}

/* 삭제 */
function deleteFunc(frm){
	let index = data.findIndex( d=>d.number==frm.number.value);
	if(index>=0){
		data.splice(index,1);
		list();
		frm.number.value='';
		frm.subject.value='';
		frm.score.value='';
	}else{
		alert('삭제할 데이터를 찾지 못했습니다.');
	}
	a();  // 평균 계산 함수 실행
}



