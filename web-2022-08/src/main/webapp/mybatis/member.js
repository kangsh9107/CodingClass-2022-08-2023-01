$('#btnInsert').on('click', function() {
	var param = $('.frm').serialize();
	$.post('bean.jsp?job=insert', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnInsertR').on('click', function() {
	var frm = $('.frm')[0];
	var data = new FormData(frm);
	
	$.ajax({
		type        : 'POST',
		url         : '../mmfs.do?job=insert',
		data        : data,
		contentType : false,
		processData : false,
		success     : function(resp) {
			$('.contentInnerKang').html(resp);
		}
	});
});

$('#btnList').on('click', function() {
	var param = $('.frm').serialize();
	frm.enctype = '';
	$.post('bean.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnSearch').on('click', function() {
	var frm = $('.frm')[0];
	frm.nowPage.value = 1;
	
	var param = $(frm).serialize();
	$.post('bean.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnUpdate').on('click', function() {
	var frm = $('.frm')[0];
	var param = $(frm).serialize();
	$.post('bean.jsp?job=update', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

$('#btnUpdateR').on('click', function() {
	var frm = $('.frm')[0];
	frm.enctype = 'multipart/form-data';
	var data = new FormData(frm);
	
	$.ajax({
		type        : 'POST',
		url         : '../mmfs.do?job=update',
		data        : data,
		contentType : false,
		processData : false,
		success     : function(resp) {
			$('.contentInnerKang').html(resp);
		}
	});
});

$('#btnDeleteR').on('click', function() {
	var yn = confirm('정말 삭제 하십니까?');
	if( !yn ) return;
	
	var param = $('.frm').serialize();
	$.post('bean.jsp?job=delete', param, function(data) {
		$('.contentInnerKang').html(data);
	});
});

view = function(id) {
	var frm = $('.frm')[0];
	frm.id.value = id; //쓸모가 없을 줄 알았지만 굉장히 중요한 아이. 클릭한 id를 담아서 form 전송 시 보낼 수 있게 함.
	var param = $(frm).serialize();
	$.post('bean.jsp?job=view', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}

movePage = function(nowPage) {
	var frm = $('.frm')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	$.post('bean.jsp?job=select', param, function(data) {
		$('.contentInnerKang').html(data);
	});
}

/* member_update.jsp 이미지 미리보기 */
$('#photo').on('click', function() {
	$('#fileTest').click();
});


$('#fileTest').on('change', function(ev) {
	var file = ev.target.files[0];
	var reader = new FileReader();
	reader.onload = function(e) {
		$('#photo').attr('src', e.target.result);
	}
	reader.readAsDataURL(file);
});


/*
 * jqeury로 이벤트를 발생시키면 target과 srcElement의 차이가 있다
$('#fileTest').on('change', function(ev) {
	console.log("ok");
	console.log(ev.target.files[0]);
	console.log(ev.srcElement.files[0]);
	 var file = ev.srcElement.files[0];
	 var reader = new FileReader();
	 reader.readAsDataURL(file);
	 reader.onload = function(fev){
		 var tempImg = new Image();
		 //tempImg.src = this.result;
		 //photo.src = tempImg.src;
	 }
});
*/
