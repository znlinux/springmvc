<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<a href="testView">TEST View</a>
	   <br><br>
		
		<a href="testViewAndViewResolver">TEST ViewAndViewResolver</a>
	   <br><br>
		<!-- 
		模拟修改操作
		1.原始数据为：1，Grace,123456,grace@163.com,123456
		2.密码不能被修改
		3.表单回显，模拟操作直接在表单填写相应的属性
		-->
		<form action="testModelAttribute" method="post">
			<input type="hidden" name="id" value="1"/>
			<br><br>
			name: <input type="text" name="username" value="Grace">
			<br><br>
			email: <input type="text" name="email" value="grace@163.com">
			<br><br>
			tel: <input type="text" name="tel" value="123456">
			<br><br>
			<input type="submit"  value="submit">
		</form>
		<br><br>
		<a href="testSessionAttributes">TEST SessionAttributes</a>
	   <br><br>
	   
		<a href="testMap">TEST Map</a>
	   <br><br>
		<a href="testModelAndView">TEST ModelAndView</a>
	   <br><br>

		<a href="testServletAPI">TEST ServletAPI</a>
	   <br><br>
	   
		<form action="testPojo" method="post">
		username:<input type="text" name="username"/>
		<br><br>
		password:<input type="password" name="password"/>
		<br><br>
		email:<input type="text" name="email"/>
		<br><br>
		tel:<input type="text" name="tel"/>
		<br><br>
		city:<input type="text" name="address.city"/>
		<br><br>
		province:<input type="text" name="address.province"/>
		<br><br>
		<input type="submit" value="submit"/>
		</form>
		<br><br>
		
		<a href="testCookieValue">TEST CookieValue</a>
	   <br><br>

		<a href="testRequestHeader">TEST RequesHeader</a>
	   <br><br>

		<a href="testRequestParam?username=zn&age=11">TEST RequestParam</a>
	   <br><br>
<!-- 只有在表单里才可以用POST请求 -->
		<!-- 更新ID为1的user -->
	   <form action="testRest/1" method="post">
	   		<input type="hidden" name="_method" value="PUT"/>
	   		<input type="submit" value="TestRest PUT">
	   </form>
	   <br><br>
	   <!-- delete需要增加一个隐藏域 -->
	   <!-- 删除ID为1的user -->
	   <form action="testRest/1" method="post">
	   		<input type="hidden" name="_method" value="DELETE"/>
	   		<input type="submit" value="Test Rest DELETE">
	   </form>
	   <br><br>
	   
	   <!-- 新建ID为1的user -->
	   <form action="testRest" method="post">
	   		<input type="submit" value="Test Rest POST">
	   </form>
	   <br><br>
	   <!-- 得到ID为1的user -->
	   <a href="testRest/1">TEST REST Get</a>
	   <br><br>
	       
	  <a href="testPathVariable/1">testPathVariable</a>

	   <br><br>
	  
	  <a href="testAntPath/mnxy">testAntPath</a>

	   <br><br>
	  
	  <a href="testRequestParamsAndHeaders?username=zn&age=11"> testRequestParamsAndHeaders</a>

	   <br><br>
	<form action="testRequestMethod" method="post">
	<input type="submit" value="submit"/>
	
	</form>
   
   <br><br>
   <a href="helloworld"> Hello World</a>
   
</body>
</html>