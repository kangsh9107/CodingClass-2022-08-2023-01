/**
 * 
 */

function func(frm) {
	let s = Number(frm.start.value);
	let e = Number(frm.end.value);
	let i = s;
	while(i<=e){
		if(i%3!=0 && i%5!=0){
			console.log(i)
		}
		i++;
	}
}