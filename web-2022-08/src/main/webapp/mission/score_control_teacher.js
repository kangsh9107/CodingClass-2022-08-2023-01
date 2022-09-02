/**
 * 
 */
let data = [
	{'id' : '1', 'sub' : '국어', 'score' : '100'},
	{'id' : '1', 'sub' : '영어', 'score' : '90'},
	{'id' : '2', 'sub' : '역사', 'score' : '95'},
];

let m_index;  // 배열의 인덱스 위치값을 모든 function에서 사용하기 위해.
let frm = document.frm_score;
let template;
List();

function List(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	let tot = 0;          // score 합계
	for(index in data){
		v = data[index];  // ${0}, ${1}, ... -> view('0'), view('1'), ...
		template = 
			`
			<div class='item' onclick='view("${index}")'>
				<span class='id'>${v.id}</span>
				<span class='subject'>${v.sub}</span>
				<span class='score'>${v.score}</span>
			</div>
			`;
		items.innerHTML += template;
		tot += Number(v.score);
	}
	items.innerHTML += '평 균 : ' + (tot/data.length).toFixed(1);
}

function View(index){
	m_index = index;  // input에 있는게 m_index. 전역형.
	let frm = document.frm_score;
	frm.id.value = data[index].id;
	frm.sub.value = data[index].sub;
	frm.score.value = data[index].score;
}

/* 데이터 추가 */
function Add(frm){
	let v;
	let items = document.querySelector('#items');
	let status = document.querySelector('.status');
	
	// 학번 입력 여부 체크
	if(frm.id.value==''){
		status.innerHTML = '학번을 확인해 주세요.';
		frm.id.focus();
		return;
	}
	// 과목 입력 여부 체크
	if(frm.sub.value==''){
		status.innerHTML = '과목을 확인해 주세요.';
		frm.sub.focus();
		return;
	}
	// 성적 입력 여부 체크
	if(frm.score.value=='' || isNaN(frm.score.value)){  // 입력하지 않았거나 문자라면
		status.innerHTML = '성적을 확인해 주세요';
		frm.score.focus();
		return;
	}
	// form 값을 {}로 만들어 data에 push
	v = {
		'id'    : frm.id.value,
		'sub'   : frm.sub.value,
		'score' : frm.score.value
		};
	// 배열뒤에 추가
	data.push(v);
	
	List();  // 이미 뿌려진 화면 지우고 다시 뿌림. 별로 좋은 방법은 아님.
}

/* 데이터 수정 */
function Update(frm){  // 수정을 누르는 순간 입력 상자 안의 내용이 frm이 된다.
	let index = m_index;
	let status = document.querySelector('.status');
	
	if(index>=0){      // 수정할 데이터가 있는경우. 바꿀 수 있는 이유가 m_index가 있어서.
		data[index].id = frm.id.value;
		data[index].sub = frm.sub.value;
		data[index].score = frm.score.value;
		List();
		status.innerHTML = '데이터가 수정되었습니다.';
	}else{
		status.innerHTML = '수정할 데이터가 없습니다.';
	}
}

/* 데이터 삭제 */
function deleteFunc(frm){
	let index = m_index;
	let status = document.querySelector('.status');
	
	if(index>=0){
		data.splice(index,1);  // 중요 포인트
		List();
		frm.id.value='';
		frm.sub.value='';
		frm.score.value='';
		status.innerHTML = '데이터가 삭제되었습니다.';
	}else{
		status.innerHTML = '삭제할 자료를 찾지 못했습니다.';
	}
}