function search() {

	$('#myModal').modal('toggle');
	var dataJson = "";
	if ($('#searchPageInput').val() != "searchPage") {
		alert("11111111");
		var table = document.getElementById("table1");
		var rows = table.rows;
		for (var i = 0; i < rows.length; i++) {
			var key = $(rows[i]).children().eq(0).children().eq(0).val();
			var value = $(rows[i]).children().eq(1).children().val();
			if (dataJson != "")
				dataJson += "&";
			dataJson += key + "=" + value;
		}

		if (dataJson != "") {
			$("#saveForm").text(dataJson);
			$("#searchType").text("search");
			document.SearchForm.action = 'searchResult.jsp';
			document.SearchForm.submit();
		} else {
			alert("error input");
		}
	} else {
		alert("22222222");
		var table = document.getElementById("table1");
		var rows = table.rows;
		for (var i = 0; i < rows.length; i++) {
			var key = $(rows[i]).children().eq(0).children().eq(0).val();
			var value = $(rows[i]).children().eq(1).children().val();
			if (dataJson != "")
				dataJson += "&";
			dataJson += key + "=" + value;
		}
		if (dataJson != "") {
			$("#saveForm").text(dataJson);
			$("#currentPageNo").text(1);
			$("#searchType").text("search");
			$("#currentPageSize").text(20);
			if (dataJson != "") {
				tosearch(dataJson, 1, 20);
			}
		}
	}
	;

};

function pageOperateAdd() {
	var type = $("#searchType").val();
	if (type == "search") {
		var dataJson = "";
		dataJson = $("#saveForm").val();
		var currentpageno = $("#currentPageNo").val();
		if (parseInt(currentpageno) * 20 >= parseInt($("#itemEnd").val())) {
			return;
		}
		;
		var nextpageno = parseInt(currentpageno) + 1;

		$("#currentPageNo").text(nextpageno);
		tosearch(dataJson, nextpageno, 20);
	}

	else if (type == "searchVague") {
		var dataJsonVague = "";
		dataJsonVague = $("#saveFormVague").val();
		var currentpageno = $("#currentPageNo").val();
		if (parseInt(currentpageno) * 20 >= parseInt($("#itemEnd").val())) {
			return;
		}
		;
		var nextpageno = parseInt(currentpageno) + 1;

		$("#currentPageNo").text(nextpageno);
		tosearchVague(dataJsonVague, nextpageno, 20);
	} else {
	}
};

function pageOperateDelete() {
	var type = $("#searchType").val();
	if (type == "search") {
		var dataJson = "";
		dataJson = $("#saveForm").val();
		var currentpageno = $("#currentPageNo").val();
		if (currentpageno == "1")
			return;
		var nextpageno = parseInt(currentpageno) - 1;
		debugger;
		$("#currentPageNo").text(nextpageno);
		tosearch(dataJson, nextpageno, 20);
	}

	else if (type == "searchVague") {
		var dataJsonVague = "";
		dataJsonVague = $("#saveFormVague").val();
		var currentpageno = $("#currentPageNo").val();
		if (currentpageno == "1")
			return;
		var nextpageno = parseInt(currentpageno) - 1;
		debugger;
		$("#currentPageNo").text(nextpageno);
		tosearchVague(dataJsonVague, nextpageno, 20);
	} else {
	}
};

function searchVague() {
	alert("search vague!");
	var dataJson = "";

	if ($('#searchPageInput').val() != "searchPage") {
		alert("11111111");
		dataJson = $("#searchInput").val();
		if (dataJson != "") {
			$("#saveFormVague").text(dataJson);
			$("#searchType").text("searchVague");
			debugger;
			document.SearchForm.action = 'searchResult.jsp';
			document.SearchForm.submit();
		} else {
			alert("error input");
		}
	} else {
		alert("22222222");
		dataJson = $("#searchInput").val();
		$("#saveFormVague").text(dataJson);
		$("#currentPageNo").text(1);
		$("#searchType").text("searchVague");
		$("#currentPageSize").text(20);
		if (dataJson != "") {
			tosearchVague(dataJson, 1, 20);
		}
	}
	;
}

function addRow(rowNum) {

	var nextrowNum = rowNum + 1;
	var rowId = "searchTbtr" + rowNum;
	var btntdId = rowId + "td3";
	var addbtnid = btntdId + "addbtn";
	var nextrowId = "searchTbtr" + nextrowNum;
	var nextbtntdId = nextrowId + "td3";
	var nextaddbtnid = nextbtntdId + "addbtn";
	var content = "<tr id="
			+ nextrowId
			+ "><td class='searchTb'><select class='form-control'><option value='smbid'>Entry Name</option><option value='proteinname'>Protein Name</option><option value='genename'>Gene Name</option><option value='genestatus'>Gene Status</option><option value='existence'>Protein Existence</option><option value='funcclassific'>Functional Classification</option><option value='originalorganism'>Original Organism</option><option value='taxonomicidentifier'>Taxonomy</option><option value='targetorganism'>Target Organism</option><option value='function'>Function</option><option value='catalyticactivity'>Catalytic Activity</option><option value='cofactor'>Cofactor</option><option value='pathway'>Pathway</option><option value='subcellloc'>Subcellular location</option><option value='interaction'>STRING</option><option value='structure'>PDB</option><option value='uniprot'>Uniprot</option><option value='ddbj'>DDBJ</option><option value='embl'>EMBL</option><option value='genebank'>GenBank</option><option value='refseq'>RefSeq</option><option value='kegg'>KEGG</option><option value='entry'>EC Entry</option><option value='enzymename'>Enzyme Name</option><option value='ecclass'>Ec Class</option><option value='sysname'>Enzyme Sysname</option><option value='substrate'>Substrate</option><option value='product'>Product</option></select></td><td class='searchTb'><input type='text' class='form-control' id='input1' placeholder=''></td><td id='"
			+ nextbtntdId
			+ "' class='searchTb'><button type='button' class='btn btn-primary btn-lg' aria-label='delete Column' onclick='deleteRow("
			+ nextrowNum
			+ ")'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button> <button type='button' class='btn btn-primary btn-lg' aria-label='add Column' onclick='addRow("
			+ nextrowNum
			+ ")' id="
			+ nextaddbtnid
			+ "><span class='glyphicon glyphicon-plus' aria-hidden='true'></span></button></td></tr>";
	$("#table1").append(content);

	$("#maxrowNum").text(nextrowNum);
	$("#" + addbtnid).hide();
};

function deleteRow(rowNum) {

	var lastrowNum = rowNum - 1;
	var rowId = "searchTbtr" + rowNum;
	var lastrowId = "searchTbtr" + lastrowNum;
	var lastbtntdId = lastrowId + "td3";
	var lastaddbtnid = lastbtntdId + "addbtn";

	$("#" + rowId).remove();
	debugger;
	while (true) {
		if (document.getElementById(lastaddbtnid)) {
			$("#" + lastaddbtnid).show();
			break;
		} else {

			lastrowNum = lastrowNum - 1;
			alert(lastrowNum);
			lastrowId = "searchTbtr" + lastrowNum;
			lastbtntdId = lastrowId + "td3";
			lastaddbtnid = lastbtntdId + "addbtn";
		}
	}

	if ($("table[id$='table1']>tbody").children("tr").length == 1) {
		$("#searchTbtr1td3addbtn").show();
	}
};

function tosearch(dataJson, pageNo, pageSize) {
	if (dataJson != "") {
		$("#searchInput").val(dataJson);
		dataJson += "&pageNo=" + pageNo + "&pageSize=" + pageSize;

		// $("#saveForm").text(JSON.stringify(datejson));
		$
				.ajax({
					url : 'module/search',
					data : dataJson,
					type : 'get',
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {

						debugger;
						var content;
						for (var i = 0; i < data['searchlist'].length; ++i) {
							content += "<tr><td   class='ctl'><a href='module/toModelResult?id="
									+ data['searchlist'][i]['0']
									+ "'>"
									+ data['searchlist'][i]['0']
									+ "</a></td><td   class='ctl'>"
									+ data['searchlist'][i]['1']
									+ "</td><td   class='ctl'>"
									+ data['searchlist'][i]['2']
									+ "</td><td   class='ctl'>"
									+ data['searchlist'][i]['3']
									+ "</td><td   class='ctl'>"
									+ data['searchlist'][i]['4']
									+ "</td><td   class='ctl'>"
									+ data['searchlist'][i]['5'] + "</td></tr>";
						}
						$("#itemFrom").text(
								($("#currentPageNo").val() - 1)
										* $("#currentPageSize").val() + 1);
						if (data['searchsum'] >= 20) {
							$("#itemEnd").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						} else {
							$("#itemEnd").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						}
						$("#itemSum").text(data['searchsum']);

						$("#itemFrom1").text(
								($("#currentPageNo").val() - 1)
										* $("#currentPageSize").val() + 1);
						if (data['searchsum'] >= 20) {
							$("#itemEnd1").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						} else {
							$("#itemEnd1").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						}
						$("#itemSum1").text(data['searchsum']);

						$("#resultTable tbody").empty();
						$("#resultTable").append(content);
					},
					error : function() {
						alert("error");
					}
				});
	}

}

function tosearchVague(dataJson, pageNo, pageSize) {
	if (dataJson != "") {
		$("#searchInput").val(dataJson);
		$
				.ajax({
					url : 'module/searchVague',
					data : {
						'key' : dataJson,
						'pageNo' : pageNo,
						'pageSize' : pageSize
					},
					type : 'get',
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {

						debugger;
						var content;
						for (var i = 0; i < data['searchlist'].length; ++i) {
							content += "<tr><td class='ctlID'><a href='module/toModelResult?id="
									+ data['searchlist'][i]['0']
									+ "'>"
									+ data['searchlist'][i]['0']
									+ "</a></td><td  class='ctl'>"
									+ data['searchlist'][i]['1']
									+ "</td><td  class='ctl'>"
									+ data['searchlist'][i]['2']
									+ "</td><td  class='ctl'>"
									+ data['searchlist'][i]['3']
									+ "</td><td  class='ctl'>"
									+ data['searchlist'][i]['4']
									+ "</td><td  class='ctl'>"
									+ data['searchlist'][i]['5'] + "</td></tr>";
						}
						$("#itemFrom").text(
								($("#currentPageNo").val() - 1)
										* $("#currentPageSize").val() + 1);
						if (data['searchsum'] >= 20) {
							$("#itemEnd").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						} else {
							$("#itemEnd").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						}
						$("#itemSum").text(data['searchsum']);

						$("#itemFrom1").text(
								($("#currentPageNo").val() - 1)
										* $("#currentPageSize").val() + 1);
						if (data['searchsum'] >= 20) {
							$("#itemEnd1").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						} else {
							$("#itemEnd1").text(
									($("#currentPageNo").val())
											* $("#currentPageSize").val());
						}
						$("#itemSum1").text(data['searchsum']);

						$("#resultTable tbody").empty();
						$("#resultTable").append(content);
					},
					error : function() {
						alert("error");
					}
				});
	}
}