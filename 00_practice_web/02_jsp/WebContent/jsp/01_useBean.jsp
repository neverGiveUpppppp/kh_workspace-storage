<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>객체값 통째로 찍기</p>
	
	<jsp:useBean id="put_varName_n_ref" class="action.model.vo.Person" ></jsp:useBean>
	객체값 통째로 찍기 : <%= put_varName_n_ref %>
	 
	<br>
	<!-- 안에 있는 값을 가져올 것임  -->
	<!-- get역할을 하는 jsp:getProperty 사용  -->
	이름 : <jsp:getProperty property="name" name="put_varName_n_ref"/><br> <%-- <% person1.getName %> --%> <!-- person1이 레퍼런스가 되는 것임. 레퍼런스로 참조할 것이 person1. 여기서 가져올 것이 이름 가져올거라 name 기술하면됨 -->
	성별 : <jsp:getProperty property="gender" name="put_varName_n_ref"/><br>
	나이 : <jsp:getProperty property="nai" name="put_varName_n_ref"/><br>
	
	
<h2> 1.표준 액션 태그  useBean으로 vo클래스 객체 불러오기</h2>
	
	<jsp:useBean id="per" class="action.model.vo.Person"></jsp:useBean>
	
	<!-- set으로 a값 넣기 : value속성값 -->
	<jsp:setProperty property="name" name="per" value="a"/>
	
	<span>jsp:useBean & getProperty로 vo클래스 값 가져오기 :</span> 
	<jsp:getProperty property="name" name="per"/><br><br>

<br><hr><br>
<h2> 2.표준 액션 태그 중 useBean을 사용하여 vo클래스에 데이터 초기화</h2>
	<jsp:useBean id="p" class="action.model.vo.Person" scope="request"/>
	<jsp:setProperty property="name" name="p" value="b"/>
	
	<span>jsp:useBean & getProperty로 vo클래스 값 가져오기 : </span>
	<jsp:getProperty property="name" name="p"/><br><br>
	
	
	이름 : <jsp:getProperty property="name" name="p"/><br> 
	성별 : <jsp:getProperty property="gender" name="p"/><br>
	나이 : <jsp:getProperty property="nai" name="p"/>

<br><hr><br>
<h2> 3.jsp 표준 액션태그 중 useBean의 param속성 사용하기</h2>
<% request.setCharacterEncoding("UTF-8"); %> <!-- 자바코드 끌어오는 거니 끝에 세미콜론; -->
	<jsp:useBean id="p3" class="action.model.vo.Person" scope="request">
		<!-- 1)param속성 사용 -->
		<jsp:setProperty property="gender" name="p3" param="gender"/>
		<jsp:setProperty property="nai" name="p3" param="nai"/>
		<jsp:setProperty property="name" name="p3" />
		<!-- 
			jsp:setProperty에서 
				 name속성 : useBean의 id속성값에서 객체(여기서는 vo클래스)를 호출해오고 
				 property속성 : vo객체 안에 값을 저장할 setter명을 지정해준 것
				 param : 뷰에서 보낸 데이터를 받아오는 역할
		 -->
	</jsp:useBean>
		이름 : <jsp:getProperty property="name" name="p3"/><br>
		성별 : <jsp:getProperty property="gender" name="p3"/><br>
		나이 : <jsp:getProperty property="nai" name="p3"/><br>

<br><br><br>
</body>
</html>


