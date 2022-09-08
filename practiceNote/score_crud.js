let list = []; // 전체 데이터 저장

function Score(serial, id, subject, score){
  this.serial = serial;
  this.id = id;
  this.subject = subject;
  this.score = score;
  this.output = function(){
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

let frm = document.frm;
let ft = document.querySelector("#footer");    // 하단 상태 출력창

let subject = ["HTML" , "CSS"   , "JavaScript",
               "Java" , "python", "Spring"    ,
               "MySQL", "jQuery"
];

// select option에 배열 subject의 value값 넣기.
for(s of subject){
  frm.subject.options.add( new Option(s, s) ); // new Option()은 select에 옵션을 추가하는 내장객체.
}

// 조회
function View(serial){
  let index = list.findIndex( v=>v.serial==serial );

  frm.serial.value = list[index].serial;
  frm.id.value = list[index].id;
  frm.subject.value = list[index].subject;
  frm.score.value = list[index].score;
}

// 저장
frm.btnSave.onclick = function(){
  let serial = Number(frm.serial.value);
  let id = frm.id.value;
  let subject = frm.subject.value;
  let score = Number(frm.score.value);
  let d = new Score(serial, id, subject, score);
  
  let index = list.findIndex( v=>v.serial==frm.serial.value );
  
  if(serial<0 || Number.isInteger(serial)==false || serial==''){
    ft.innerHTML = "SERIAL에 양의 정수를 입력 해주세요.";
    frm.serial.focus();
    resetFooter(); // 하단 상태 출력창 5초 후 초기화
    return;
  }else if(id==''){
    ft.innerHTML = "학번을 입력 해주세요."; // 특수문자, 영어 대소문자, 숫자 등 입력을 제한하려면 정규식 필요.
    frm.id.focus();
    resetFooter();
    return;
  }else if(score<0 || Number.isInteger(score)==false || score==''){
    ft.innerHTML = "성적에 양의 정수를 입력해 주세요.";
    frm.score.focus();
    resetFooter();
    return;
  }else if(index>=0){
    ft.innerHTML = "SERIAL이 중복되었습니다.";
    frm.serial.focus();
    resetFooter();
    return;
  }else{
    list.push(d);
    ft.innerHTML = "데이터를 저장 했습니다.";
    resetFooter();
  }
  
  Refresh();
}

// 검색
frm.findSerial.onclick = function(){
  let serial = frm.serial.value;
  let index = list.findIndex( v=>v.serial==frm.serial.value );
  
  if(serial==''){
    ft.innerHTML = "검색할 SERIAL을 입력 해주세요.";
    frm.serial.focus();
    resetFooter();
    return;
  }else if(index==-1){
    ft.innerHTML = "검색한 SERIAL이 저장되어 있지 않습니다.";
    frm.serial.focus();
    resetFooter();
    return;
  }else{
    frm.id.value = list[index].id;
    frm.subject.value = list[index].subject;
    frm.score.value = list[index].score;
    ft.innerHTML = "검색한 SERIAL의 데이터를 가져 왔습니다.";
    resetFooter();
  }
}

// 수정
frm.btnUpdate.onclick = function(){
  let serial = Number(frm.serial.value);
  let id = frm.id.value;
  let subject = frm.subject.value;
  let score = Number(frm.score.value);
  let index = list.findIndex( v=>v.serial==frm.serial.value );
  
  if(serial<0 || Number.isInteger(serial)==false || serial==''){
    ft.innerHTML = "SERIAL에 양의 정수를 입력 해주세요.";
    frm.serial.focus();
    resetFooter();
    return;
  }else if(id==''){
    ft.innerHTML = "학번을 입력 해주세요.";
    frm.id.focus();
    resetFooter();
    return;
  }else if(score<0 || Number.isInteger(score)==false || score==''){
    ft.innerHTML = "성적에 양의 정수를 입력해 주세요.";
    frm.score.focus();
    resetFooter();
    return;
  }else if(index>=0){
    list[index].id = frm.id.value;
    list[index].subject = frm.subject.value;
    list[index].score = frm.score.value;
    ft.innerHTML = "데이터가 수정되었습니다.";
    resetFooter();
  }else{
    ft.innerHTML = "수정할 데이터가 없습니다.";
    resetFooter();
  }
  
  Refresh();
}

// 삭제
frm.btnDelete.onclick = function(){
  let serial = frm.serial.value;
  let index = list.findIndex( v=>v.serial==frm.serial.value );
  
  if(index>=0){
    list.splice(index, 1);
    frm.serial.value='';
    frm.id.value='';
    frm.subject.value='';
    frm.score.value='';
    ft.innerHTML = "선택한 데이터가 삭제 되었습니다.";
    resetFooter();
  }else{
    ft.innerHTML = "삭제할 데이터를 찾지 못했습니다.";
    resetFooter();
  }
  
  Refresh();
}

// 새로고침
// 저장, 수정, 삭제 버튼을 눌렀을 때, 화면에 바로 반영 된다면
// 출력 버튼에는 화면을 최신화 해서 출력하는 기능 외에도 부가적인 기능이 있어야 좋을 것 같다.
function Refresh(){
  let items = document.querySelector(".items");
  
  items.innerHTML = "";
  for(d of list){
    items.innerHTML += d.output();
  }
}

// 하단 상태 출력창 5초 후 초기화
function resetFooter(){
  setTimeout(count, 1);
  function count(){
    ft.innerHTML += " ( 5초 후 사라집니다. )";
  }
  setTimeout(countEnd, 5000);
  function countEnd(){
    ft.innerHTML = "성공기원";
  }
}