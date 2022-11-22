let data = [
	{'id' : 'a001', 'name' : 'hong', 'gender' : 'm', 'phone' : '010-1111-1111'},
	{'id' : 'b001', 'name' : 'kim',  'gender' : 'f', 'phone' : '010-2222-2222'},
	{'id' : 'c001', 'name' : 'lee',  'gender' : 'f', 'phone' : '010-3333-3333'}  // 이거 하나가 v
];

/***** 검색 *****/
let template;
const frmSearch = document.frm_search;

frmSearch.btnFind.addEventListener("click", function() {
	list();
});

function list(){
	let items = document.querySelector('#items_member_control');
	items.innerHTML = '';
	let findStr = frmSearch.findStr.value;
	
	let xhr = new XMLHttpRequest();
	xhr.open("post", "memberServlet.do?job=select&findStr=" + findStr);
	xhr.send(); // 원래는 밑에서 코드를 다 처리 한 후 send하는게 정석이지만 가독성을 위해 올렸다.
	            // 서버연결되는 속도보다 빨라서 상관없다.
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			let data = JSON.parse(xhr.responseText);
			for(v of data){
				template = `
					<div class='item_member_control' onclick='view("${v.id}")'>
						<span class='span_id_member_control'>${v.id}</span>
						<span class='span_name_member_control'>${v.name}</span>
						<span class='span_gender_member_control'>${v.gender}</span>
						<span class='span_phone_member_control'>${v.phone}</span>
					</div>
				`;
				items.innerHTML += template;
			}
		}
	}
}
list();

// 조회
function view(id){
	let index = data.findIndex(d=>d.id==id);
	let frm = document.frm_member;
	frm.id.value = data[index].id;
	frm.name.value = data[index].name;
	frm.phone.value = data[index].phone;
	
	if(data[index].gender=='m') frm.gender[0].checked = true;
	else                        frm.gender[1].checked = true;
}

// 추가
function add(frm){
	let index = data.findIndex( d=>d.id==frm.id.value );
	
	if(index>=0){
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return;
	} else if(!frm.gender[0].checked && !frm.gender[1].checked){
		alert('성별을 체크해 주세요.');
		return;
	} else if(frm.name.value==''){
		alert('성명을 확인해 주세요');
		frm.name.focus();
		return;
	} else if(frm.phone.value==''){
		alert('연락처를 확인해 주세요');
		frm.phone.focus();
		return;
	}
	
	/***** enctype이 있는 form을 multipart 타입으로 변환 *****/
	let fd = new FormData(frm);
	let xhr = new XMLHttpRequest();
	xhr.open("post", "memberUpload.do");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			msg = xhr.responseText;
			alert(msg);
		}
	}
	xhr.send(fd);
}

// 수정
function update(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	let g;
	if(frm.gender[0].checked) g=frm.gender[0].value;
	else                      g=frm.gender[1].value;
	
	if(index>=0){
		data[index].name = frm.name.value;
		data[index].phone = frm.phone.value;
		data[index].gender = g;
		list();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정할 데이터가 없습니다.');
	}
}

// 삭제
function deleteFunc(frm){
	let index = data.findIndex(d=>d.id==frm.id.value);
	if(index>=0){
		data.splice(index,1);
		list();
		frm.id.value='';
		frm.name.value='';
		frm.phone.value='';
		frm.gender[0].checked=false;
		frm.gender[1].checked=false;
	}else{
		alert('삭제할 자료를 찾지 못했습니다.');
	}
}

// 이미지 미리보기
let btnFile = document.querySelector('#photo_file_member_control');
let photo = document.querySelector('#photo_member_control');

photo.onclick = function() {
	btnFile.click();
}

btnFile.onchange = function(ev){
	let file = ev.srcElement.files[0];
	let reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onload = function(){
		let tempImg = new Image();
		tempImg.src = this.result;
		photo.src = tempImg.src;
	}
}