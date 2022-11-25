const btnText = document.querySelector("#btnLoadText");
const btnHtml = document.querySelector("#btnLoadHtml");
const btnJsp = document.querySelector("#btnLoadJsp");
const btnJson = document.querySelector("#btnLoadJson");
const divText = document.querySelector("#text");
const divHtml = document.querySelector("#html");
const divJsp = document.querySelector("#jsp");
const divJson = document.querySelector("#json");

btnText.addEventListener("click", function() {
	let xhr = new XMLHttpRequest(); // 1) 객체 생성
	xhr.open("get", "data.txt");    // 2) 객체 초기화
	xhr.onreadystatechange = function() { // 3) 이벤트 핸들러 작성
		// 5) 정상적으로 요청했고, 모든 응답정보를 수신 받았을 때
		if(xhr.status == 200 && xhr.readyState == 4) {
			divText.innerHTML = xhr.responseText;
		}
	}
	xhr.send();                     // 4) 서버에게 요청처리
});

btnHtml.addEventListener("click", function() {
	
	// jQuery 사용 시 한 줄로 가능하다.
	// $(divHtml).load("data.html");
	
	let xhr = new XMLHttpRequest();
	xhr.open("get", "data.html");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			divHtml.innerHTML = xhr.responseText;
		}
	}
	xhr.send();
});

btnJsp.addEventListener("click", function() {
	let xhr = new XMLHttpRequest();
	xhr.open("get", "data.jsp?dan=5");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			divJsp.innerHTML = xhr.responseText;
		}
	}
	xhr.send();
});

btnJson.addEventListener("click", function() {
	let xhr = new XMLHttpRequest();
	xhr.open("get", "data_json.jsp");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			let data = xhr.responseText;
			let json = JSON.parse(data);
			let html = "<ul>"
					 + "<li>id: " + json.id + "</li>"
					 + "<li>name: " + json.name + "</li>"
					 + "<li>phone: " + json.phone + "</li>"
					 + "</ul>";
			divJson.innerHTML = html;
		}
	}
	xhr.send();
});

/* 학생정보 조회 */
const btnStudent = document.querySelector("#btnStudent");
const frm = document.querySelector("#frm");
const list = document.querySelector("#list");

std = function() { // std(); 보다 밑에 있어도 펑션으로 작성하면 호이스팅되서 상관없다.
                   // 단, 메모리를 아끼기위해 정의만 하고 호이스팅 되지 않게 작성했다.
	const btnSearch = document.querySelector("#btnSearch");
	btnSearch.addEventListener("click", function() {
		let xhr = new XMLHttpRequest();
		let findStr = document.frm.findStr.value;
		xhr.open("get", "student_list.jsp?findStr=" + findStr);
		xhr.onreadystatechange = function() {
			if(xhr.status == 200 && xhr.readyState == 4) {
				//list.innerHTML = xhr.responseText;
				
				let jsonArray = JSON.parse(xhr.responseText);
				let html = "";
				for(obj of jsonArray) {
					html += `<div>
								<span>${obj.id}</span>
								<span>${obj.name}</span>
								<span>${obj.phone}</span>
								<span>${obj.address}</span>
							 </div>
					`;
				}
				list.innerHTML = html;
			}
		}
		xhr.send();
	});
}

btnStudent.addEventListener("click", function() {
	let xhr = new XMLHttpRequest();
	xhr.open("get", "student_form.html");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			frm.innerHTML = xhr.responseText;
			std(); // student_form.html이 실행된 후 (form태그가 출력된 후) 객체만들어서 스크립트 처리하게 하는 펑션
		}
	}
	xhr.send();
});

/* 직원정보 조회 */
const btnEmployee = document.querySelector("#btnEmployee");
const frm_employee = document.querySelector("#frm_employee");
const employee_list = document.querySelector("#employee_list");

emp = function() {
	const btnSearch2 = document.querySelector("#btnSearch2");
	btnSearch2.addEventListener("click", function() {
		let xhr = new XMLHttpRequest();
		let findStr2 = document.frm2.findStr2.value;
		xhr.open("get", "emp_list.jsp?findStr2=" + findStr2);
		xhr.onreadystatechange = function() {
			if(xhr.status == 200 && xhr.readyState == 4) {
				//employee_list.innerHTML = xhr.responseText;
				let jsonArray = JSON.parse(xhr.responseText);
				let html = "";
				for(obj of jsonArray) {
					html += `
						<div>
							<span style="border: 1px solid gray;">사번 : ${obj.employeeNumber}</span>
							<span style="border: 1px solid gray;">사원명 : ${obj.lastName}</span>
							<span style="border: 1px solid gray;">사무실 연락처 : ${obj.phone}</span>
							<span style="border: 1px solid gray;">이메일 : ${obj.email}</span>
						</div>
					`;
				}
				employee_list.innerHTML = html;
			}
		}
		xhr.send();
	});
}

btnEmployee.addEventListener("click", function() {
	let xhr = new XMLHttpRequest();
	xhr.open("get", "emp_form.html");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			frm_employee.innerHTML = xhr.responseText;
			emp();
		}
	}
	xhr.send();
});

/* ajax로 삽입한 jsp파일에 js 연결 테스트 */
let btnTest2 = document.querySelector("#btnTest2");

btnTest2.onclick = function() {
	let xhr = new XMLHttpRequest();
	xhr.open("get", "test.html");
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			frm.innerHTML = xhr.responseText;
		}
	}
	xhr.send();
}

/* 2022-11-25 노드 동적 추가&삭제 */
const btnInsert = document.querySelector("#btnInsert");

// 노드 동적 추가
let cnt = 0;
btnInsert.addEventListener("click", function() {
	let appendZone = document.querySelector("#appendZone");
	cnt++
	
	let div = document.createElement("div");
	div.style.backgroundColor = "#ddd";
	div.style.padding = "3px";
	div.style.marginBottom = "2px";
	
	let txt = document.createElement("input");
	txt.setAttribute("type", "text");
	txt.setAttribute("value", "하이" + cnt);
	div.appendChild(txt);
	
	let btn = document.createElement("input");
	btn.setAttribute("type", "button");
	// 노드 동적 하나 삭제
	btn.setAttribute("value", "삭제" + cnt);
	div.addEventListener("click", function(ev){
		let tag = ev.srcElement;
		let parent = tag.parentNode;
		appendZone.removeChild(parent);
	});
	div.appendChild(btn);
	
	appendZone.appendChild(div);
});

// 노드 동적 전체 삭제
const btnDelete = document.querySelector("#btnDelete");

btnDelete.addEventListener("click", function() {
	let appendZone = document.querySelector("#appendZone");
	appendZone.innerHTML = "";
	cnt = 0;
});

/* select 박스 */
const city = document.querySelector("#city");
const theater = document.querySelector("#theater");
const movie = document.querySelector("#movie");

city.onchange = function() {
	let cityName = city.value;
	
	let xhr = new XMLHttpRequest();
	xhr.open("get", "theater.jsp?city=" + cityName);
	xhr.send();
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			theater.innerHTML = "";
			//theater.length = 0;
			let data = xhr.responseText;
			let json = JSON.parse(data);
			for(let i=0; i<json.length; i++) {
				let option = document.createElement("option");
				option.setAttribute("value", json[i]);
				option.innerHTML = json[i];
				option.style.width = "90px";
				theater.appendChild(option);
			}
		}
	}
}

theater.onchange = function() {
	let theaterName = theater.value;
	
	let xhr = new XMLHttpRequest();
	xhr.open("get", "movie.jsp?theater=" + theaterName);
	xhr.send();
	xhr.onreadystatechange = function() {
		if(xhr.status == 200 && xhr.readyState == 4) {
			movie.innerHTML = "";
			let data = xhr.responseText;
			let json = JSON.parse(data);
			for(let i=0; i<json.length; i++) {
				let option = document.createElement("option");
				option.setAttribute("value", json[i]);
				option.innerHTML = json[i];
				option.style.width = "170px";
				movie.appendChild(option);
			}
		}
	}
}





