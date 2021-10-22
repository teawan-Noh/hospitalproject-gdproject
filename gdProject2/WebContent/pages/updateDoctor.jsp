<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        .body {
            width: 1200px;
        }
        input {
            width: 300px;
            height: 20px;
            border: 1px solid rgb(148, 147, 147);
        }

        #idcheck {
            width: 70px;
            height: 25px;
            color: white;
            background-color: rgb(70, 145, 140);
            border: none;
            border-radius: 5px;
        }

        #postbtn {
            width: 120px;
            height: 25px;
            background-color: rgb(223, 220, 220);
            border: none;
            border-radius: 5px;
        }
        table {
            width: 800px;
            border-top: 4px solid rgb(70, 145, 140);
            border-left: none;
            border-right: none;
            padding-top: 0;
            border-collapse: collapse;
        }

        th {
            background-color: rgb(148, 220, 215);
            margin: 0;
            padding: 0;
            color: #555;
            font-size: 0.9rem;
        }
        tr {
            background-color: white;
            height: 30px;
            width: 700px;
            border-bottom: 1px solid #555;
        }
        td {
            padding: 5px;
        }
        .post input {
            margin-bottom: 5px;
        }

        #savebtn {
            width: 70px;
            height: 35px;
            color: white;
            background-color: rgb(70, 145, 140);
            border: none;
            border-radius: 3px;
            margin-top: 30px;
            margin-left: 350px;
        }
        #cancel {
        	width: 70px;
            height: 35px;
            color: white;
            background-color: rgb(70, 145, 140);
            border: none;
            border-radius: 3px;
            margin-top: 30px;
            margin-left: 20px;
        }
        
</style>
</head>
<body>
    <h1>개인정보수정</h1>
    <div class="container">
        <form method="post" action="update_doctor">
            <table>
                <tr>
                    <th>성명</th>
                    <td><input type="text" name="name" placeholder="이름을 입력해주세요." class="form-control"></td>
                </tr>
                <tr>
                    <th>면허번호</th>
                    <td><input type="text" name="licenseno" placeholder="의사면허번호를 입력해주세요."></td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" name="id" placeholder="아이디를 입력해주세요.">
                        <button type="button" id="idcheck">중복검사</button>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="pwd" placeholder="비밀번호를 입력해주세요."></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" name="pwdchk" placeholder="비밀번호를 다시 입력해주세요."></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td class = "post">
                        <input type="text" id="sample6_postcode" placeholder="우편번호">
                        <input type="button" id="postbtn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="sample6_address" placeholder="주소"><br>
                        <input type="text" id="sample6_detailAddress" placeholder="상세주소"><br>
                        <input type="text" id="sample6_extraAddress" placeholder="참고항목">
                    </td> 
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>
                        <input type = "date" name = "birth">
                    </td>
                </tr>
                <tr>
                    <th>경력사항</th>
                    <td>
                        <textarea name="career" placeholder="내용을 입력해주세요." rows="5" cols="40"></textarea>    
                    </td>
                </tr>
                <tr>
                    <th>휴대폰</th>
                    <td><input type = "tel" name = "tel" placeholder="전화번호를 입력해주세요."></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" name="email" placeholder="이메일을 입력해주세요."></td>
                </tr>
            </table>
            <div>
            	<button type = "submit" id = "savebtn">저장</button>
            	<button type = "button" id = "cancel" onclick="location.href = 'index.jsp'">취소</button>
            </div>
        </form>
    </div>
</body>
</html>