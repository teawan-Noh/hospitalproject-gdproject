<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta />
        <meta
            http-equiv="Content-Type"
            content="text/html; charset=UTF-8"
            name="viewport"
            content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"
        />

        <title>여기에 제목을 입력하십시오</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
        />
        <link rel="stylesheet" href="css/default.css" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>

        <style>
            a {
                text-decoration: none !important;
            }
			.home-img{
            	background-image: url("img/home.png");
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                width: 20px;
                height: 20px;
            }
            .fmenu{
            	padding-left: 0px;
            }
            .fmenu li:not(.fmenu li:first-child)::before{
            	content: ">";
            }
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

            .card-box:hover:not(.not-available),
            .card-box.active:not(.not-available) {
                background-color: #468c91;
                color: white;
            }
            .card-box.not-available {
                background-color: #b8b8b8;
                border: none;
                color: white;
            }

            .rsv-time .card-box {
                font-size: 16px !important;
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
            .card-box:hover button,
            .card-box.active button {
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
            .book {
                margin-left: 0;
            }
            .table {
                border-color: #468c91;
                border-top: 3px;
                border-bottom: 3px;
                border-style: solid;
                border-collapse: collapse;
            }
            .table-head {
                background-color: #b8b8b8;
            }
            .table-rcode {
                display: none;
            }
            .rsv-change{
            	float: right;
            }
        </style>
        <script>
            $(function () {
                $(document).on("click", "#rsv-delete", function(){
                	if(confirm("정말 예약을 취소하시겠습니까?") == true){
                		alert("예약이 취소되었습니다.");
                   		location.href = "reservation-delete?rcode=" + "${rsvInfo.rcode}";
                	}
                });
                $(document).on("click", "#rsv-update", function(){
                	$("#update-form").submit();
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        <div class="flex container-box">
            <jsp:include page="../common/sidemenu.jsp">
                <jsp:param name="side" value="${side}" />
            </jsp:include>
            <div class="content">
                <ul class="fmenu">
                	<li><div class="home-img"></div></li>
                    <li>예약</li>
                    <li>예약조회</li>
                </ul>
                <h1>예약조회</h1>
                <br />
                <table id="rsv-mylist" class="table">
                        <tr id="table-pname">
                            <th>성명</th>
                            <c:if test="${rsvInfo.pname != null}">
                    			<td>${rsvInfo.pname}</td>
                			</c:if>
                        </tr>
                        <tr id="table-tel">
                            <th>연락처</th>
                            <c:if test="${rsvInfo.tel != null}">
                				<td>${rsvInfo.tel}</td>
            				</c:if>
                        </tr>
                        <tr id="table-rsvdate">
                            <th>예약일자</th>
                            <c:if test="${rsvInfo.rsvdate != null}">
            					<td>${rsvInfo.rsvdate}</td>
        					</c:if>
                        </tr>
                        <tr id="table-rsvtime">
                            <th>예약시간</th>
                            <c:if test="${rsvInfo.rsvtime != null}">
            					<td>${rsvInfo.rsvtime}</td>
        					</c:if>
                        </tr>
                        <tr id="table-sname">
                            <th>진료과</th>
                            <c:if test="${rsvInfo.sname != null}">
            					<td>${rsvInfo.sname}</td>
        					</c:if>
                        </tr>
                        <tr id="table-dname">
                            <th>담당교수</th>
                            <c:if test="${rsvInfo.dname != null}">
            					<td>${rsvInfo.dname}</td>
        					</c:if>
                        </tr>
                </table>
               	<c:if test="${rsvInfo.state == '예약' && side == 'reservation'}">
                <div class="rsv-change">
                	<button type="button" id="rsv-update" class="btn btn-success">수정</button>
                	<button type="button" id="rsv-delete" class="btn btn-danger">예약 취소</button>
                </div>
                <form id="update-form" action="reservation" method="post">
                	<input type="hidden" id="form-rcode" name="rcode" value="${rsvInfo.rcode}"/>
                    <input type="hidden" id="form-pcode" name="pcode" value="${rsvInfo.pcode}"/>
                	<input type="hidden" id="form-subject" name="subject" value="${rsvInfo.sname}"/>
                	<input type="hidden" id="form-dcode" name="dcode" value="${rsvInfo.dcode}"/>
                	<input type="hidden" id="form-dname" name="dname" value="${rsvInfo.dname}" />
                	<input type="hidden" id="form-rsvdate" name="rsvdate" value="${rsvInfo.rsvdate}"/>
                	<input type="hidden" id="form-rsvtime" name="rsvtime" value="${rsvInfo.rsvtime}"/>
                </form>
                </c:if>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>
</html>
