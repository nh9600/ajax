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
		<table class="table table-bordered" id="tBody">
		</table>

			<colspan="2">
				<button onclick="goPage('/ajax/update?biNum=${param.biNum}')">수정</button>
				<button onclick="goPage('/ajax/delete?biNum=${param.biNum}')">삭제</button>

	</div>
	<script>
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/ajax/board/view?cmd=view&biNum=${param.biNum}');//
			xhr.onreadystatechange = function() {//레디스테이트가 변경될때마다 
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var list = JSON.parse(xhr.responseText);
						var tBody = document.getElementById('tBody');
						var html = '';
						html += '<tr>';
						html += '<th>번호</th>';
						html += '<td>' + list.biNum + '</td>';
						html += '</tr><tr>';
						html += '<th>제목</th>';
						html += '<td>' + list.biTitle + '</td>';
						html += '</tr><tr>';
						html += '<th>내용</th>';
						html += '<td>' + list.biContent + '</td>';
						html += '</tr><tr>';
						html += '<th>작성자</th>';
						html += '<td>' + list.uiNum + '</td>';
						html += '</tr><tr>';
						html += '<th>작성일</th>';
						html += '<td>' + list.credat + '</td>';
						html += '</tr><tr>';
						html += '<th>작성시간</th>';
						html += '<td>' + list.cretim + '</td>';
						html += '</tr>';

						tBody.innerHTML = html;
					}
				}
			}
			xhr.send();//이 형태의 스트링
		}
	</script>
</body>
</html>