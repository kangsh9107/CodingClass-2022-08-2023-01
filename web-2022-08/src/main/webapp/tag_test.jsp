<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- CategoryProducts -->
<section class="py-5">
	<div class="container">
		<div class="row justify-content-center">
			<c:forEach items="${list }" var="v" varStatus="status">
				<div class="col-md-5">
					<div class="card h-100">
						<!-- Product image 450x300 -->
						<img class="card-img-top" src="img/${v.productName }.png" alt="${v.productName }.png"/>
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name -->
								<h5 class="fw-bolder">${v.productName }</h5>
								<!-- Product price -->
								₩ <fmt:formatNumber value="${v.price }" pattern="#,###"/>
							</div>
						</div>
						<!-- View -->
						<div class="card-footer p-2 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<button class="btn btn-outline-dark" onclick="showCategoryDetail(${pageVo.nowPage }, ${v.serial }, '${pageVo.category }')">View</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

</body>
</html>