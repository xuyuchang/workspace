<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--	静态包含base标签、css样式、JQuery样式--%>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		//给删除绑定单击事件
		$(function () {
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗");
			})

			//给清空购物车绑定单击事件
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车嘛")
			})

			//给输入框绑定onchange事件
			$(".updateCount").change(function () {
				//confirm("nihao ")
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				var id = $(this).attr("bookId");
				if(confirm("你确定要将【"+name+"】的数量修改为（"+count+"）吗？")){
						location.href = "cartServlet?action=updateCount&id=" + id + "&count=" + count;
				}else{
					//回复默认值
					this.value = this.defaultValue;
				}

			})
		})


	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
                  <%--		静态包含登陆成功之后的菜单--%>
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5"><a href="index.jsp">当前购物车没有商品</a> </td>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
						<input type="text" class="updateCount"
							   bookId = "${entry.value.id}" style="width:60px;" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>


			
		</table>
		<%--如果购物车非空才输出以下内容--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	</div>

	<%--	静态包含页脚信息--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>