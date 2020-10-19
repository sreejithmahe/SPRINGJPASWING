package com.example.dataJpa.config.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.dataJpa.config.entity.ProcessAudit;

public class AuditDataService {

	public void getData(String dbHost, String dbPort, String username, String password, String schema,
			String excelFilePath) throws Exception {
		run(excelFilePath);

	}

	public void run(String excelFilePath)
			throws Exception {
		ProcessAuditService processAuditService = new ProcessAuditService();

		try {
 	        Long processAuditsCount = processAuditService.getProcessAuditsCount();
			JDialog.setDefaultLookAndFeelDecorated(true);
			int response = JOptionPane.showConfirmDialog(null,
					"Total records found " + processAuditsCount + ", Do you want to save records ?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.NO_OPTION) {
				System.out.println("No button clicked");
			} else if (response == JOptionPane.YES_OPTION) {
				
				
				List<ProcessAudit> processAudits = processAuditService.getProcessAudits();
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet process = workbook.createSheet("process");
				XSSFSheet task = workbook.createSheet("task");
				writeProcessAuditHeaderLine(process);
				int rownum = 1;
				for (ProcessAudit processAudit : processAudits) {
					Row row = process.createRow(rownum++);
					createList(processAudit, row);
				}
				FileOutputStream out = new FileOutputStream(new File(excelFilePath));
				workbook.write(out);
				out.close();
				
				
			} else if (response == JOptionPane.CLOSED_OPTION) {
				System.out.println("JOptionPane closed");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createList(ProcessAudit processAudit, Row row) {
		Cell cell = row.createCell(0);
		cell.setCellValue(processAudit.getTenantName());
		cell = row.createCell(1);
		cell.setCellValue(processAudit.getEventType());
	}

	private void writeProcessAuditHeaderLine(XSSFSheet sheet) {
		Row headerRow = sheet.createRow(0);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("tenant_name");
		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("event_type");
	}
	

	
}
