<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3>내용</h3>
		<table class="table table-bordered">
		<tr>
			<th>번호</th>
		</tr>
		<tr>
			<th>제목</th>
		</tr>
		<tr>
			<th>내용</th>
		</tr>
		<tr>
			<th>작성자</th>
		</tr>
		<tr>
			<th>작성일</th>
		</tr>
		<tr>
			<th>작성시간</th>
		</tr>
			<tr>
				<th colspan="2"><button onclick="listdelete()">삭제</button></th>
			</tr>
			<tbody id="tBody">
			</tbody>
		</table>
	</div>
	<script>
	window.onload = function(){
				var xhr = new XMLHttpRequest();
				xhr.open('GET', '/ajax/board/view?biNum=${param.biNum}');//
				xhr.onreadystatechange = function() {//레디스테이트가 변경될때마다 
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							var list = JSON.parse(xhr.responseText);
							var tBody = document.getElementById('tBody');
							var html ='';
							for(var i=0;i<list.length;i++){
								html += '<tr>';
								html += '<td>' + list[i].biNum + '</td>';
								html += '<td>' + list[i].biTitle + '</td>';
								html += '<td>' + list[i].biContent + '</td>';
								html += '<td>' + list[i].uiNum + '</td>';
								html += '<td>' + list[i].credat + '</td>';
								html += '<td>' + list[i].cretim + '</td>';
								html += '</tr>';
							}
							tBody.innerHTML = html;
						}
					}
				}
				xhr.send();//이 형태의 스트링
		}
	</script>
</body>
</html>