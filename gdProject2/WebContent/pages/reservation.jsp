<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>여기에 제목을 입력하십시오</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
        />
        <link rel="stylesheet" href="css/default.css" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            .container-box {
                margin: 0 auto;
                width: 100%;
                max-width: 1200px;
            }
            .content {
                flex: 3;
                max-width: 800px;
                margin: 50px;
            }
            .select {
                border: 1px solid black;
                padding: 25px;
            }
            .card-list {
                max-width: 800px;
                margin: 10px 50px;
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
            }
            .card-box {
                display: block;
                font-size: 24px;
                border: 1px solid #468c91;
                border-radius: 10px;
                padding: 20px 40px;
                margin: 10px;
                color: #468c91;
            }
            .card-box:hover {
                background-color: #468c91;
                color: white;
            }
        </style>
        <script>
            $(function () {
            	function XMLToString(oXML) {
           		 
            	    //code for IE
            	    if (window.ActiveXObject) {
            	        var oString = oXML.xml;
            	        return oString;
            	    }
            	    // code for Chrome, Safari, Firefox, Opera, etc.
            	    else {
            	        return (new XMLSerializer()).serializeToString(oXML);
            	    }
            	}
                var url = "subject-doctor";
                $(".subject").click(function () {
                    console.log($(this).text());
                    $.get(url, { subject: $(this).text() }, function (data) {
                    	console.log(XMLToString(data));
                    	
                    });
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="../components/header.jsp"></jsp:include>
        <div class="flex container-box">
            <jsp:include page="../components/sidemenu.jsp"></jsp:include>
            <div class="content">
                <ul>
                    <li>예약</li>
                    <li>예약하기</li>
                </ul>
                <h1>예약하기</h1>
                <div class="select">
                    <h2>진료과 선택</h2>
                    <ul class="card-list">
                        <c:forEach var="subject" items="${subjectList}">
                            <li class="card-box subject">${subject.name}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="select">
                    <h2>의료진 선택</h2>
                </div>
                <div class="select">
                    <h2>예약 날짜 선택</h2>
                </div>
            </div>
        </div>
        <jsp:include page="../components/footer.jsp"></jsp:include>
    </body>
</html>
