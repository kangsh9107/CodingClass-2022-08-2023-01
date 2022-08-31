/**
 * 
 */
let ary = [
	{'name' : 'hong1', 'id' : 'a001', 'phone' : '1234', 'email' : 'a001@abc.kr'},
	{'name' : 'hong2', 'id' : 'a002', 'phone' : '1235', 'email' : 'a002@abc.kr'},
	{'name' : 'hong3', 'id' : 'a003', 'phone' : '1236', 'email' : 'a003@abc.kr'},
	{'name' : 'hong4', 'id' : 'a004', 'phone' : '1237', 'email' : 'a004@abc.kr'}
];

let l = document.querySelector('.list');
let template = '';

for(index in ary){
	v = ary[index];
	template = 
		`
		<div class = 'list'>
			<span class = 'name'>${v.name}</span>
			<span class = 'id'>${v.id}</span>
			<span class = 'phone'>${v.phone}</span>
			<span class = 'email'>${v.email}</span>
		</div>
		`;
	l.innerHTML += template;
}