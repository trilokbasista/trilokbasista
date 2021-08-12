//package eBIS.Configuration;
//
//import java.io.IOException;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//public class InterceptorHandler implements HandlerInterceptor {
//	private XSSFWorkbook workbook;
//    private XSSFSheet sheet;
//    
//	@Override
//	   public boolean preHandle(
//	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//	      System.out.println("preHandle");
//	      request.getRequestURL();
//	      System.out.println(request.getRequestURL());
//	      writeHeaderLine();
//	      
//	      return true;
//	   }
//	   @Override
//	   public void postHandle(
//	      HttpServletRequest request, HttpServletResponse response, Object handler, 
//	      ModelAndView modelAndView) throws Exception {
//		   //System.out.println("postHandle");
//	   }
//	   
//	   @Override
//	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
//	      Object handler, Exception exception) throws Exception {
//		   //System.out.println("afterCompletion");
//	   }
//	   private void writeHeaderLine() {
//	        sheet = workbook.createSheet("URL");
//	         
//	        Row row = sheet.createRow(0);
//	         
//	        CellStyle style = workbook.createCellStyle();
//	        XSSFFont font = workbook.createFont();
//	        font.setBold(true);
//	        font.setFontHeight(16);
//	        style.setFont(font);
//	        createCell(row, 0, "URL", style);      
//	        createCell(row, 1, "Date", style);       	         
//	    }
//	   public void export(HttpServletResponse response) throws IOException {
//	        writeHeaderLine();
////	        writeDataLines();
//
//	        ServletOutputStream outputStream = response.getOutputStream();
//	        workbook.write(outputStream);
//	        workbook.close();
//	       // workbook.
//	        outputStream.close();
//	         
//	    }
////	   private void writeDataLines() {
////	        int rowCount = 1;
////	 
////	        CellStyle style = workbook.createCellStyle();
////	        XSSFFont font = workbook.createFont();
////	        font.setFontHeight(14);
////	        style.setFont(font);
////	                 
////	        for (User user : listUsers) {
////	            Row row = sheet.createRow(rowCount++);
////	            int columnCount = 0;
////	             
////	            createCell(row, columnCount++, user.getId(), style);
////	            createCell(row, columnCount++, user.getEmail(), style);
////	            createCell(row, columnCount++, user.getFullName(), style);
////	            createCell(row, columnCount++, user.getRoles().toString(), style);
////	            createCell(row, columnCount++, user.isEnabled(), style);
////	             
////	        }
////	    }
//	   private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//	        sheet.autoSizeColumn(columnCount);
//	        Cell cell = row.createCell(columnCount);
//	        if (value instanceof Integer) {
//	            cell.setCellValue((Integer) value);
//	        } else if (value instanceof Boolean) {
//	            cell.setCellValue((Boolean) value);
//	        }else {
//	            cell.setCellValue((String) value);
//	        }
//	        cell.setCellStyle(style);
//	    }
//}
