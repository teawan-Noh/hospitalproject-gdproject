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
			    display: inline-block;
			    text-decoration: none !important;
			}
			button {
			    border: 0;
			    background: transparent;
			    cursor: pointer;
			}
			ul{
				padding: 0;
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
            	let pcode = ${pcode};
                let subject = "${subject}";
                let dcode = "${dcode}";
                let dname = "${dname}";
                let rsvdate = "${rsvdate}";
                let rsvtime = "${rsvtime}";
                let rcode = ${rcode};
                
                $(document).on("click", ".rsv-cancel", function(){
                	if(confirm("정말 예약을 취소하시겠습니까?") == true){
                		alert("예약이 취소되었습니다.");
                   		location.href = "/gdProject2";
                	}
                });
                $(document).on("click", "#rsv-insert", function(){
                	$("#insert-form").submit();
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
                    <li>예약 확인</li>
                </ul>
                <h1>예약 확인</h1>
                <br />
                <table id="rsv-mylist" class="table">
                        <tr id="table-pname">
                            <th>성명</th>
                            <c:if test="${patient.name != null}">
                    			<td>${patient.name}</td>
                			</c:if>
                        </tr>
                        <tr id="table-tel">
                            <th>연락처</th>
                            <c:if test="${patient.tel != null}">
                				<td>${patient.tel}</td>
            				</c:if>
                        </tr>
                        <tr id="table-rsvdate">
                            <th>예약일자</th>
                            <c:if test="${rsvdate != null}">
            					<td>${rsvdate}</td>
        					</c:if>
                        </tr>
                        <tr id="table-rsvtime">
                            <th>예약시간</th>
                            <c:if test="${rsvtime != null}">
            					<td>${rsvtime}</td>
        					</c:if>
                        </tr>
                        <tr id="table-sname">
                            <th>진료과</th>
                            <c:if test="${subject != null}">
            					<td>${subject}</td>
        					</c:if>
                        </tr>
                        <tr id="table-dname">
                            <th>담당교수</th>
                            <c:if test="${dname != null}">
            					<td>${dname}</td>
        					</c:if>
                        </tr>
                </table>
               	<c:if test="${side == 'reservation' || side == 'manager'}">
               	<c:if test="${rcode == 0}">
                <div class="rsv-change">
                	<button type="button" id="rsv-insert" class="btn btn-success">예약하기</button>
                	<button type="button" class="btn btn-danger rsv-cancel">취소</button>
                </div>
                </c:if>
                <c:if test="${rcode != 0}">
                <div class="rsv-change">
                	<button type="button" id="rsv-update" class="btn btn-success">예약 변경하기</button>
                	<button type="button" class="btn btn-danger rsv-cancel">취소</button>
                </div>
                </c:if>
                <form id="insert-form" action="book" method="post">
                    <input type="hidden" name="pcode" value="${pcode}"/>
                	<input type="hidden" name="dcode" value="${dcode}"/>
                	<input type="hidden" name="rsvdate" value="${rsvdate} ${rsvtime}"/>
                </form>
                <form id="update-form" action="reservation-update" method="post">
                	<input type="hidden" name="rcode" value="${rcode}"/>
                    <input type="hidden" name="pcode" value="${pcode}"/>
                	<input type="hidden" name="dcode" value="${dcode}"/>
                	<input type="hidden" name="rsvdate" value="${rsvdate} ${rsvtime}"/>
                </form>
                </c:if>
            </div>
        </div>
        <jsp:include page="../common/footer.jsp"></jsp:include>
    </body>
</html>
