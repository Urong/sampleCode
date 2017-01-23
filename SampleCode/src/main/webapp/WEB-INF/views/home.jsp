<%-- <%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
<html>
<head>
<title>Home</title>

<script src="${contextPath}/js/common/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="${contextPath}/js/handler.js" type="text/javascript"></script>
<script src="${contextPath}/js/ajax.js" type="text/javascript"></script>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<img id="spinner" src="${contextPath}/images/477.gif"
		style="display: none;" />

	<input type="button" id="call_button" value="call" />

	<br />
	<br />
	<input type="button" id="trigger_button" value="trigger" />

</body>

</html> --%>
