package com.module.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.module.beans.ECEntity;
import com.module.beans.Modandec;
import com.module.beans.Module;
import com.module.beans.Test;
import com.module.service.ECEntityService;
import com.module.service.ModandecService;
import com.module.service.ModuleService;
import com.module.service.TestService;

@Controller
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService service;

	@Autowired
	private ModandecService modandecService;
	@Autowired
	private ECEntityService ecentityService;

	/**
	 * 查询 高级搜索
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("search")
	@ResponseBody
	public Map search(HttpServletRequest request, HttpServletResponse response) {
		// List list=service.selectByAttribute(module);
		// System.out.println(module.getProteinname());
		// System.out.println(list.size());
		// return list;
		String sql = "";
		String ss1 = request.getParameter("smbid") == null ? "" : request
				.getParameter("smbid");
		String ss2 = request.getParameter("proteinname") == null ? "" : request
				.getParameter("proteinname");
		String ss3 = request.getParameter("genename") == null ? "" : request
				.getParameter("genename");
		String ss4 = request.getParameter("genestatus") == null ? "" : request
				.getParameter("genestatus");
		String ss5 = request.getParameter("existence") == null ? "" : request
				.getParameter("existence");
		String ss6 = request.getParameter("funcclassific") == null ? ""
				: request.getParameter("funcclassific");
		String ss7 = request.getParameter("originalorganism") == null ? ""
				: request.getParameter("originalorganism");
		String ss8 = request.getParameter("targetorganism") == null ? ""
				: request.getParameter("targetorganism");
		String ss9 = request.getParameter("function") == null ? "" : request
				.getParameter("function");
		String ss10 = request.getParameter("catalyticactivity") == null ? ""
				: request.getParameter("catalyticactivity");
		String ss11 = request.getParameter("cofactor") == null ? "" : request
				.getParameter("cofactor");
		String ss12 = request.getParameter("pathway") == null ? "" : request
				.getParameter("pathway");
		String ss13 = request.getParameter("subcellloc") == null ? "" : request
				.getParameter("subcellloc");
		String ss14 = request.getParameter("interaction") == null ? ""
				: request.getParameter("interaction");
		String ss15 = request.getParameter("structure") == null ? "" : request
				.getParameter("structure");
		String ss16 = request.getParameter("uniprot") == null ? "" : request
				.getParameter("uniprot");
		String ss17 = request.getParameter("ddbj") == null ? "" : request
				.getParameter("ddbj");
		String ss18 = request.getParameter("embl") == null ? "" : request
				.getParameter("embl");
		String ss19 = request.getParameter("genebank") == null ? "" : request
				.getParameter("genebank");
		String ss20 = request.getParameter("refseq") == null ? "" : request
				.getParameter("refseq");
		String ss21 = request.getParameter("kegg") == null ? "" : request
				.getParameter("kegg");
		if (ss1 != "") {
			ss1 = "smbid like '%" + ss1 + "%'";
		} else {
			ss1 = "1=1";
		}
		if (ss2 != "") {
			ss2 = " and proteinname like '%" + ss2 + "%'";
		} else {
			ss2 = "";
		}
		if (ss3 != "") {
			ss3 = " and genename like '%" + ss3 + "%'";
		} else {
			ss3 = "";
		}
		if (ss4 != "") {
			ss4 = " and genestatus like '%" + ss4 + "%'";
		} else {
			ss4 = "";
		}
		if (ss5 != "") {
			ss5 = " and existence like '%" + ss5 + "%'";
		} else {
			ss5 = "";
		}
		if (ss6 != "") {
			ss6 = " and funcclassific like '%" + ss6 + "%'";
		} else {
			ss6 = "";
		}
		if (ss7 != "") {
			ss7 = " and originalorganism like '%" + ss7 + "%'";
		} else {
			ss7 = "";
		}
		if (ss8 != "") {
			ss8 = " and targetorganism like '%" + ss8 + "%'";
		} else {
			ss8 = "";
		}
		if (ss9 != "") {
			ss9 = " and function like '%" + ss9 + "%'";
		} else {
			ss9 = "";
		}
		if (ss10 != "") {
			ss10 = " and catalyticactivity like '%" + ss10 + "%'";
		} else {
			ss10 = "";
		}
		if (ss11 != "") {
			ss11 = " and cofactor like '%" + ss11 + "%'";
		} else {
			ss11 = "";
		}
		if (ss12 != "") {
			ss12 = " and pathway like '%" + ss12 + "%'";
		} else {
			ss12 = "";
		}
		if (ss13 != "") {
			ss13 = " and subcellloc like '%" + ss13 + "%'";
		} else {
			ss13 = "";
		}
		if (ss14 != "") {
			ss14 = " and interaction like '%" + ss14 + "%'";
		} else {
			ss14 = "";
		}
		if (ss15 != "") {
			ss15 = " and structure like '%" + ss15 + "%'";
		} else {
			ss15 = "";
		}
		if (ss16 != "") {
			ss16 = " and uniprot like '%" + ss16 + "%'";
		} else {
			ss16 = "";
		}
		if (ss17 != "") {
			ss17 = " and ddbj like '%" + ss17 + "%'";
		} else {
			ss17 = "";
		}
		if (ss18 != "") {
			ss18 = " and embl like '%" + ss18 + "%'";
		} else {
			ss18 = "";
		}
		if (ss19 != "") {
			ss19 = " and genebank like '%" + ss19 + "%'";
		} else {
			ss19 = "";
		}
		if (ss20 != "") {
			ss20 = " and refseq like '%" + ss20 + "%'";
		} else {
			ss20 = "";
		}
		if (ss21 != "") {
			ss21 = " and kegg like '%" + ss21 + "%'";
		} else {
			ss21 = "";
		}

		sql = ss1 + ss2 + ss3 + ss4 + ss5 + ss6 + ss7 + ss8 + ss9 + ss10 + ss11
				+ ss12 + ss13 + ss14 + ss15 + ss16 + ss17 + ss18 + ss19 + ss20
				+ ss21;
		;
		String entry = request.getParameter("entry");
		String enzymename = request.getParameter("kegg");
		String ecclass = request.getParameter("ecclass");
		String sysname = request.getParameter("sysname");
		String substrate = request.getParameter("sysname");
		String product = request.getParameter("product");
		System.out.println(sql);
		int pN = Integer.valueOf(request.getParameter("pageNo"));
		int pS = Integer.valueOf(request.getParameter("pageSize"));
		List list = service.selectBySql(sql, pN, pS);
		int sum = service.search_SQL_Count(sql);
		Map model = new HashMap();
		model.put("searchlist", list);
		model.put("searchsum", sum);
		return model;
	}

	/**
	 * 模糊搜索
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("searchVague")
	@ResponseBody
	public Map searchVague(HttpServletRequest request,
			HttpServletResponse response) {
		Map model = new HashMap();
		System.out.println(request.getParameter("key"));
		String key = request.getParameter("key");
		int pN = Integer.valueOf(request.getParameter("pageNo"));
		int pS = Integer.valueOf(request.getParameter("pageSize"));
		List list = service.search_Vague(key, pN, pS);
		int sum = service.search_Vague_Count(key);
		model.put("searchlist", list);
		model.put("searchsum", sum);
		return model;
	}

	/**
	 * 根据id查询信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("searchById")
	@ResponseBody
	public Map searchById(@RequestParam String id, HttpServletRequest request,
			HttpServletResponse response) {

		Map model = new HashMap();
		Module module = service.selectById(id);
		List<ECEntity> ecList = new ArrayList<ECEntity>();
		List<Modandec> modList = modandecService.selectByModuleId(id);
		if (modList != null && !modList.isEmpty()) {
			int size = modList.size();
			for (int i = 0; i < size; i++) {
				ECEntity entity = ecentityService.selectById(modList.get(i)
						.getEcentry());
				ecList.add(entity);
			}
		}
		System.out.println(module.getProteinname());
		model.put("module", module);
		model.put("ecList", ecList);
		return model;
	}

	@RequestMapping("toModelResult")
	@ResponseBody
	public ModelAndView toModelResult(@RequestParam String id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		// System.out.println(JSONObject.fromObject(model).toString());
		mav.addObject("id", id);
		mav.setViewName("moduleResult");
		return mav;
	}

	/**
	 * 根据给定的id下载excel文件
	 * @param request
	 * @param response
	 */
	@RequestMapping("downloadExcelById")
	@ResponseBody
	public void downloadExcelById(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("idDownload");
		HSSFWorkbook workbook = service.getExcelById(id);
		if (workbook != null) {
			OutputStream out;
			try {
				out = response.getOutputStream();
				String filename = id + ".xls";
				response.setHeader(
						"Content-disposition",
						"attachment;filename="
								+ URLEncoder.encode(filename, "UTF-8"));
				response.setContentType("application/msexcel;charset=UTF-8");
				workbook.write(out);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 根据给定的id下载pdf文件
	 * @param request
	 * @param response
	 */
	@RequestMapping("downloadPdfById")
	@ResponseBody
	public void downloadPdfById(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("idDownload");
		Module module = service.selectById(id);
		if (module != null) {
			OutputStream out;
			try {
				out = response.getOutputStream();
				String filename = id + ".pdf";
				response.setHeader(
						"Content-disposition", 
						"attachment; filename=" 
								+ URLEncoder.encode(filename, "UTF-8"));
				response.setContentType("application/pdf;charset=UTF-8");
				Document doc = new Document(PageSize.A4);
				PdfWriter.getInstance(doc, out);
				
				doc.open();
				// 加入文字“Hello World”
				try {
					doc.add(new Paragraph("Protein Name:    "+module.getProteinname()));
					doc.add(new Paragraph("Gene Name:    "+module.getGenename()));
					doc.add(new Paragraph("Funcction Classification:    "+module.getFuncclassific()));
					doc.add(new Paragraph("Original Organism:    "+module.getOriginalorganism()));
					doc.add(new Paragraph("Target Organism:    "+module.getTargetorganism()));
					doc.add(new Paragraph("Protein Sequence:    "+module.getProteinsequence()));
					doc.add(new Paragraph("Function:    "+module.getFunction()));
					doc.add(new Paragraph("DNA Sequence:    "+module.getDnasequence()));
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 关闭文档对象，释放资源
				doc.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
