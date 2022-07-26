
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %> <!-- 원래있는 세션 무효화 시키는 코드 -->
<html>
<head>
	<title>Home</title>
	
	<style>#tb{margin:auto; width: 700px;}</style>
	
	
</head>
<body>


	<c:import url="common/menubar.jsp"></c:import>
	
	<script>
		$(function(){
			var msg = '${msg}';
			if(msg != ''){
				alert(msg);
<%-- 				<% System.out.println("테스트"); session.removeAttribute("msg"); %> --%>
				location.href="home.do";
			}
		});
	</script>


	<h1 align="center"> 게시글 TOP5 목록 </h1>
	<table id="tb" border	="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>첨부파일</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	
	<script>
		function topList(){
			$.ajax({
				url:'topList.bo',
				success: function(data) {
					console.log(data);
					
					$tableBody = $('#tb tbody');
					$tableBody.html('');
					for(var i in data){
						var $tr = $('<tr>');
						var $bId = $('<td>').text(data[i].boardId);
						var $bTitle = $('<td>').text(data[i].boardTitle);
						var $bWriter = $('<td>').text(data[i].nickName);
						var $bDate = $('<td>').text(data[i].boardModifyDate);
						var $bCount = $('<td>').text(data[i].boardCount);
						var $bFile = $('<td>').text('');
						
						if(data[i].originalFileName != null){
							$bFile = $('<td>').text('◎');
						}
						
						$tr.append($bId);
						$tr.append($bTitle);
						$tr.append($bWriter);
						$tr.append($bDate);
						$tr.append($bCount);
						$tr.append($bFile);
						$tableBody.append($tr);
					}
				},
				error: function(data) {
					console.log(data);
				}	
			});
			
		}
		
		/* 실시간 적용되는 것처럼 보이기 위해 interval 5초 세팅 */
		$(function(){
			topList();
			
			setInterval(function(){
				topList();
			}, 5000);
		});
	</script>
	

</body>
</html>
