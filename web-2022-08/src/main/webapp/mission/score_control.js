/**
 * 성적 CRUD
 * 작성일: 2022-08-30
 */
let data = [
	{'stdId' : '1', 'subject' : '국어', 'score' : '100'},
	{'stdId' : '1', 'subject' : '영어', 'score' : '90'},
	{'stdId' : '2', 'subject' : '역사', 'score' : '95'},
	{'stdId' : '2', 'subject' : '국어', 'score' : '65'},
	{'stdId' : '3', 'subject' : '영어', 'score' : '35'},
	{'stdId' : '4', 'subject' : '역사', 'score' : '100'}
];

let template;     // 배열 data의 인덱스를 보기 좋게 리스트에 띄우는 작업을 쉽게 하기 위해 선언.
let m_index;      // 배열의 위치값을 모든 함수에서 사용하기 위해 선언. 전역형으로 선언해두면 함수 끝나도 사라지지 않음.
let frm = document.frm_score;  // form에 있는 태그나 태그 속성들을 가져오기 쉽게 객체로 선언.

List();           // List 함수는 Hoisting되기 때문에 List 함수보다 위에 적어도 상관없다.

function List(){  // 
	let items = document.querySelector('#items');
	let avg = document.querySelector('#avg');
	let tot = 0;  // 평균 계산을 위한 합계 선언.
	for(var v in data){        // 배열 data의 인덱스를 보기 좋게 리스트에 차례대로 띄움.
							   // 리스트의 인덱스를 클릭하면 View 함수 실행.
		template = `<div class = 'item' onclick = 'View("${v}")'>
						<span class = 'stdId'>${data[v].stdId}</span>
						<span class = 'subject'>${data[v].subject}</span>
						<span class = 'score'>${data[v].score}</span>
					</div>`;
		items.innerHTML += template;
		tot += Number(data[v].score);
	}
	avg.innerHTML = '평균: ' + (tot/data.length).toFixed(2);
}

/* 조회 */
function View(v){
	m_index = v;
	frm.stdId.value = data[v].stdId;
	frm.subject.value = data[v].subject;
	frm.score.value = data[v].score;
}

/* 입력 */
function Add(frm){
	let v;
	v = {'stdId'   : frm.stdId.value,
		 'subject' : frm.subject.value,
		 'score'   : frm.score.value
		};
	
	ChkId  = data.findIndex( d=>d.stdId==frm.stdId.value );
	Chksub = data.findIndex( d=>d.subject==frm.subject.value );
	if(index>=0 && index2>=0){		// 학번+과목 중복체크
		alert('해당 학번에 이미 해당 과목의 점수가 입력되어 있습니다.');
		frm.stdId.focus();
		return;
	}
	if(frm.stdId.value==''){		// 학번 입력 여부 체크
		alert('학번을 입력해 주세요.');
		frm.stdId.focus();
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
		<div class = 'item' onclick = 'view("${v.stdId}")'>
			<span class = 'stdId'>${v.stdId}</span>
			<span class = 'subject'>${v.subject}</span>
			<span class = 'score'>${v.score}</span>
		</div>
		`
	items.innerHTML += template;  // 목록 뒤에 추가
	a();  // 평균 계산 함수 실행
}

/* 수정 */
function update(frm){
	let index = data.findIndex( d=>d.stdId==frm.stdId.value);
	if(index>=0){
		data[index].stdId = frm.stdId.value;
		data[index].subject = frm.subject.value;
		data[index].score = frm.score.value;
		List();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정할 데이터가 없습니다.');
	}
	a();  // 평균 계산 함수 실행
}

/* 삭제 */
function deleteFunc(frm){
	let index = data.findIndex( d=>d.stdId==frm.stdId.value);
	if(index>=0){
		data.splice(index,1);
		List();
		frm.stdId.value='';
		frm.subject.value='';
		frm.score.value='';
	}else{
		alert('삭제할 데이터를 찾지 못했습니다.');
	}
	a();  // 평균 계산 함수 실행
}

/* 평균 계산 내 코드
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