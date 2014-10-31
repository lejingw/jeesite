<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>查看销量</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/operate/sale/">查看销量</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="sale" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>彩种代码 ：</label><form:input path="lotteryType" htmlEscape="false" maxlength="50" class="input-small"/>
        <label>开始日期：</label><input name="beginDate" value="${sale.beginDate}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});">
        <label>结束日期：</label><input name="endDate" value="${sale.endDate}" type="text" readonly="readonly" maxlength="20" class="input-small Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});">
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>提交时间</th><th>彩种代码</th><th>销售金额</th><th>中奖金额</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="sale">
			<tr>
                <td width="25%">${sale.orderTime}</td>
                <td width="25%">${sale.lotteryType}</td>
                <td width="25%">${sale.orderbonus}</td>
                <td width="25%">${sale.bonus}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
