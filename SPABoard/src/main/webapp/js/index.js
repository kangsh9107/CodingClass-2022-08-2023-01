/**
 * index.jsp
 */

//immediately. 즉시실행.
(spa = function() {
	//게시판 링크를 클릭한 경우
	$('.board').on('click', function(ev){
		$('#content').load('board/board_main.jsp?job=select');
	});
})()

/*
!function() {
	alert("hi");
}();
*/

/*let current = 0;
const Counter = (function counterIIFE() {
	current++;
	if(current<10) {
		counterIIFE();
		console.log("ok");
	}
    return {
        getCurrentValue: function () {
            return current;
        },
        increaseValue: function () {
            current = current + 1;
            return current;
        },
        decreaseValue: function () {
            current = current - 1;
            return current;
        },
    };
})();*/
/*console.log(Counter.getCurrentValue()); // 0
console.log(Counter.increaseValue());   // 1
console.log(Counter.decreaseValue());   // -1*/

/*let test = function Func() {
	console.log("테스트")
}
test();
Func();*/

/*function test(){
	console.log("테스트")
}
console.log(test);*/
/*test();*/