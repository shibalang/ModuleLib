<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="module,keyword2,keyword3">
<meta http-equiv="description" content="This is index page">

<link rel="icon" href="img/favicon.ico">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/top.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<style type="text/css">
.resultContent {
	margin-top: 6px;
}

.ctlID {
	text-overflow: ellipsis; /* for IE */
	-moz-text-overflow: ellipsis; /* for Firefox,mozilla */
	overflow: hidden;
	white-space: nowrap;
	width: 140px;
}

.ctl {
	text-overflow: ellipsis; /* for IE */
	-moz-text-overflow: ellipsis; /* for Firefox,mozilla */
	overflow: hidden;
	white-space: nowrap;
	width: 180px;
}

.liClass {
	margin: 3px auto;
}
</style>

</head>

<body>

	<%@include file="../top.html"%>
	<div class="main">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<h1 class="text-warning" style="margin-top:-15px">Results</h1>
				</div>
			</div>
			<div>
				<div class="col-md-2">
					<hr style="border:1px dashed  #036;margin:0;" />
				</div>
				<div class="col-md-10">
					<hr style="border:1px dashed  #036;margin:0;" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<div id="organism">
						<h4 class="text-warning">Popular Organisms</h4>
						<ul>
							<li class="liClass"><a href=""><em><big>Escherichiacoli</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Saccharomycescerevisiae</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Caenorhabditiselegans</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Drosophilamelanogaster</big></em></a></li>
							<li class="liClass"><a href=""><em><big>zebrafish</big></em></a></li>
						</ul>
					</div>

					<div id="viewBy">
						<h4 class="text-warning">View by</h4>
						<ul>
							<li class="liClass"><a href=""><em><big>Protein
											Name</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Gene
											Name</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Original
											Organism</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Target
											Organism</big></em></a></li>
							<li class="liClass"><a href=""><em><big>Functional
											Classification</big></em></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-10">
					<div class="row">
						<div class="col-md-2 col-md-offset-10">
							<div id="navPage" style="padding:5px">
								<a href="javascript:pageOperateDelete()" aria-label="Previous"><span
									class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
								<big> <strong><span id="itemFrom">1</span></strong> to <strong><span
										id="itemEnd">20</span></strong> of <strong><span id="itemSum">20</span></strong>
								</big> <a href="javascript:pageOperateAdd()" aria-label="Next"><span
									class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
							</div>
						</div>
					</div>
					<div class="resultContent">
						<table style="table-layout: fixed;"
							class="table table-bordered table-striped .table-condensed .table-responsive"
							id="resultTable">
							<thead>
								<tr style="background-color:#2EC9CE;">
									<td style="width:140px"><b>ID</b></td>
									<td style="width:180px"><b>Protein Name</b></td>
									<td style="width:180px"><b>Gene Name</b></td>
									<td style="width:180px"><b>Original Organism</b></td>
									<td style="width:180px"><b>Target Organism</b></td>
									<td style="width:180px"><b>Functional Classification</b></td>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
          <div class="row">
            <div class="col-md-2 col-md-offset-10">
              <div id="navPage1" style="padding:5px">
                <a href="javascript:pageOperateDelete()" aria-label="Previous"><span
                  class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
                <big> <strong><span id="itemFrom1">1</span></strong> to <strong><span
                    id="itemEnd1">20</span></strong> of <strong><span id="itemSum1">20</span></strong>
                </big> <a href="javascript:pageOperateAdd()" aria-label="Next"><span
                  class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
              </div>
            </div>
          </div>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /main -->
	<input type="text" id="searchPageInput" value="searchPage"
		style="display:none" />

	<!-- the scripts -->
	<script type="text/javascript">

  </script>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/search.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function() {
      $("#maxrowNum").hide();
    $("#currentPageNo").text(1);
    $("#currentPageSize").text(20);
      //高级搜索
      $("#saveForm").text('<%=request.getParameter("saveForm")%>');
      $("#searchType").text('<%=request.getParameter("searchType")%>');
      var dataJson="";
      dataJson=$("#saveForm").val();
      if(dataJson!="")
      {
        debugger;
        tosearch(dataJson, 1, 20);
    }

    //模糊搜索
    $("#saveFormVague").text('<%=request.getParameter("saveFormVague")%>');
    $("#searchType").text('<%=request.getParameter("searchType")%>');

					var dataJsonVague = "";
					dataJsonVague = $("#saveFormVague").val();
					if (dataJsonVague != "") {
            debugger;
						tosearchVague(dataJsonVague, 1, 20);
					}
				});
	</script>
</body>
</html>
