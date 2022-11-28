$('#btnSearch3').on('click', function() {
	//let param = "findStr=" + $('#findStr3').val();
	//console.log("customer.jsp", param);
	$.post('customer_result.jsp?findStr3=' + $('#findStr3').val(), function(data) {
/* 		console.log(typeof data);
		for(d of data) {
			console.log("before", d.phone);
		}
		$('#customerList').html(JSON.stringify(data));
		for(d of data) {
			console.log("after", d.phone);
		}
		console.log(typeof data); */
		let temp = `
			<div>
				<div class="row">
					<span>customerNumber</span>
					<span>customerName</span>
					<span>phone</span>
					<span>addressLine1</span>
					<span>addressLine2</span>
				</div>
		`;
		//jsp에서는 `\${}`;
		//js에서는 `${}`;
 		for(d of data) {
			temp += `
				<div class="row">
					<span>${d.customerNumber}</span>
					<span>${d.customerName}</span>
					<span>${d.phone}</span>
					<span>${d.addressLine1}</span>
					<span>${d.addressLine2}</span>
				</div>
			`;
		}
 		temp += '</div>';
 		
 		$('#customerList').html(temp);
 		$('.row').css('display', 'table-row');
 		$('.row>span').css({
 			'display': 'table-cell',
 			'padding': '0 10px'
 		});
	}, 'json');
});