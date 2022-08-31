/**
 * 
 */
let frm = document.frm;
function Chk(){
	let id = frm.id.value;
	let pwd = frm.pwd.value;
	let result = document.getElementById('result');
	let c = CheckLogin(id, pwd);
	result.innerHTML = c;
}
function CheckLogin(id, pwd){
	let r = 'fail';
	if(id=='kim' && pwd=='1111'){
		r = 'pass';
	}
	return r;
}
