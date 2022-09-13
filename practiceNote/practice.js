let list = []; // 전체 데이터 저장
let gIndex;    // index를 전역변수로 활용
let frm = document.frm; // form을 객체로 선언
let ft = document.querySelector("#footer"); // 하단 상태창

// 과목 추가
let subject = [
               "HTML" , "CSS"   , "JavaScript",
               "Java" , "python", "Spring"    ,
               "MySQL", "jQuery"
              ];

for(s of subject) {
  frm.subject.options.add( new Option(s, s) );
}

// 모듈화
function Score(serial, id, subject, score) {
  this.serial = serial;
  this.id = id;
  this.subject = subject;
  this.score = score;

  this.output = function() {
    let str = `
              <div class="item" onclick="View('${this.serial}')">
                <span class="serial">${this.serial}</span>
                <span class="serial">${this.id}</span>
                <span class="serial">${this.subject}</span>
                <span class="serial">${this.score}</span>
              </div>
              `;
    return str;
  }
}


// 조회
function View(serial) {
  gIndex = serial

  frm.serial.value = list[gIndex].serial;
  frm.id.value = list[gIndex].id;
  frm.subject.value = list[gIndex].subject;
  frm.score.value = list[gIndex].score;
}

// 저장
frm.btnSave.onclick = function() {
  let serial = Number(frm.serial.value);
  let id = frm.id.value;
  let subject = frm.subject.value;
  let score = Number(frm.score.value);
  let d = new Score(serial, id, subject, score);

  list.push(d);  // 배열 list에 데이터 저장
}

// 검색


// 수정
frm.btnUpdate.onclick = function() {
  let _serial = gIndex;
}

// 삭제


// 성적현황 LIST 최신화
function Refresh() {
  let items = document.querySelector(".items");
  
  items.innerHTML = "";
  for(d of list) {
    items.innerHTML += d.output();
  }
}

// 하단 상태창 5초 후 초기화
function resetFooter() {
  setTimeout(count, 1);
  function count() {
    ft.innerHTML += " ( 5초 후 사라집니다. )";
  }

  setTimeout(countEnd, 5000);
  function countEnd() {
    ft.innerHTML = "성공기원";
  }
}