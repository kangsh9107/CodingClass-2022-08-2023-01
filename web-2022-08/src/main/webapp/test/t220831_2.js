/**
 * 
 */
let frm = document.frm;
let s = Number(frm.start.value);
let e = Number(frm.end.value);

frm.btn.onclick = function(start, end){
	this.s = start;
	this.e = end;
	let i = s;
	while(i<=e){
		if(i%3!=0 && i%5!=0){
			console.log(i)
		}
		i++;
	}
}