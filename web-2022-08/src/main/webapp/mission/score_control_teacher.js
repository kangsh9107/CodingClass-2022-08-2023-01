/**
 * 
 */
let data = [
	{'number' : '1', 'sub' : '국어', 'score' : '100'},
	{'number' : '1', 'sub' : '영어', 'score' : '90'},
	{'number' : '2', 'sub' : '역사', 'score' : '95'},
];
let template;
let index;
let frm = document.frm_score;

function List(){
	let list = document.querySelector('#list');
	
	for(v in data){
		template = 
			`
			<div class = 'item' onclick = 'view("${v}")'>
				<span class = 'number'>${data[v].number}</span>
				<span class = 'subject'>${data[v].subject}</span>
				<span class = 'score'>${data[v].score}</span>
			</div>
			`;
		list.innerHTML += template;
	}
}
List();
