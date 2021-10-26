<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/noticeList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>공지사항</title>
</head>

<body>
    <div class="container">
    <header><jsp:include page="/jsp/common/header.jsp"></jsp:include></header>
        <div id="main">
            <form action="#" method="post" id="form">
                <h2>공지사항</h2>
                <input type="search" id="search" class="form-control"  name="search" placeholder="검색할 제목이나 내용을 입력해주세요." />
                <button type="submit" id="searchBtn" name="searchBtn">검색</button>
            </form>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>저희 병원을 이용해주셔서 감사합니다.</td>
                        <td>관리자</td>
                        <td>2021-10-26</td>
                        <td>0</td>
                    </tr>
                </tbody>
            </table>
        </div>
		<p id="info">※내역을 클릭하면 상세조회가 가능합니다.</p>
		<footer><jsp:include page="/jsp/common/footer.jsp"></jsp:include></footer>
    </div>
</body>

</html>