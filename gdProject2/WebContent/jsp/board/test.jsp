<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <body>
       <h1>업로드할 파일을 선택하세요.</h1>
		<form action="upload" method="post" enctype="multipart/form-data">
			<label>업로드할 파일 : <input type="file" name="filename" /></label><br />
			<input type="submit" value="업로드" />
		</form>
		
    </body>
</html>