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
.searchTb {
	
}

.main {
	
}
</style>

</head>

<body>

<%@include file="top.html"%>
	<div class="main">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6" style="padding:0">

					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="img/img1.jpg" alt="...">
								<div class="carousel-caption">
									dsgsgfsdhgdfbdfbdthdrbtbdrthrdhbdrt</div>
							</div>
							<div class="item">
								<img src="img/img2.jpg" alt="...">
								<div class="carousel-caption">
									asddddddddddddddddddddddddddddddddddddddddd</div>
							</div>

							<div class="item">
								<img src="img/img3.jpg" alt="...">
								<div class="carousel-caption">
									sdgbndrtbffffffffffffffgnnnnnnnnnnnnnnn</div>
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>

				</div>
				<div class="col-md-6">
					<h2 style="background-color:#F4DFD7;padding:3px 3px;margin-top:0;">News</h2>
					<dl>
						<dt>Mosquitoes prefer human</dt>
						<dd>Thalidomide, the pharmacological version of yin and yang
							| Cross-references to DEPOD, MoonProt and Proteomes...</dd>
						<hr style="border:1px dotted  #036" />
						<dt>Mosquitoes prefer human</dt>
						<dd>Thalidomide, the pharmacological version of yin and yang
							| Cross-references to DEPOD, MoonProt and Proteomes...</dd>
						<hr style="border:1px dotted  #036" />
						<dt>Mosquitoes prefer human</dt>
						<dd>Thalidomide, the pharmacological version of yin and yang
							| Cross-references to DEPOD, MoonProt and Proteomes...</dd>
					</dl>
				</div>
			</div>
			<!-- /row -->
			<div class="row">
      <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party
              before they sold out master cleanse gluten-free squid scenester
              freegan cosby sweater. Fanny pack portland seitan DIY, art party
              locavore wolf cliche high life echo park Austin. Cred vinyl
              keffiyeh DIY salvia PBR, banh mi before they sold out
              farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral,
              mustache readymade thundercats keffiyeh craft beer marfa ethical.
              Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
              <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party
              before they sold out master cleanse gluten-free squid scenester
              freegan cosby sweater. Fanny pack portland seitan DIY, art party
              locavore wolf cliche high life echo park Austin. Cred vinyl
              keffiyeh DIY salvia PBR, banh mi before they sold out
              farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral,
              mustache readymade thundercats keffiyeh craft beer marfa ethical.
              Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
              <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party
              before they sold out master cleanse gluten-free squid scenester
              freegan cosby sweater. Fanny pack portland seitan DIY, art party
              locavore wolf cliche high life echo park Austin. Cred vinyl
              keffiyeh DIY salvia PBR, banh mi before they sold out
              farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral,
              mustache readymade thundercats keffiyeh craft beer marfa ethical.
              Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
              <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party
              before they sold out master cleanse gluten-free squid scenester
              freegan cosby sweater. Fanny pack portland seitan DIY, art party
              locavore wolf cliche high life echo park Austin. Cred vinyl
              keffiyeh DIY salvia PBR, banh mi before they sold out
              farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral,
              mustache readymade thundercats keffiyeh craft beer marfa ethical.
              Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /main -->



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
		});
	</script>
</body>
</html>
