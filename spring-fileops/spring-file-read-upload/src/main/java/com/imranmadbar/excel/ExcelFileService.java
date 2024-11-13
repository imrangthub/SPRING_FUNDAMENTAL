package com.imranmadbar.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.imranmadbar.Course;
import com.imranmadbar.Employee;
import com.imranmadbar.ProductData;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;;

@Service
@RequiredArgsConstructor
public class ExcelFileService {

	private static final Logger logger = LoggerFactory.getLogger(ExcelFileService.class);

	/**
	 * You must create "demo.xlsx" before testing this API And enter some data
	 * inside the file with 4 columns
	 */
	private static final String CSV_FILE_LOCATION = "/home/bs960/imranMadbar/myPROJECT/SPRING_FUNDAMENTAL/spring-fileops/required-file/CourseData.xlsx";


	public List<Course> readExcelFileTwo() {

		List<Course> courses = new ArrayList<>();

		Workbook workbook = null;
		try {
			// Creating a Workbook from an Excel file (.xls or .xlsx)
			workbook = WorkbookFactory.create(new File(CSV_FILE_LOCATION));

			// Retrieving the number of sheets in the Workbook
			logger.info("Number of sheets: " + workbook.getNumberOfSheets());

			// Print all sheets name
			workbook.forEach(sheet -> {
				logger.info("Title of sheet => " + sheet.getSheetName());

				// Create a DataFormatter to format and get each cell's value as String
				DataFormatter dataFormatter = new DataFormatter();

				// Loop through all rows and columns and create Course object
				int index = 0;
				for (Row row : sheet) {
					if (index++ == 0)
						continue;
					Course course = new Course();

					if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.NUMERIC) {
						course.setId((int) row.getCell(0).getNumericCellValue());
					}

					if (row.getCell(1) != null) {
						course.setName(dataFormatter.formatCellValue(row.getCell(1)));
					}

					if (row.getCell(2) != null && row.getCell(2).getCellType() == CellType.NUMERIC) {
						course.setNumber((int) row.getCell(2).getNumericCellValue());
					}
					System.out.println(course.toString());
					courses.add(course);
				}
			});
		} catch (EncryptedDocumentException | IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

		return courses;
	}

	public void generateExcel(HttpServletResponse response) throws Exception {

		List<Employee> employees = this.getEmpList();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Employees Info");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID employee");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("Last Name");
		row.createCell(3).setCellValue("Started Date");

		// Create date cell style
		HSSFCellStyle dateCellStyle = workbook.createCellStyle();
		HSSFDataFormat dateFormat = workbook.createDataFormat();
		// dateCellStyle.setDataFormat(dateFormat.getFormat("yyyy-mm-dd"));
		dateCellStyle.setDataFormat(dateFormat.getFormat("dd-mm-yyyy"));

		int dataRowIndex = 1;

		for (Employee employee : employees) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(employee.getEmployeeId());
			dataRow.createCell(1).setCellValue(employee.getFirstName());
			dataRow.createCell(2).setCellValue(employee.getLastName());

			// Set the date value with the date format style
			if (employee.getStartedDateInCompany() != null) {
				HSSFCell dateCell = dataRow.createCell(3);
				dateCell.setCellValue(Date.valueOf(employee.getStartedDateInCompany()));
				dateCell.setCellStyle(dateCellStyle);
			}

			dataRowIndex++;
		}

		// Auto-size columns
		for (int i = 0; i < 4; i++) {
			sheet.autoSizeColumn(i);
		}

		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();

	}
	
	
    

	public List<Employee> getEmpList() {
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1L, "John", "Doe", LocalDate.of(2018, 5, 10)));
		employees.add(new Employee(2L, "Jane", "Smith", LocalDate.of(2019, 6, 15)));
		employees.add(new Employee(3L, "Mike", "Johnson", LocalDate.of(2020, 7, 20)));
		employees.add(new Employee(4L, "Emily", "Davis", LocalDate.of(2021, 8, 25)));
		employees.add(new Employee(5L, "David", "Brown", LocalDate.of(2022, 9, 30)));

		return employees;

	}

	public List<Course> getCourse() {
		List<Course> courses = new ArrayList<>();

		courses.add(new Course(101, "Mathematics", 30));
		courses.add(new Course(102, "Physics", 25));
		courses.add(new Course(103, "Chemistry", 20));
		courses.add(new Course(104, "Biology", 35));
		courses.add(new Course(105, "Computer Science", 40));

		return courses;

	}

}
