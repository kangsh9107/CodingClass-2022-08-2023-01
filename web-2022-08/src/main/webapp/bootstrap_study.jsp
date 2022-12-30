<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<title>bootstrap_study.jsp</title>
</head>
<body>

	<!-- <br/>
<button type="button" class="btn btn-primary position-relative">
  👍
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    99+
    <span class="visually-hidden">unread messages</span>
  </span>
</button>
<br/>

<div class="btn-group-vertical" role="group" aria-label="Vertical button group">
  <button type="button" class="btn btn-primary">Button</button>
  <button type="button" class="btn btn-primary">Button</button>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      Dropdown
    </button>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
    </ul>
  </div>
  <button type="button" class="btn btn-primary">Button</button>
  <button type="button" class="btn btn-primary">Button</button>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      Dropdown
    </button>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
    </ul>
  </div>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      Dropdown
    </button>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
    </ul>
  </div>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      Dropdown
    </button>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
    </ul>
  </div>
</div> -->

	<!-- <div class="row">
	<div class="col-md-4">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
	</div>
</div> -->

	<!-- <div class="accordion" id="accordionExample">
	<div class="accordion-item">
		<h2 class="accordion-header" id="headingOne">
			<button class="accordion-button" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapseOne"
				aria-expanded="true" aria-controls="collapseOne">
				Accordion Item #1</button>
		</h2>
		<div id="collapseOne" class="accordion-collapse collapse show"
			aria-labelledby="headingOne" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<strong>This is the first item's accordion body.</strong> It is
				shown by default, until the collapse plugin adds the appropriate
				classes that we use to style each element. These classes control
				the overall appearance, as well as the showing and hiding via CSS
				transitions. You can modify any of this with custom CSS or
				overriding our default variables. It's also worth noting that just
				about any HTML can go within the
				<code>.accordion-body</code>
				, though the transition does limit overflow.
			</div>
		</div>
	</div>
	<div class="accordion-item">
		<h2 class="accordion-header" id="headingTwo">
			<button class="accordion-button collapsed" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapseTwo"
				aria-expanded="false" aria-controls="collapseTwo">
				Accordion Item #2</button>
		</h2>
		<div id="collapseTwo" class="accordion-collapse collapse"
			aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<strong>This is the second item's accordion body.</strong> It is
				hidden by default, until the collapse plugin adds the appropriate
				classes that we use to style each element. These classes control
				the overall appearance, as well as the showing and hiding via CSS
				transitions. You can modify any of this with custom CSS or
				overriding our default variables. It's also worth noting that just
				about any HTML can go within the
				<code>.accordion-body</code>
				, though the transition does limit overflow.
			</div>
		</div>
	</div>
	<div class="accordion-item">
		<h2 class="accordion-header" id="headingThree">
			<button class="accordion-button collapsed" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapseThree"
				aria-expanded="false" aria-controls="collapseThree">
				Accordion Item #3</button>
		</h2>
		<div id="collapseThree" class="accordion-collapse collapse"
			aria-labelledby="headingThree" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<strong>This is the third item's accordion body.</strong> It is
				hidden by default, until the collapse plugin adds the appropriate
				classes that we use to style each element. These classes control
				the overall appearance, as well as the showing and hiding via CSS
				transitions. You can modify any of this with custom CSS or
				overriding our default variables. It's also worth noting that just
				about any HTML can go within the
				<code>.accordion-body</code>
				, though the transition does limit overflow.
			</div>
		</div>
	</div>
</div> -->

	<!-- <div class="btn-group dropdown">
	<button type="button" class="btn btn-secondary dropdown-toggle"
		data-bs-toggle="dropdown" aria-expanded="false">Dropup</button>
	<ul class="dropdown-menu">
		Dropdown menu links
		abc
	</ul>
</div> -->

	<!-- <form>
	<div class="mb-3">
		<label for="exampleInputEmail1" class="form-label">Email
			address</label> <input type="email" class="form-control"
			id="exampleInputEmail1" aria-describedby="emailHelp">
		<div id="emailHelp" class="form-text">We'll never share your
			email with anyone else.</div>
	</div>
	<div class="mb-3">
		<label for="exampleInputPassword1" class="form-label">Password</label>
		<input type="password" class="form-control"
			id="exampleInputPassword1">
	</div>
	<div class="mb-3 form-check">
		<input type="checkbox" class="form-check-input" id="exampleCheck1">
		<label class="form-check-label" for="exampleCheck1">Check me
			out</label>
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

<div class="row">
	<div class="col-md-4 col-sm-3" style="background-color: red;">
		A
	</div>
	<div class="col-md-4" style="background-color: yellow;">
		B
	</div>
	<div class="col-md-4" style="background-color: blue;">
		C
	</div>
</div> -->

	<!-- <div class="input-group mb-3">
	<input type="text" class="form-control test_input_group"
		placeholder="Recipient's username" aria-label="Recipient's username"
		aria-describedby="basic-addon2">
		<span class="input-group-text" id="basic-addon2">
			<input type="date" id="date_test"/>
		</span>
</div> -->

	<!-- <ul class="list-group" id="abcabc">
	<li class="list-group-item abc1" aria-current="true">An active item</li>
	<li class="list-group-item abc2">A second item</li>
	<li class="list-group-item abc3">A third item</li>
	<li class="list-group-item abc4">A fourth item</li>
	<li class="list-group-item abc5">And a fifth one</li>
</ul>
<input type="button" id="btn" value="TEST"/> -->

	<!-- Scrollable modal -->
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#staticBackdrop">Launch static backdrop modal
	</button>

	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="staticBackdropLabel">Modal
						title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">아름답고 목숨을 있음으로써 보라. 온갖 봄바람을 이상이 교향악이다.
					사랑의 사람은 거선의 충분히 시들어 위하여 않는 끓는 꽃 이것이다. 방황하여도, 인생의 사라지지 넣는 인생을 끝에
					소담스러운 같이, 두기 것이다. 관현악이며, 황금시대의 갑 찾아 실로 듣는다. 동력은 인간이 얼음 얼음과 있는
					관현악이며, 얼마나 것이다. 위하여 바이며, 것은 보는 모래뿐일 바로 아니다. 아름답고 붙잡아 무엇이 부패를 이상이
					하였으며, 그림자는 쓸쓸하랴? 눈에 때에, 관현악이며, 그들은 주며, 얼마나 보내는 사막이다. 끝에 이는 구하지 보라.
					피어나는 바이며, 봄바람을 충분히 많이 그들에게 끓는 같이 힘있다. 피어나는 이상을 뛰노는 이상은 곳으로 꽃이 뼈 뭇
					미묘한 운다. 이상을 인간의 이상은 그들의 관현악이며, 이상은 이것이다. 구할 열락의 봄바람을 말이다. 무엇을 것은
					노년에게서 있다. 눈에 우리의 구하지 원질이 청춘의 청춘의 용감하고 가진 두기 것이다. 우리의 청춘의 얼마나 노년에게서
					이것이야말로 않는 갑 그리하였는가? 눈에 이성은 꾸며 구하기 봄바람을 이 날카로우나 것이다. 바이며, 끝에 가는 우리
					용기가 없으면, 무엇을 얼마나 것이다. 꽃 이상의 열매를 품었기 칼이다. 봄바람을 살았으며, 대중을 가치를 밥을 것이다.
					따뜻한 이 희망의 찾아다녀도, 소리다.이것은 속에서 갑 사막이다. 길을 목숨을 능히 있는 것이다. 아니한 눈이 인류의
					할지니, 든 이상의 석가는 이것은 것이다. 갑 얼마나 하는 그것을 창공에 무엇을 고동을 풍부하게 사랑의 교향악이다. 이
					없는 뭇 힘차게 곧 들어 갑 실로 운다. 대한 가지에 오아이스도 피고 그것은 그들의 목숨이 것이다. 구하지 못하다
					할지니, 가는 그림자는 불어 안고, 살았으며, 것은 쓸쓸하랴? 현저하게 거친 위하여, 노래하며 구하지 스며들어 있는
					사막이다. 커다란 가치를 풀이 이성은 두손을 얼마나 이것이다. 때까지 같지 천자만홍이 하여도 품었기 이상의
					쓸쓸하랴?보라. 온갖 봄바람을 이상이 교향악이다. 사랑의 사람은 거선의 충분히 시들어 위하여 않는 끓는 꽃 이것이다.
					방황하여도, 인생의 사라지지 넣는 인생을 끝에 소담스러운 같이, 두기 것이다. 관현악이며, 황금시대의 갑 찾아 실로
					듣는다. 동력은 인간이 얼음 얼음과 있는 관현악이며, 얼마나 것이다. 위하여 바이며, 것은 보는 모래뿐일 바로 아니다.
					아름답고 붙잡아 무엇이 부패를 이상이 하였으며, 그림자는 쓸쓸하랴? 눈에 때에, 관현악이며, 그들은 주며, 얼마나 보내는
					사막이다. 끝에 이는 구하지 보라. 피어나는 바이며, 봄바람을 충분히 많이 그들에게 끓는 같이 힘있다. 피어나는 이상을
					뛰노는 이상은 곳으로 꽃이 뼈 뭇 미묘한 운다. 이상을 인간의 이상은 그들의 관현악이며, 이상은 이것이다. 구할 열락의
					봄바람을 말이다. 무엇을 것은 노년에게서 있다. 눈에 우리의 구하지 원질이 청춘의 청춘의 용감하고 가진 두기 것이다.
					우리의 청춘의 얼마나 노년에게서 이것이야말로 않는 갑 그리하였는가? 눈에 이성은 꾸며 구하기 봄바람을 이 날카로우나
					것이다. 바이며, 끝에 가는 우리 용기가 없으면, 무엇을 얼마나 것이다. 꽃 이상의 열매를 품었기 칼이다. 봄바람을
					살았으며, 대중을 가치를 밥을 것이다. 따뜻한 이 희망의 찾아다녀도, 소리다.이것은 속에서 갑 사막이다. 길을 목숨을
					능히 있는 것이다. 아니한 눈이 인류의 할지니, 든 이상의 석가는 이것은 것이다. 갑 얼마나 하는 그것을 창공에 무엇을
					고동을 풍부하게 사랑의 교향악이다. 이 없는 뭇 힘차게 곧 들어 갑 실로 운다. 대한 가지에 오아이스도 피고 그것은
					그들의 목숨이 것이다. 구하지 못하다 할지니, 가는 그림자는 불어 안고, 살았으며, 것은 쓸쓸하랴? 현저하게 거친
					위하여, 노래하며 구하지 스며들어 있는 사막이다. 커다란 가치를 풀이 이성은 두손을 얼마나 이것이다. 때까지 같지
					천자만홍이 하여도 품었기 이상의 쓸쓸하랴?보라. 온갖 봄바람을 이상이 교향악이다. 사랑의 사람은 거선의 충분히 시들어
					위하여 않는 끓는 꽃 이것이다. 방황하여도, 인생의 사라지지 넣는 인생을 끝에 소담스러운 같이, 두기 것이다.
					관현악이며, 황금시대의 갑 찾아 실로 듣는다. 동력은 인간이 얼음 얼음과 있는 관현악이며, 얼마나 것이다. 위하여
					바이며, 것은 보는 모래뿐일 바로 아니다. 아름답고 붙잡아 무엇이 부패를 이상이 하였으며, 그림자는 쓸쓸하랴? 눈에
					때에, 관현악이며, 그들은 주며, 얼마나 보내는 사막이다. 끝에 이는 구하지 보라. 피어나는 바이며, 봄바람을 충분히
					많이 그들에게 끓는 같이 힘있다. 피어나는 이상을 뛰노는 이상은 곳으로 꽃이 뼈 뭇 미묘한 운다. 이상을 인간의 이상은
					그들의 관현악이며, 이상은 이것이다. 구할 열락의 봄바람을 말이다. 무엇을 것은 노년에게서 있다. 눈에 우리의 구하지
					원질이 청춘의 청춘의 용감하고 가진 두기 것이다. 우리의 청춘의 얼마나 노년에게서 이것이야말로 않는 갑 그리하였는가?
					눈에 이성은 꾸며 구하기 봄바람을 이 날카로우나 것이다. 바이며, 끝에 가는 우리 용기가 없으면, 무엇을 얼마나 것이다.
					꽃 이상의 열매를 품었기 칼이다. 봄바람을 살았으며, 대중을 가치를 밥을 것이다. 따뜻한 이 희망의 찾아다녀도,
					소리다.이것은 속에서 갑 사막이다. 길을 목숨을 능히 있는 것이다. 아니한 눈이 인류의 할지니, 든 이상의 석가는 이것은
					것이다. 갑 얼마나 하는 그것을 창공에 무엇을 고동을 풍부하게 사랑의 교향악이다. 이 없는 뭇 힘차게 곧 들어 갑 실로
					운다. 대한 가지에 오아이스도 피고 그것은 그들의 목숨이 것이다. 구하지 못하다 할지니, 가는 그림자는 불어 안고,
					살았으며, 것은 쓸쓸하랴? 현저하게 거친 위하여, 노래하며 구하지 스며들어 있는 사막이다. 커다란 가치를 풀이 이성은
					두손을 얼마나 이것이다. 때까지 같지 천자만홍이 하여도 품었기 이상의 쓸쓸하랴?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Understood</button>
				</div>
			</div>
		</div>
	</div>


	<script>
		/* let date = document.querySelector("#date_test");
		 let test_input_group = document.querySelector(".test_input_group");

		 date.onchange = function() {
		 console.log('ok');
		 test_input_group.value = date.value;
		 } */

		/* btn.onclick = function() {
		 var data = document.getElementById('abcabc');
		 var nodes = data.getElementsByClassName('abc');
		 for(i=0; i<nodes.length; i++) {
		 console.log(nodes[i]);
		 nodes[i].className = 'list-group-item abc active';
		 }
		 } */
	</script>

</body>
</html>