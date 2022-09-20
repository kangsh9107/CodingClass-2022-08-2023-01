let list = []; // 전체 데이터 저장
let gIndex;    // index를 전역변수에 대입해서 활용하기 위해 선언
let frm = document.frm;

/* 모듈화 */
function Score(serial, id, subject, score) {
  this.serial = serial;
  this.id = id;
  this.subject = subject;
  this.score = score;

  this.output = function() {
    let str = `
              <div class="item" onclick="View('${this.serial}')">
                <span class="serial">${this.serial}</span>
                <span class="id">${this.id}</span>
                <span class="subject">${this.subject}</span>
                <span class="score">${this.score}</span>
              </div>
              `;
    return str;
  }
}

/* 과목 추가 */
let subject = ["HTML", "CSS", "JavaScript", "jQuery", "MySQL", "Java", "Spring", "python"];

for(s of subject) {
  frm.subject.options.add( new Option(s, s) );
}

/* 조회 */
function View(serial) {
  gIndex = list.findIndex( l => l.serial==serial );

  frm.serial.value = list[gIndex].serial;
  frm.id.value = list[gIndex].id;
  frm.subject.value = list[gIndex].subject;
  frm.score.value = list[gIndex].score;
}

/* 저장 */
frm.btnSave.onclick = function() {
	let serial = Number(frm.serial.value);
  let id = frm.id.value;
  let score = Number(frm.score.value);
	let subject = frm.subject.value;
  let d = new Score(serial, id, subject, score);
  gIndex = list.findIndex( l => l.serial==frm.serial.value );

	Check();
	
	if(gIndex>=0) {
    ft.innerHTML = "SERIAL이 중복되었습니다.";
    frm.serial.focus();
		resetFooter();
    return;
  } else {
    list.push(d);
    ft.innerHTML = "데이터를 저장 했습니다.";
		resetFooter();  
  }
  
  Refresh(); // 성적현황 LIST 최신화
}

/* 수정 */
frm.btnUpdate.onclick = function() {
	Check();

  if(gIndex>=0) {
    list[gIndex].id = frm.id.value;
    list[gIndex].subject = frm.subject.value;
    list[gIndex].score = frm.score.value;
    ft.innerHTML = "데이터가 수정되었습니다.";
		resetFooter();
  }
  
  Refresh();
}

/* 삭제 */
frm.btnDelete.onclick = function() {
  if(gIndex>=0) {
    list.splice(gIndex, 1);
    frm.serial.value="";
    frm.id.value="";
    frm.subject.value="";
    frm.score.value="";
    ft.innerHTML = "선택한 데이터가 삭제 되었습니다.";
    gIndex = -1; // 마지막으로 선택한 index 초기화
  } else {
    ft.innerHTML = "삭제할 데이터를 선택 해주세요.";
  }
  
  resetFooter();
  Refresh();
}

/* SERIAL 검색 */
frm.btnFindSerial.onclick = function() {
  gIndex = frm.serial.value;

	Check();
	View(gIndex);
	ft.innerHTML = "검색한 SERIAL의 데이터를 가져 왔습니다.";
	resetFooter();
}

/* 성적현황 LIST 필터 */
let findText = document.querySelector("#findText");
let btnFilter = document.querySelector("#btnFilter");
let btnFilterClear = document.querySelector("#btnFilterClear");

btnFilter.addEventListener("click", Filter);
btnFilterClear.addEventListener("click", FilterClear);

function Filter() {
  let sp = findText.value.split("");     // 입력된 문자열을 공백을 기준으로 잘라서 배열 sp 정의

  let filter = list.filter(function(l) { // 입력된 문자열들 중 한 글자 이상이 id와 subject에 포함 되어 있다는 조건을 갖춘 새로운 배열 filter 정의
    let flag = false;
		for(v of sp) {
			if(l.id.indexOf(v)!=-1) {
				flag = true;
			} else if(l.subject.indexOf(v)!=-1) {
				flag = true;
			}
		}
		return flag;
  });

	let items = document.querySelector(".items");
	items.innerHTML = "";

	for(l of filter) { // 필터링 한 성적현황 LIST 출력
		items.innerHTML += l.output();
	}

	ft.innerHTML = "필터 완료";
	resetFooter();
}

findText.onkeyup = function(ev) { // Enter 키로 검색
	if(ev.keyCode==13) Filter();

	ft.innerHTML = "필터 완료";
	resetFooter();
}

function FilterClear() {
	Refresh();
	findText.value = "";

	ft.innerHTML = "필터 해제 완료";
	resetFooter();
}

/* form 항목 체크 */
function Check() {
  let serial = Number(frm.serial.value);
  let id = frm.id.value;
  let score = Number(frm.score.value);
  gIndex = list.findIndex( l => l.serial==frm.serial.value );

	if(serial<0 || Number.isInteger(serial)==false || serial=="") {
		ft.innerHTML = "SERIAL에 양의 정수를 입력 해주세요.";
		frm.serial.focus();
		resetFooter();
		return;
	} else if(id=="") {
    ft.innerHTML = "학번을 입력 해주세요.";
    frm.id.focus();
		resetFooter();
    return;
  } else if(score<0 || Number.isInteger(score)==false || score=="") {
    ft.innerHTML = "성적에 양의 정수를 입력해 주세요.";
    frm.score.focus();
		resetFooter();
    return;
	}
}

/* 성적현황 LIST 최신화 */
function Refresh() {
  let items = document.querySelector(".items");
  items.innerHTML = "";

  for(l of list) {
    items.innerHTML += l.output();
  }
}

/* 하단 안내창 5초 후 초기화 */
let ft = document.querySelector("#footer");

function resetFooter() {
  let count = setTimeout( () => ft.innerHTML += " ( 5초 후 사라집니다. )", 1 );
  for(let i=0; i<count; i++) { // 가장 마지막에 실행된 setTimeout을 제외한 setTimeout 전부 중지
    clearTimeout(i);
  }

  setTimeout( () => ft.innerHTML = "성공기원", 5000);
}