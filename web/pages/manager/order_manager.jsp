<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
			<span class="wel_word">订单管理系统</span>

		<%-- 静态包含 manager管理模块的菜单  --%>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>

	<div id="main">
		<c:if test="${empty requestScope.orders}">
			<h1>当前没有订单!</h1>
		</c:if>
		<c:if test="${not empty requestScope.orders}">
			<table>
				<tr>
					<td>订单号</td>
					<td>日期</td>
					<td>金额</td>
					<td>详情</td>
					<td>发货</td>
				</tr>
				<c:forEach items="${requestScope.orders}" var="orders">
					<tr>
						<td>${orders.orderId}</td>
						<td>${orders.createTime}</td>
						<td>${orders.price}</td>
						<td><a href="client/orderServlet?action=orderDetail&orderId=${orders.orderId}">查看详情</a></td>
						<td>
							<c:choose>
								<c:when test="${orders.status == 0}">
									<a href="manager/orderServlet?action=deliverOrder&orderId=${orders.orderId}">点击发货</a>
								</c:when>
								<c:when test="${orders.status == 1}">
									等待收货
								</c:when>
								<c:when test="${orders.status == 2}">
									交易完成
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>

		</c:if>

	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>