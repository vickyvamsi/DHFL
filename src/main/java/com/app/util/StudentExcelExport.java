package com.app.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Student;

public class StudentExcelExport extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workBook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		res.setHeader("Content-Disposition", "attachment;filename=Student.xlsx");
		List<Student> stds=(List<Student>) model.get("stds");
		
		Sheet sheet=workBook.createSheet();
		setHead(sheet);
		setBody(sheet,stds);
	}

	private void setHead(Sheet sheet) {
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("NAME");
				row.createCell(2).setCellValue("EMAIL");
				row.createCell(3).setCellValue("PH NUMBER");
				row.createCell(4).setCellValue("BRANCH");
				row.createCell(5).setCellValue("COURCE");
				row.createCell(6).setCellValue("ADDRESS");
				row.createCell(7).setCellValue("GENDER");
	}
	
	private void setBody(Sheet sheet,List<Student> stds) {
		int rowCount=1;
		for(Student s:stds) {
						Row row=sheet.createRow(rowCount++);
						row.createCell(0).setCellValue(s.getStdId());
						row.createCell(1).setCellValue(s.getStdName());
						row.createCell(2).setCellValue(s.getStdEmail());
						row.createCell(3).setCellValue(s.getStdPhNum());
						row.createCell(4).setCellValue(s.getStdBranch());
						row.createCell(5).setCellValue(s.getStdCourse());
						row.createCell(6).setCellValue(s.getStdAddr());
						row.createCell(7).setCellValue(s.getStdGen());
						
		}
	}
	
}
