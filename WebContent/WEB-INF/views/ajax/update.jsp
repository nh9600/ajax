<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3>게시물 수정</h3>
		<table class="table table-bordered">
			<tr>
				<th>게시물 번호</th>
				<td>${param.biNum}</td>
			<tr>
				<th>제목</th>
				<td><input type="text" id="biTitle" placeholder="제목을 입력해주세요."></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea id="biContent" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="uiNum"></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="update()">저장</button></th>
			</tr>
		</table>
	</div>
	<script>
	function update(){
		
		
	}
	function ajax(conf) {
		var xhr = new XMLHttpRequest();//메모리로 생성해서 걔가 가지고 있는 것을 xhr에 대입 
		xhr.open(conf.method, conf.url);
		if(conf.method!='GET'){//get아닐때
			xhr.setRequestHeader('Content-Type','application/json');
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					conf.callback(xhr.responseText);//json형태의 스트링
				}
			}
		}
		//POST일때
		var param = (conf.param)?conf.param:'';//null(값이없을때) = false 는 '', true면 conf.param
		xhr.send(param);
	}//어차피 오버라이딩되니까 여기값은 신경 안씀
	
		var conf = {
			method : 'GET',
			url : '/ajax/board/view?cmd=view&biNum=${param.biNum}',//보드컨트롤러
			callback : function(res) {
				var board = JSON.parse(res);//자바스크립트가 알게끔 parse(객체로 바꿔줌)
				var inputs = document.querySelectorAll('[id]');//selector: 속성중에 id가 0번째인 애를 가져와, #이 붙으면 biTitle을 가져옴
				for ( var idx in inputs) {//id라는 속성값만 리스트에 넣음(0번째,1번째,2번째)
					var input = inputs[idx];//input에 0번째 방부터 집어 넣음 
					//console.log(input.id);//id 0번째 방에 있는 것
					if (input.id) {
						input.value = board[input.id];//board안에 있는 id값을 밸류에 집어 넣음
					}
				}

			}
		}
		ajax(conf);
	</script>
</body>
</html>