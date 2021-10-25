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
                border: 1px solid #468c91;
                padding: 25px;
                margin: 25px 0;
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
                border-radius: 5px;
                padding: 10px 40px;
                margin: 10px;
                color: #468c91;
            }

            .card-box.doctor {
                display: block;
                font-size: 24px;
                border: 1px solid #468c91;
                border-radius: 5px;
                padding: 10px 0 0 0;
                margin: 10px;
                color: #468c91;
            }
            .card-box.doctor .flex {
                margin: 0 40px;
            }

            .card-box:hover,
            .card-box.active {
                background-color: #468c91;
                color: white;
            }
            .doctor-img {
                background-image: url("img/doctor-img.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                filter: opacity(0.5) drop-shadow(0 0 0 #468c91);
                margin: 25px 20px 25px 0;
                width: 100px;
                height: 100px;
            }

            .card-box button {
                width: 100%;
                background-color: #468c91;
                color: white;
                text-align: center;
            }
            .card-box:hover button {
                background-color: white;
                color: #468c91;
            }
            .doctor-name {
                margin-top: 25px;
            }
            .doctor-subject {
                font-size: 16px;
            }
            .doctor-code {
                display: none;
            }
        </style>
        <script>
            $(function () {
                
                
            });
        </script>
    </head>
    <body>
        <jsp:include page="../components/header.jsp"></jsp:include>
        <div class="flex container-box">
            <jsp:include page="../components/sidemenu.jsp"></jsp:include>
            <div class="content">
                <ul>
                    <li>의료진</li>
                    <li>의료진 목록조회</li>
                </ul>
                <div class="flex">
                	<div class="doctor-img"></div>
                	<div>
                		
                	</div>
                </div>
            </div>
        </div>
        <jsp:include page="../components/footer.jsp"></jsp:include>
    </body>
</html>