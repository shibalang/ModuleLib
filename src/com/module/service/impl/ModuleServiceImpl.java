package com.module.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.module.beans.Module;
import com.module.beans.Test;
import com.module.dao.ModuleDao;
import com.module.dao.TestDao;
import com.module.service.ModuleService;
import com.module.service.TestService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;

	@Override
	public boolean addModule(Module module) {
		// TODO addModule
		return false;
	}

	@Override
	public List<Module> selectByAttribute(Module module) {

		return moduleDao.selectByAttribute(module);
	}

	@Override
	public List<Module> selectAll() {
		// TODO select All
		return null;
	}

	@Override
	public Module selectById(String idString) {
		int id = Integer.valueOf(idString);
		Module module = moduleDao.selectById(id);
		if (module != null) {
			if (module.getProteinsequence() != null
					&& !"".equals(module.getProteinsequence())) {
				String proseq = module.getProteinsequence();
				String newseq = proseq.replaceAll("\n", "");
				newseq = newseq.replaceAll("\r", "");
				String newSeqTemp = "";
				for (int i = 0; i < newseq.length(); ++i) {
					newSeqTemp += newseq.charAt(i);
					if ((i != 0) && (i % 80 == 0)) {
						newSeqTemp += "\n";
					}
					;
				}

				module.setProteinsequence(newSeqTemp);

			}
			if (module.getDnasequence() != null
					&& !"".equals(module.getDnasequence())) {
				String proseq = module.getDnasequence();
				String newseq = proseq.replaceAll("\n", "");
				newseq = newseq.replaceAll("\r", "");
				String newSeqTemp = "";
				for (int i = 0; i < newseq.length(); ++i) {
					newSeqTemp += newseq.charAt(i);
					if ((i != 0) && (i % 80 == 0)) {
						newSeqTemp += "\n";
					}
					;
				}

				module.setDnasequence(newSeqTemp);
			}

		}
		return module;
	}

	@Override
	public List selectBySql(String sql, int pN, int pS) {
		return moduleDao.selectBysql(sql, pN, pS);
	}

	@Override
	public List search_Vague(String key, int pN, int pS) {
		List list = new ArrayList();
		list.addAll(moduleDao.selectByProteinname(key, pN, pS));
		return list;
	}

	@Override
	public int search_Vague_Count(String key) {

		return moduleDao.selectCountByProteinname(key);
	}

	@Override
	public int search_SQL_Count(String sql) {
		return moduleDao.selectCountBySql(sql);
	}

	@Override
	public HSSFWorkbook getExcelById(String idString) {
		int id = Integer.valueOf(idString);
		Module module = moduleDao.selectById(id);
		if (module != null) {
			HSSFWorkbook wb = new HSSFWorkbook();
			String name = "sheet1";
			HSSFSheet sheet = wb.createSheet(name);

			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell((short) 0);
			cell.setCellValue(module.getProteinname());
			cell = row.createCell((short) 1);
			cell.setCellValue(module.getGenename());
			cell = row.createCell((short) 2);
			cell.setCellValue(module.getFuncclassific());
			cell = row.createCell((short) 3);
			cell.setCellValue(module.getOriginalorganism());
			cell = row.createCell((short) 4);
			cell.setCellValue(module.getTargetorganism());
			cell = row.createCell((short) 5);
			cell.setCellValue(module.getProteinsequence());
			cell = row.createCell((short) 6);
			cell.setCellValue(module.getFunction());
			cell = row.createCell((short) 7);
			cell.setCellValue(module.getDnasequence());
			return wb;
		} else
			return null;
	}

	@Override
	public Document getPdfById(String idString) {
		int id = Integer.valueOf(idString);
		Module module = moduleDao.selectById(id);
		if(module!=null)
		{
			Document doc = new Document(PageSize.A4);
			doc.open();
			// 加入文字“Hello World”
			try {
				doc.add(new Paragraph("HelloWorld"));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 关闭文档对象，释放资源
			doc.close();
			return doc;
		}
		else
			return null;
	}

}
