/***** 검색 *****/
//frmSearch.btnFind.onclick = list;
//frmSearch.btnFind.onclick = function(){}은 다른곳에서 함수를 호출할 수 없다.

let template;
const frmSearch = document.frm_search;

frmSearch.btnFind.addEventListener("click", function() {
	list();
});

function list(){
	let items = document.querySelector("#items_member_control");
	items.innerHTML = "";
	
	let xhr = new XMLHttpRequest();
	xhr.open("post", "memberServlet.do");
	// 서버에 보내는 데이터 형식을 설정(open부터 하고 해야한다.)
	// 서버에 POST 방식으로 데이터를 보내는 경우 MIME 타입을 설정한다.
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	// 원래는 밑에서 코드를 다 처리 한 후 send하는게 정석이지만 가독성을 위해 올렸다.
	// 서버연결되는 속도보다 빨라서 상관없다.
	xhr.send(`findStr=${frmSearch.findStr.value}`);
	
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

/***** 조회 *****/
const frm_member_control = document.frm_member;

function view(id){
	let img = document.querySelector("#photo_member_control");
	
	let xhr = new XMLHttpRequest();
	xhr.open("post", "memberServlet.do?job=view&id=" + id);
	xhr.send();
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			let obj = JSON.parse(xhr.responseText);
			
			frm_member_control.reset(); // file tag에는 마지막에 선택되어 있는 값이 계속 남아있다. 그걸 초기화.
			                            // 리스트 선택시 view가 실행되어 이미지가 보이는건 파일태그에 이미지가 선택된게 아니라 이미지태그에서 보여주는 것.
			
			frm_member_control.id.value = obj.id;
			frm_member_control.name.value = obj.name;
			frm_member_control.phone.value = obj.phone;
			
			if(obj.gender == "m") {
				frm_member_control.gender[0].checked = true;
			} else {
				frm_member_control.gender[1].checked = true;
			}
			
			img.src = "upload/" + obj.sysFile;
			// update 시 기존 사진 삭제하기 위해서 기존 사진 파일명을 hidden 태그에 넣어준다.
			// 그냥 sql 문장을 날려서 삭제해도 상관없지만 서버 부담을 줄이기 위한 방법이다.
			frm_member_control.delFile.value = obj.sysFile;
		}
	}
}

/***** 추가 *****/
function add(frm){
	/*
	let index = data.findIndex( d=>d.id==frm.id.value );
	if(index>=0) {
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return;
	} else if(!frm.gender[0].checked && !frm.gender[1].checked) {
		alert('성별을 체크해 주세요.');
		return;
	} else if(frm.name.value=='') {
		alert('성명을 입력해 주세요');
		frm.name.focus();
		return;
	} else if(frm.phone.value=='') {
		alert('연락처를 입력해 주세요');
		frm.phone.focus();
		return;
	}
	*/
	
	/***** enctype이 있는 form을 multipart 타입으로 변환 *****/
	let fd = new FormData(frm);
	let xhr = new XMLHttpRequest();
	xhr.open("post", "memberUpload.do?job=create");
	xhr.send(fd);
	/*
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			msg = xhr.responseText;
			alert(msg);
			list();
		}
	}
	*/
}

/***** 수정 *****/
function update(frm){
	let index = data.findIndex( d=>d.id==frm.id.value );
	if(index>=0) {
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return;
	} else if(!frm.gender[0].checked && !frm.gender[1].checked) {
		alert('성별을 체크해 주세요.');
		return;
	} else if(frm.name.value=='') {
		alert('성명을 입력해 주세요');
		frm.name.focus();
		return;
	} else if(frm.phone.value=='') {
		alert('연락처를 입력해 주세요');
		frm.phone.focus();
		return;
	}
	
	let fd = new FormData(frm);
	let xhr = new XMLHttpRequest();
	xhr.open("post", "memberUpload.do?job=update");
	xhr.send(fd);
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			msg = xhr.responseText;
			alert(msg);
			list();
		}
	}
}

/***** 삭제 *****/
function deleteFunc(frm){
	let yn = confirm("정말 삭제??");
	if( !yn ) return;
	
	let id = frm.id.value;
	let delFile = frm.delFile.value;
	let url = `memberServlet.do?job=delete&id=${id}&delFile=${delFile}`;
	let xhr = new XMLHttpRequest();
	xhr.open("post", url);
	xhr.send();
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			let msg = xhr.responseText;
			alert(msg);
			frmSearch.btnFind.click(); // 새로고침
		}	
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