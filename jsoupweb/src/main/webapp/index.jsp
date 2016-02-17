<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsoupweb</title>
</head>
<html>
	<body>
		<form  action="jsoup.do" method="post">
			请输入要采集的网址:
			<input type="text" name="href" size="120"  value="${map.href}"/>
			<input type="submit"  value='开始采集数据' />
		</form><br/>
			标题：<span>${map.title}</span><br/><br/>
			图片路径:${map.jpg}<br/>
			图片:<img  src="${map.jpg}" ><br/><br/>
			产品描述：<span>${productDetails}</span><br/>
				   <span>${keyFeatures}</span><br/>
				   <span>${keyFeaturesText}</span><br/>
			属性：<br/>
		<c:forEach items="${map.list}" var="list" >
			<span>${list}</span><br/>
		</c:forEach>
	</body>
</html>
