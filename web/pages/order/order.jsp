<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的订单</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png" >
	<span class="wel_word">我的订单</span>

	<%--静态包含，登录 成功之后的菜单 --%>
	<%@ include file="/pages/common/login_success_menu.jsp"%>


</div>
<div>
<div id="main">
	<c:if test="${empty requestScope.myOrder}">
		<h1>当前没有订单，<a href="index.jsp">快去购买宝贝吧！</a></h1>
	</c:if>
	<c:if test="${not empty requestScope.myOrder}">
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.myOrder}" var="order">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<td>
						<c:choose>
							<c:when test="${order.status == 0}">
								未发货
							</c:when>
							<c:when test="${order.status == 1}">
								<a href="client/orderServlet?action=receiveOrder&orderId=${order.orderId}">确认收货</a>
							</c:when>
							<c:when test="${order.status == 2}">
								交易完成
							</c:when>
						</c:choose>
					</td>
					<td><a href="client/orderServlet?action=orderDetail&orderId=${order.orderId}">查看详情</a></td>
				</tr>
			</c:forEach>

		</table>		</c:if>


</div>

</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>


</body>
</html>