<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<title>pay_test.jsp</title>
</head>
<body>

<input type="button" value="결제하기" onclick="requestPay()"/>

<script>
var IMP = window.IMP;
IMP.init("imp68151717");

function requestPay() {
	//IMP.request_pay(param, callback) 결제창 호출
	IMP.request_pay({ //param
		pg: "html5_inicis.MID-a",
		pay_method: "card",
		merchant_uid: "merchant_" + new Date().getTime(),
		name: "결제 테스트",
		amount: 100,
		buyer_email: "gildong@gmail.com",
		buyer_name: "홍길동",
		buyer_tel: "010-1111-1111",
		buyer_addr: "서울특별시 관악구 봉천동",
		buyer_postcode: "11111"
	}, function(rsp) { //callback
		if(rsp.success) { //결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
			//jQuery로 HTTP 요청
			jQuery.ajax({
				url: "http://localhost:8888/web-2022-08/pay_test.jsp", //서버의 결제 정보를 받는 endpoint. 예: https://www.myservice.com/payments/complete
				method: "POST",
				headers: {"Content-Type": "application/json"},
				data: {imp_uid: rsp.imp_uid, merchant_uid: rsp.merchant_uid}
			}).done(function(data) {
				//가맹점 서버 결제 API 성공 시 로직
				alert("결제 성공.");
				//location.href = "http://localhost:8888/web-2022-08/pay_test.jsp"
			});
		} else {
			alert("결제 실패. 에러 내용: " + rsp.error_msg);
		}
	});
}
</script>

</body>
</html>