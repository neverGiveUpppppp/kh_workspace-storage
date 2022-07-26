
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> 공지사항 </title>

<link rel="stylesheet" type="text/css" 
	  href="board_Notice.css">
<script src="https://kit.fontawesome.com/76295929c4.js" crossorigin="anonymous"></script>



</head>
<body>




    <div class="container">

<!-- 헤더푸터는 클래스명 신경써야함
다른 페이지 임포트 되는거에는 css 선택자 적용안됨
메인 : 페이지가 달라지는거니 상관없다 -->

        <div class="main">
            <div class="infoContainer">
                <div class="titleArea">
                    <h3 >공지사항</h3>
                    <span>
                        TREND_EATER의 새로운 소식과 유용한 정보를 한곳에서 확인하세요
                    </span>
                </div>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>조회</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="b" items="${ list }">
                                <tr>
                                    <td class="tbodyTd1">${ b.boardId } </td>        
                                    <td class="tbodyTd2">${ b.boardTitle }</td>
                                        <!-- <a href=""><b></b></a><b></b></td> -->
                                    <td class="tbodyTd3"> ${ b.nickName } </td>
                                    <td class="tbodyTd4">${ b.boardCreateDate }</td>
                                    <td class="tbodyTd5">${ b.boardCount }</td>
                                </tr>
                            </c:forEach>
                                                

                        </tbody>
                            


                    </table>
                </div>
<%-- 
                <!-- Pagination -->
                <div class="pagination">
                        <!-- [이전] -->
                    <c:if test="${ pi.currentPage <= 1 }">
                        [이전] &nbsp;
                    </c:if>
                    <c:if test="${ pi.currentPage > 1 }">
                        <c:url var="before" value="blist.bo">
                            <c:param name="page" value="${ pi.currentPage - 1 }"/>
                        </c:url>
                        <a href="${ before }">[이전]</a> &nbsp;
                    </c:if>
                    
                    <!-- 페이지 -->
                    <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
                        <c:if test="${ p eq pi.currentPage }">
                            <font color="red" size="4"><b>[${ p }]</b></font>
                        </c:if>
                        
                        <c:if test="${ p ne pi.currentPage }">
                            <c:url var="pagination" value="blist.bo">
                                <c:param name="page" value="${ p }"/>
                            </c:url>
                            <a href="${ pagination }">${ p }</a> &nbsp;
                        </c:if>
                    </c:forEach>
                    
                    <!-- [다음] -->
                    <c:if test="${ pi.currentPage >= pi.maxPage }">
                        [다음]
                    </c:if>
                    <c:if test="${ pi.currentPage < pi.maxPage }">
                        <c:url var="after" value="blist.bo">
                            <c:param name="page" value="${ pi.currentPage + 1 }"/>
                        </c:url> 
                        <a href="${ after }">[다음]</a>
                    </c:if>        
                </div>

 --%>
                <div class="boardSearchBox">
                    <div>
                        <span>검색어</span>
                        <ul>
                            <li><label><input type="checkbox">이름</label></li>
                            <li><input type="checkbox">제목</li>
                            <li><input type="checkbox">내용</li>
                        </ul>
                    </div>
                    <div class="searchBar">
                        <input type="search">
                        <input type="image" name="submit" src="${pageContext.servletContext.contextPath}/resources/img/icons/icons_Notice_search.png">
                    </div>
                </div>
            </div>
        </div>
        
        

       

    </div>
   
</body>
</html>