<%@ page language="java" import="java.util.*,entity.*,dao.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<!--  
<style type="text/css">

table {
	width: 400px;
	margin: 20px auto;
	border-collapse: collapse;
	border: 1px solid #666;
}

td {
	border: 1px solid #666;
}

</style>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	
	$("tr:odd").css("background","#999");
	$("tr:even").css("background","#fff");
	
		var oldColor;
		$("tr").hover(function() {
			oldColor = $(this).css("background")
			$(this).css("background","#666");
		}, function() {
			$(this).css("background", oldColor);
		})
	})
</script>

-->
<style type="text/css">
.table {
	width: 600px;
	margin: 20px auto;
}

#con {
	width: 600px;
	margin: 20px auto;
}

.con1 {
	margin: 0;
	padding: 0;
	margin-left: 270px;
}

.con1 li {
	list-style: none;
	float: left;
	padding: 6px 12px;
	line-height: 140%;
	text-align: center;
	margin-left: -1px;
	font-size: 14px;
	color: #337ab7;
	cursor: pointer;
	border: 1px solid #ddd;
}

.con1 li:last-CHILD {
	border-top-right-radius: 4px;
	border-bottom-right-radius: 4px;
}

.con1 li:FIRST-CHILD {
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px;
}

.con1 li:HOVER {
	background-color: #eee;
}

.con1 .active {
	color: #fff;
	background-color: #337ab7;
	border-color: #337ab7;
}

.con1 .active:HOVER {
	color: #fff;
	background-color: #337ab7;
	border-color: #337ab7;
}
</style>

<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var ye = ${ye};
		var mye = ${maxye};
		$(".con1 li:first").click(function() {
			if ((ye - 1) < 1) {
				return;
			}
			location.href = "stu?ye=${ye-1}";
		});

		$(".con1 li:first").mouseover(function() {
			if ((ye - 1) < 1) {
				$(this).css("cursor", "not-allowed");
			}
		});

		$(".con1 li:last").click(function() {
			if (ye < mye) {
				location.href = "stu?ye=${ye+1}";
			}
		});
		$(".con1 li:last").mouseover(function() {
			if ((ye + 1) > mye) {
				$(this).css("cursor", "not-allowed");
			}
		});

		$("[name=numpage]").click(function() {

			ye = $(this).html();

			location.href = "stu?ye=" + ye;
		})

		//$("[name=numpage]").removeClass("active");
		//$("[name=numpage]").eq(0).addClass("active");

	});
</script>

</head>
<body>

	<%
		//	List<Student> list=(List<Student>)request.getAttribute("stus");
	%>

	<div id="con">
		<table
			class='table table-striped table-bordered table-hover table-condensed'>

			<thead>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stus}" var="stu">
					<%
						//for(int i=0;i<list.size();i++) {
					%>
					<tr>
						<td>${stu.id }<%
							//out.println(list.get(i).getId());
						%>
						</td>
						<td>${stu.name }<%
							//out.println(list.get(i).getName());
						%>
						</td>
						<td>${stu.sex }<%
							//out.println(list.get(i).getSex());
						%>
						</td>
						<td>${stu.age }<%
							//out.println(list.get(i).getAge());
						%>
						</td>
					</tr>
					<%
						//}
					%>
				</c:forEach>
			</tbody>
		</table>
		<ul class="con1">
			<li>上一页</li>
			<%
			int ye=(Integer)request.getAttribute("ye");
			int begin=ye;
			int end=begin+4;
			int maxye=(Integer)request.getAttribute("maxye");
			
			if(end>maxye){
			end=maxye;
			begin=end-4;
			}		
				for (int i = begin; i <= end; i++) {
			%>
			<li name="numpage" <% if(ye==i){out.print("class='active'");}%>><%=i%></li>
			<%
				}
			%>

			<li>下一页</li>
		</ul>



	</div>
</body>
</html>
