/**
 * 
 */
let data = [
	{'id' : '1', 'sub' : '국어', 'score' : '100'},
	{'id' : '1', 'sub' : '영어', 'score' : '90'},
	{'id' : '2', 'sub' : '역사', 'score' : '95'},
];

let frm = document.frm_score;
let m_index;  // 배열의 인덱스를 모든 function에서 사용하기 위해 밖에 선언.
let template;

function List(){
	let items = document.querySelector('#items');
	let tot = 0;  // 평균을 구하기 위한 score 합계.
	for(index in data){
		v = data[index];  // ${0}, ${1}, ... -> view('0'), view('1'), ...
		template = `<div class='item' onclick='view("${index}")'>
						<span class='id'>${v.id}</span>
						<span class='subject'>${v.sub}</span>
						<span class='score'>${v.score}</span>
					</div>`;
		items.innerHTML += template;
		tot += Number(v.score);
	}
	items.innerHTML += '평 균 : ' + (tot/data.length).toFixed(1);
}
List();

function View(index){
	m_index = index;  // input에 있는게 m_index. 전역형.
	let frm = document.frm_score;
	frm.id.value = data[index].id;
	frm.sub.value = data[index].sub;
	frm.score.value = data[index].score;
}

/* 입력 */
function Add(frm){
	let v;
	let items = document.querySelector('#items');
	let index;
	
	if(frm.id.value==''){
		status.innerHTML = '학번을 확인해 주세요.';
		frm.id.focus();
		return;
	}
	
	if(frm.sub.value==''){
		status.innerHTML = '과목을 확인해 주세요.';
		frm.sub.focus();
		return;
	}
	
	if(frm.score.value=='' || isNaN(frm.score.value)){  // 입력하지 않았거나 문자라면
		status.innerHTML = '성적을 확인해 주세요';
		frm.score.focus();
		return;
	}
	
	// form 값을 {}로 만들어 data에 push
	v = {'id'    : frm.id.value,
		 'sub'   : frm.sub.value,
		 'score' : frm.score.value
	};
	data.push(v);  // 배열뒤에 추가
	List();  // 이미 뿌려진 화면 지우고 다시 뿌림. 별로 좋은 방법은 아님.
}

/* 수정 */
function Update(frm){  // 수정을 누르는 순간 입력 상자 안의 내용이 frm이 된다.
	let index = m_index;
	
	if(index>=0){      // 수정할 데이터가 있는경우. 바꿀 수 있는 이유가 m_index가 있어서.
		data[index].id = frm.id.value;
		data[index].sub = frm.sub.value;
		data[index].score = frm.score.value;
		List();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정할 데이터가 없습니다.');
	}
}

/* 삭제 */
function deleteFunc(frm){
	let index = m_index;
	
	if(index>=0){
		data.splice(index,1);  // 중요 포인트
		List();
		frm.id.value='';
		frm.sub.value='';
		frm.score.value='';
		alert('데이터가 삭제되었습니다.');
	}else{
		alert('삭제할 자료를 찾지 못했습니다.');
	}
}