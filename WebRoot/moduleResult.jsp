<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import="com.module.beans.Module"%>
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

.mynavInpage {
	position: fixed;
	
	top: 65px;
}
#mynavInpageId{
	margin-left: 55px;
}
</style>

</head>

<body>

	<%@include file="../top.html"%>
	<input type="text" id="inputModuleId"
		value="<%=request.getAttribute("id")%>" style="display:none" />

	<div class="main">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<h1 class="text-warning" id="smbid" style="margin-top:-15px">
						</h1>
				</div>
			</div>
			<!-- /row -->
			<div class="row">
				<div class="col-md-2">
					<h4 class="text-success text-right">Protein Name</h4>
				</div>
				<div class="col-md-10">
					<h4 id="proteinname">
						<strong>Protein Name</strong>
					</h4>
				</div>
			</div>
			<!-- /row -->
			<div class="row">
				<div class="col-md-2">
					<h4 class="text-success text-right">Gene Name</h4>
				</div>
				<div class="col-md-10">
					<h4 id="genename">
						<strong>Protein Name</strong>
					</h4>
				</div>
			</div>
			<!-- /row -->

			<div class="row">
				<div class="col-md-2">
					<h4 class="text-success text-right">Protein Status</h4>
				</div>
				<div class="col-md-10">
					<h4 id="proteinstatus">
						<strong>Protein Name</strong>
					</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<h4 class="text-success text-right">Functional Classification</h4>
				</div>
				<div class="col-md-8">
					<h4 id="funcclassification">
						<strong>Protein Names</strong>
					</h4>
				</div>
				<div class="col-md-2">
					<button class="button" onclick="downloadExcel('<%=request.getAttribute("id")%>')">导出Excel</button>
					<button class="button" onclick="downloadPdf('<%=request.getAttribute("id")%>')">导出PDF</button>
				</div>
			</div>
			<!-- /row -->
			<hr style="border:1px dashed  #036" />
			<div class="row">
				<div class="col-md-2">

					<div class="list-group pull-left" id="mynavInpageId">
						<a href="javascript:void(0)"
							onclick="document.getElementById('name_id').scrollIntoView();"
							class="list-group-item active"> Name&Taxonomy </a> <a href="javascript:void(0)"
							onclick="document.getElementById('function_id').scrollIntoView();"
							class="list-group-item active">Function</a>
							<a href="javascript:void(0)"
							onclick="document.getElementById('enzyme_id').scrollIntoView();"
							class="list-group-item active">Enzyme Informations</a>
							 <a
							href="javascript:void(0)"
							onclick="document.getElementById('sequence_id').scrollIntoView();"
							class="list-group-item active">Sequence</a>
							<a href="javascript:void(0)"
							onclick="document.getElementById('otherInfo_id').scrollIntoView();"
							class="list-group-item active">Other Informations</a>
							<a href="javascript:void(0)"
							onclick="document.getElementById('linkdb_id').scrollIntoView();"
							class="list-group-item active">Link Databases</a>
					</div>

				</div>



				<div class="col-md-10">
					<div class="resultContent">
						<table>

							<!--name  -->
							<tr>
								<p class="lead text-warning">
									<a name="name_id" id="name_id">Name&Taxonomy</a>
								</p>
								<hr style="border:1px solid #b9772e" />
								<table class="table table-bordered table-condensed">
									<tr>
										<td><strong>Protein Name</strong></td>
										<td id="proteinname_dd"></td>
									</tr>
									<tr>
										<td><strong>Targeted Organism</strong></td>
										<td id="targetorganism_dd"></td>
									</tr>
									<tr>
										<td><strong>Original Organism</strong></td>
										<td id="originalorganism_dd"></td>
									</tr>
									<tr>
										<td><strong>Taxonomic Identifier</strong></td>
										<td id="taxonomicidentifier_dd"></td>
									</tr>
								</table>
								<!-- <dl class="dl-horizontal">
									<dt>Protein Name</dt>
									<dd id="proteinname_dd">...</dd>
									<dt>Targeted Organism</dt>
									<dd id="targetorganism_dd">...</dd>
									<dt>Original Organism</dt>
									<dd id="originalorganism_dd">...</dd>
									<dt>Taxonomic Identifier</dt>
									<dd id="taxonomicidentifier_dd">...</dd>
									
								</dl> -->
							</tr>

							

							<!-- function -->
							<tr>
								<p class="lead text-warning">
									<a name="function_id" id="function_id">Function</a>
								</p>
								<hr style="border:1px solid #b9772e" />
								<p id="functioncc"></p>
								<table class="table table-bordered table-condensed">
									<tr>
										<td><strong>Catalytic activity</strong></td>
										<td id="catelytic_dd"></td>
									</tr>
									<tr>
										<td><strong>Cofactor</strong></td>
										<td id="cofactor_dd"></td>
									</tr>
									<tr>
										<td><strong>Pathway</strong></td>
										<td id="pathway_dd"></td>
									</tr>
								</table>
								<!-- <dl class="dl-horizontal">

									<p id="functioncc"></p>

									<dt>Catalytic activity</dt>
									<dd id="catelytic_dd">null</dd>
									<dt>Cofactor</dt>
									<dd id="cofactor_dd">null</dd>
									<dt>Pathway</dt>
									<dd id="pathway_dd">null</dd>
								</dl> -->
							</tr>

							<!-- enzyme -->
							<tr>
								<p class="lead text-warning">
									<a name="enzyme_id" id="enzyme_id">Enzyme Informations</a>
								</p>
								<hr style="border:1px solid #b9772e" />
								<div id="ecTables"></div>
							</tr>

							<!-- suquence -->
							<tr>
								<p class="lead text-warning">
									<a name="sequence_id" id="sequence_id">Sequence</a>
								</p>
								<hr style="border:1px solid #b9772e" />
								<table class="table table-bordered table-condensed">
									<tr>
										<td><strong>Protein Sequence</strong></td>
										<td id="proteinsequence_dd"></td>
									</tr>
									<tr>
										<td><strong>DNA Sequence</strong></td>
										<td id="dnasequence_dd"></td>
									</tr>
								</table>
								<!-- <dl class="dl-horizontal">
									<dt>Protein Sequence</dt>
									<dd>
										<p id="proteinsequence_dd"></p>
									</dd>
									<dt>DNA Sequence</dt>
									<dd>
										<p id="dnasequence_dd" style="display: inline-block"></p>
									</dd>
								</dl> -->
							</tr>

							<!-- Other Informations -->

							<tr>
								<p class="lead text-warning">
									<a name="otherInfo_id" id="otherInfo_id">Other Infomations</a>
								</p>
								<hr style="border:1px solid #b9772e" />
								<table class="table table-bordered table-condensed">
									<tr>
										<td><strong>Subcellular location</strong></td>
										<td id="subcellloc_dd"></td>
									</tr>
									<tr>
										<td><strong>Interaction</strong></td>
										<td id="interaction_dd"></td>
									</tr>
									<tr>
										<td><strong>String</strong></td>
										<td id="string_dd"></td>
									</tr>
									<tr>
										<td><strong>Structure(3D)</strong></td>
										<td id="structure_dd"></td>
									</tr>
								</table>
								<!-- <dl class="dl-horizontal">
									<dt>Subcellular location</dt>
									<dd>
										<p id="subcellloc_dd"></p>
									</dd>
									<dt>Interaction</dt>
									<dd>
										<p id="interaction_dd" style="display: inline-block"></p>
									</dd>
									<dt>String</dt>
									<dd>
										<p id="string_dd" style="display: inline-block"></p>
									</dd>
									<dt>Structure(3D)</dt>
									<dd>
										<p id="structure_dd" style="display: inline-block"></p>
									</dd>
								</dl> -->
							</tr>

							<!-- Link database -->
							<tr>
								<p class="lead text-warning">
									<a name="linkdb_id" id="linkdb_id">Link Databases</a>
								</p>
								<hr style="border:1px solid #b9772e" />
								<table class="table table-bordered table-condensed">
									<tr>
										<td><strong>Uniprot</strong></td>
										<td id="uniprot_dd"></td>
									</tr>
									<tr>
										<td><strong>DDBJ</strong></td>
										<td id="ddbj_dd"></td>
									</tr>
									<tr>
										<td><strong>EMBL</strong></td>
										<td id="embl_dd"></td>
									</tr>
									<tr>
										<td><strong>Genbank</strong></td>
										<td id="genebank_dd"></td>
									</tr>
									<tr>
										<td><strong>RefSeq</strong></td>
										<td id="refseq_dd"></td>
									</tr>
									<tr>
										<td><strong>KEGG</strong></td>
										<td id="kegg_dd"></td>
									</tr>
								</table>
								<!-- <dl class="dl-horizontal">
									<dt>Uniprot</dt>
									<dd>
										<p id="uniprot_dd"></p>
									</dd>
									<dt>DDBJ</dt>
									<dd>
										<p id="ddbj_dd" style="display: inline-block"></p>
									</dd>
									<dt>EMBL</dt>
									<dd>
										<p id="embl_dd" style="display: inline-block"></p>
									</dd>
									<dt>Genbank</dt>
									<dd>
										<p id="genebank_dd" style="display: inline-block"></p>
									</dd>
									<dt>RefSeq</dt>
									<dd>
										<p id="refseq_dd" style="display: inline-block"></p>
									</dd>
									<dt>KEGG</dt>
									<dd>
										<p id="kegg_dd" style="display: inline-block"></p>
									</dd>
								</dl> -->
							</tr>

						</table>
					</div>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /main -->

	<form id="downloadForm" name="downloadForm" method="post">
  		<textarea id="idDownload" name="idDownload" style="display:none"></textarea>
	</form>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/search.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
		function showResult(data) {
			//head

			//裁剪id
			var idLabel = data['module']['id'];
			if (idLabel < 10) {
				idLabel = "SMB000000" + idLabel;
			} else if (idLabel >= 10 && idLabel < 100) {
				idLabel = "SMB00000" + idLabel;
			} else if (idLabel >= 100 && idLabel < 1000) {
				idLabel = "SMB0000" + idLabel;
			} else if (idLabel >= 1000 && idLabel < 10000) {
				idLabel = "SMB000" + idLabel;
			}
			$("#smbid").text(idLabel);

			//裁剪proteinname
			var proteinnameLabel=data['module']['proteinname'];
			proteinnameLabel=proteinnameLabel.substring(0,proteinnameLabel.indexOf("("));
			$("#proteinname").text(proteinnameLabel);
			$("#genename").text(data['module']['genename']);
			$("#proteinstatus").text(data['module']['existence']);
			$("#funcclassification").text(data['module']['funcclassific']);
			//Name&Taxonomy
			$("#proteinname_dd").text(data['module']['proteinname']);
			$("#originalorganism_dd").text(data['module']['originalorganism']);
			$("#targetorganism_dd").text(data['module']['targetorganism']);
			$("#taxonomicidentifier_dd").html("<a href='http://www.ncbi.nlm.nih.gov/Taxonomy/Browser/wwwtax.cgi?lvl=0&id="+data['module']['taxonomicidentifier']+"'>"+data['module']['taxonomicidentifier']+"[NCBI]"+"</a>");

			var dnaseq = data['module']['dnasequence'];

			//sequence
			$("#proteinsequence_dd").text(data['module']['proteinsequence']);
			$("#dnasequence_dd").text(dnaseq);

			//Function
			$("#functioncc").text(data['module']['function']);
			$("#catelytic_dd").text(data['module']['catalyticactivity']);
			$("#cofactor_dd").text(data['module']['cofactor']);
			$("#pathway_dd").text(data['module']['pathway']);

			//enzyme

			var enzymeHtml="";
			for (var i = 0; i < data['ecList'].length; ++i) {
				enzymeHtml="";
				if (i!=0) {
					enzymeHtml+="<hr/>";
				};

				enzymeHtml="<table class='table .table-bordered'><tr><td><Strong>Entry</strong></td><td><a href='http://www.kegg.jp/dbget-bin/www_bget?ec:"+data['ecList'][i]['entry']+"'>EC:"+data['ecList'][i]['entry']+"</a></td></tr>"
				+"<tr><td><Strong>Name</strong></td><td>"+data['ecList'][i]['enzymename']+"</a></td></tr>"
				+"<tr><td><Strong>Class</strong></td><td>"+data['ecList'][i]['ecclass']+"</a></td></tr>"
				+"<tr><td><Strong>Sysname</strong></td><td>"+data['ecList'][i]['sysname']+"</a></td></tr>"
				+"<tr><td><Strong>Reaction(KEGG)</strong></td><td><a href='http://www.kegg.jp/dbget-bin/www_bget?rn:"+data['ecList'][i]['reaction']+"'>"+data['ecList'][i]['reaction']+"</a></td></tr>"
				+"<tr><td><Strong>Substrate</strong></td><td>"+data['ecList'][i]['substrate']+"</a></td></tr>"
				+"<tr><td><Strong>Product</strong></td><td>"+data['ecList'][i]['product']+"</a></td></tr>"
				+"<tr><td><Strong>Comment</strong></td><td>"+data['ecList'][i]['comment']+"</a></td></tr>"
				+"<tr><td><Strong>Pathway(KEGG)</strong></td><td><a href='http://www.kegg.jp/kegg-bin/show_pathway?"+data['ecList'][i]['pathway']+"+"+data['ecList'][i]['entry']+"'>"+data['ecList'][i]['pathway']+"</a></td></tr>"
				+"<tr><td><Strong>Orthology(KEGG)</strong></td><td><a href='http://www.kegg.jp/dbget-bin/www_bget?ko:"+data['ecList'][i]['orthology']+"'>"+data['ecList'][i]['orthology']+"</a></td></tr>"
				+"</table>";

				$("#ecTables").append(enzymeHtml);
			};

			//other infomations
			$("#subcellloc_dd").text(data['module']['subcellloc']);
			$("#interaction_dd").text(data['module']['interaction']);
			var stringHtml="<a href='http://string-db.org/newstring_cgi/show_network_section.pl?identifier="+data['module']['interaction']+"'>"+data['module']['interaction']+"</a>";
			$("#string_dd").html(stringHtml);
			$("#structure_dd").text(data['module']['structure']);

			//link databases
			var stringHtml="";
			stringHtml="";
			stringHtml="<a href='http://www.uniprot.org/uniprot/"+data['module']['uniprot']+"'>"+data['module']['uniprot']+"</a>";
			$("#uniprot_dd").html(stringHtml);
			stringHtml="";
			stringHtml="<a href='http://www.uniprot.org/uniprot/"+data['module']['embl']+"'>"+data['module']['embl']+"</a>";
			$("#ddbj_dd").html(stringHtml);
			stringHtml="";
			stringHtml="<a href='http://www.uniprot.org/uniprot/"+data['module']['embl']+"'>"+data['module']['embl']+"</a>";
			$("#embl_dd").html(stringHtml);
			stringHtml="";
			stringHtml="<a href='http://www.uniprot.org/uniprot/"+data['module']['embl']+"'>"+data['module']['embl']+"</a>";
			$("#genebank_dd").html(stringHtml);
			stringHtml="";
			stringHtml="<a href='http://www.uniprot.org/uniprot/"+data['module']['embl']+"'>"+data['module']['embl']+"</a>";
			$("#refseq_dd").html(stringHtml);
			stringHtml="";
			stringHtml="<a href='http://www.uniprot.org/uniprot/"+data['module']['embl']+"'>"+data['module']['embl']+"</a>";
			$("#kegg_dd").html(stringHtml);
		}

		$(document).ready(function() {
			$("#maxrowNum").hide();
			var id = $("#inputModuleId").val();
			debugger;
			var url = "module/searchById?id=" + id;
			$.ajax({
				url : url,//  action
				data : '',
				type : 'get',
				dataType : 'json',
				contentType : 'application/json',
				success : function(data) {
					showResult(data);
					debugger;
				},
				error : function() {
					// view("Òì³££¡");
					alert("error!");
				}
			});
		});
		$(window).scroll(function() {
			if ($(document).scrollTop() > 300) //判断滚动条是否滚动了300PX
				$("#mynavInpageId").addClass("mynavInpage");
			else
				$("#mynavInpageId").removeClass("mynavInpage");
		});

		function downloadExcel(id){

			$("#idDownload").text(id);
			document.downloadForm.action = 'module/downloadExcelById';
			document.downloadForm.submit();
		}
		function downloadPdf(id){

			$("#idDownload").text(id);
			document.downloadForm.action = 'module/downloadPdfById';
			document.downloadForm.submit();
		}
	</script>

</body>
</html>
