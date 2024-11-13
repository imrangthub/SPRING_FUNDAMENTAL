package com.imranmadbar.excel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.imranmadbar.ProductData;


@Service
public class SBSnapshotService {
	
    private static final int SHEET_INITIAL_INDEX = 0;
    private static final int HEADER_ROW_INDEX = 0;
    private static final int PRODUCT_CODE_INDEX = 0;
    private static final int DESCRIPTION_INDEX = 1;
    private static final int ACTIVE_FLAG_INDEX = 2;
    private static final int PARTNER_INDEX = 3;
    private static final int PARTNER_CODE_INDEX = 4;
    private static final int DATA_ROW_INITIAL_INDEX = 1;
    private static final int COLUMN_SIZE = 5;
    
    

    public String readExcel(MultipartFile file) throws IOException {
        List<ProductData> products = new ArrayList();
        if(file==null || file.isEmpty()) {
        	return "No file foud !";
        }
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
 
        this.validateFileTemplate(sheet);

        for(int i = 1; i <= sheet.getLastRowNum(); ++i) {
            Row row = sheet.getRow(i);
            if (row != null) {
                ProductData productData = new ProductData();
                productData.setProductCode(this.getCellValueAsString(row, 0));
                productData.setDescription(this.getCellValueAsString(row, 1));
                productData.setActive(Boolean.TRUE.equals(this.getCellValueAsBoolean(row, 2)));
                productData.setPartnerName(this.getCellValueAsString(row, 3));
                productData.setPartnerProductCode(this.getCellValueAsString(row, 4));
                products.add(productData);
            }
        }

        workbook.close();
        System.out.println("DataList: "+products.toString());
        return products.toString();
    }

    private void validateFileTemplate(Sheet sheet) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new FileValidationException("Header row is missing.");
        } else {
            int columnCount = headerRow.getPhysicalNumberOfCells();
            if (columnCount == 5) {
                if (!this.getCellValueAsString(headerRow, 0).equalsIgnoreCase("Product ID")) {
                    throw new FileValidationException("Invalid first column header. Expected: Product ID");
                } else if (!this.getCellValueAsString(headerRow, 1).equalsIgnoreCase("Description")) {
                    throw new FileValidationException("Invalid second column header. Expected: Description");
                } else if (!this.getCellValueAsString(headerRow, 2).equals("isActive")) {
                    throw new FileValidationException("Invalid third column header. Expected: isActive");
                } else if (!this.getCellValueAsString(headerRow, 3).equalsIgnoreCase("My Partner")) {
                    throw new FileValidationException("Invalid fourth column header. Expected: My Partner");
                } else if (!this.getCellValueAsString(headerRow, 4).equalsIgnoreCase("Code")) {
                    throw new FileValidationException("Invalid fifth column header. Code");
                }
            } else {
                throw new FileValidationException("Column Size cannot exceed  length of 5.");
            }
        }
    }

    private String getCellValueAsString(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            return "";
        } else {
            switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                double numericValue = cell.getNumericCellValue();
                return numericValue == Math.floor(numericValue) ? String.valueOf((long)numericValue) : BigDecimal.valueOf(numericValue).toPlainString();
            default:
                return "";
            }
        }
    }

    private Boolean getCellValueAsBoolean(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell != null) {
            if (cell.getCellType() == CellType.BOOLEAN) {
                return cell.getBooleanCellValue();
            }

            if (cell.getCellType() == CellType.NUMERIC) {
                return cell.getNumericCellValue() == 1.0D;
            }
        }

        return Boolean.FALSE;
    }

    
    

}
