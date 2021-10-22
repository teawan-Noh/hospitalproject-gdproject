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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            #footer {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
                background-color: #b8b8b8;
                color: white;
            }
            .footer-ul {
                padding: 0px;
            }
            .footer-list {
                display: inline-block;
                padding: 5px 10px 10px 0px;
            }
            .sns li{
            	margin-right: 25px;
            }
            #facebook {
                background-image: url("img/facebook.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                width: 32px;
                height: 32px;
            }
            #instagram {
                background-image: url("img/instagram.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                width: 32px;
                height: 32px;
            }
            #youtube {
                background-image: url("img/youtube.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                width: 32px;
                height: 32px;
            }
            #blog {
                background-image: url("img/blog.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                width: 32px;
                height: 32px;
            }
        </style>
    </head>

    <body>
        <div id="footer">
            <ul class="footer-ul">
                <li class="footer-list">회원 약관</li>
                <li class="footer-list">개인정보처리방침</li>
                <li class="footer-list">환자권리장전</li>
                <li class="footer-list">자주묻는질문</li>
            </ul>
            <ul class="footer-ul sns">
                <li>
                    <a href="#"><div id="facebook"></div></a>
                </li>
                <li>
                    <a href="#"><div id="instagram"></div></a>
                </li>
                <li>
                    <a href="#"><div id="youtube"></div></a>
                </li>
                <li>
                    <a href="#"><div id="blog"></div></a>
                </li>
            </ul>
            <p>대표 전화 : 031-123-4567&nbsp;대표자 : 홍길동</p>
            <p>주소 : 경기도 ㅇㅇ시 ㅇㅇ구 ㅇㅇ동 ㅇㅇ로 12, 345호</p>
            <p>COPYRIGHT BY ㅁㅁ병원</p>
        </div>
    </body>
</html>