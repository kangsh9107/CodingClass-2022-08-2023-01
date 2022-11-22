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

