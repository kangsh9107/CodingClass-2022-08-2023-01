/**
 * 
 */
let m_index;  // 배열의 위치값을 모든 fuction에서 사용하기 위해.

let data=[
	{'id' : 'a001', 'subject' : '국어',    'score' : 99},
	{'id' : 'a002', 'subject' : '수학',    'score' : 89},
	{'id' : 'a003', 'subject' : '바른생활', 'score' : 79},
	{'id' : 'a004', 'subject' : '세계사',   'score' : 69},
	{'id' : 'a001', 'subject' : '한국사',   'score' : 79},
	{'id' : 'a001', 'subject' : '산수',    'score' : 89},
	{'id' : 'a002', 'subject' : '영어',    'score' : 95},
	{'id' : 'a002', 'subject' : '독어',    'score' : 94},
	{'id' : 'a003', 'subject' : '일어',    'score' : 93},
];
let template;
list();

function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	let tot=0;
	for(index in data){
		v = data[index];
		template = 
			`
			<div class='item' onclick='view("${index}")'>
				<span class='id'>${v.id}</span>
				<span class='subject'>${v.subject}</span>
				<span class='score'>${v.score}</span>
			`
		items.innerHTML += (template);
		tot += Number(v.score);
	}
	items.innerHTML += '평 균 : ' + (tot/data.length).toFixed(1);
}

function view(index){
	m_index = index;
	let frm = document.frm_score;
	frm.id.value = data[index].id;
	frm.subject.value = data[index].subject;
	frm.score.value = data[index].score;
}
// 데이터 추가

function add(frm){
	let v;
	let items = document.querySelector('#items');
	let status = document.querySelector('.status');
	
	// 학번 입력 여부 체크
	if(frm.id.value==''){
		status.innerHTML = ('학번을 확인해 주세요');
		frm.id.focus();
		return;
	}
	
	// 과목 입력 여부 체크
	if(frm.subject.value==''){
		status.innerHTML = ('과목을 확인해 주세요');
		frm.subject.focus();
		return;
	}
	
	// 성적 입력 여부 체크
	if(frm.score.value==''){
		status.innerHTML = ('성적을 확인해 주세요');
		frm.score.focus();
		return;
	}
	
	// form 값을 {}로 만들어 data에 push
	v = {
		'id' : frm.id.value, 'subject' : frm.subject.value,
		'score' : frm.score.value
		};
	data.push(v);  // 배열뒤에 추가
	
	list();
}

function update(frm){
	let index = m_index;
	let status = document.querySelector('.status');
	
	if(index>=0){  // 수정할 데이터가 있는 경우
		data[index].id = frm.id.value;
		data[index].subject = frm.subject.value;
		data[index].score = frm.score.value;
		list();
		status.innerHTML = ('데이터가 수정되었습니다.');
	}else{
		status.innerHTML = ('수정할 데이터가 없습니다.');
	}
}

function deleteFunc(frm){
	let index = m_index;
	let status = document.querySelector('.status');
	
	if(index>=0){
		data.splice(index,1);
		list();
		frm.id.value='';
		frm.subject.value='';
		frm.score.value='';
		status.innerHTML = '데이터가 삭제되었습니다.';
	}else{
		status.innerHTML = ('삭제할 자료를 찾지 못했습니다.');
	}
}