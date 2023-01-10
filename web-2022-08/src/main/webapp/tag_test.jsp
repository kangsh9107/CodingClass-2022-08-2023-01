<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 소스 다운 -->
<script src="https://unpkg.com/@yaireo/tagify"></script>
<!-- 폴리필 (구버젼 브라우저 지원) -->
<script src="https://unpkg.com/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
<link href="https://unpkg.com/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />
 
<!-- 해시 태그 정보를 저장할 input 태그. (textarea도 지원) -->
<input name='basic'>
 
<script>
    const input = document.querySelector('input[name=basic]');
    let tagify = new Tagify(input); // initialize Tagify
    
    // 태그가 추가되면 이벤트 발생
    tagify.on('add', function() {
      console.log(tagify.value); // 입력된 태그 정보 객체
    })
</script>
</body>
</html>