<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="join.css">
    <link rel="stylesheet" href="CSS/reset.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  <!-- 다음 우편번호 api-->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/gdProject2/js/post.js"></script>
</head>
<body>
    <div class="container">
    <header></header>
    <div id="main" class="join">
        <div class="border">
            <section id="title" class="join_title">
                <h1>회원가입</h1>
                <p>회원 정보를 입력해주세요.</p>
            </section>
            <section id="form" class="form-group">
                <form action="#" method="POST" name="join" id="join_form">
                    <div class="mb-3">
                        <label for="id" class="form-label smallTitle">아이디</label><br>
                        <input type="text" name="id" placeholder="아이디를 입력하세요" class="form-control" id="id"/>
                        <button id="idChkBtn">중복확인</button>
                    </div>

                    <div class="mb-3">
                        <label for="pw" class="form-label smallTitle">비밀번호</label>
                        <label for="pwChk" class="form-label smallTitle" id="pwChkLabel">비밀번호 확인</label>
                        <span id="pwChkResult">일치하지않습니다.</span><br>
                        <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control">
                        <input type="text" name="pwChk" id="pwChk" placeholder="비밀번호를 한번 더 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="nickName" class="form-label smallTitle">닉네임</label>
                        <label for="name" class="form-label smallTitle" id="nameLabel">이름</label><br>
                        <input type="text" name="nickName" id="nickName" placeholder="닉네임을 입력하세요" class="form-control">
                        <input type="text" name="name" id="name" placeholder="이름을 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="tel" class="form-label smallTitle">연락처</label>
                        <label for="radio" class="form-label smallTitle" id="genderLabel">성별</label><br>

                        <select name="firstTel" id="tel">
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="02">02</option>
                            <option value="031">031</option>
                            <option value="032">032</option>
                        </select>
                        - <input type="text" name="middleTel" class="form-control" id="middleTel">
                        - <input type="text" name="lastTel" class="form-control tel" id="lastTel">

                        <span id="radios">
                            <input type="radio" id="radio" class="radio">남자
                            <input type="radio" class="radio">여자
                            <input type="radio" class="radio">기타
                        </span>
                        
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label smallTitle">이메일</label>
                        <label for="birth" class="form-label smallTitle" id="birthLabel">생년월일</label><br>
                        <input type="email" name="email" id="email" placeholder="이메일을 입력하세요" class="form-control">
                        <input type="date" name="birth" id="birth" placeholder="생년월일을 입력하세요" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="sample6_postcode" class="form-label smallTitle">주소</label><br>
                        <input type="text" id="sample6_postcode" placeholder="우편번호" name="postcode" class="form-control">
                        <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="postcodeBtn"><br>
                        <input type="text" id="sample6_address" placeholder="주소" name="address" class="form-control">
                        <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="addressDetail" class="form-control"><br>
                    </div>
                    <input type="submit" value="회원가입" id="join" name="join"/>
                    <button type="button" id="cancle">취소</button>
                </form>
               
            </section>
            
        </div>

    </div>
    <footer></footer>
   </div>
</body>
</html>