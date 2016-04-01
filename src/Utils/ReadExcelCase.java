package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.ReadExcelCase.java
 * @ClassName:    ReadExcelCase
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月18日 下午1:55:53
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月18日 下午1:55:53 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class ReadExcelCase {
	

	
	public static String[][] getTestMap(String APIname) throws IOException{
		String path = "E:/Users/Administrator/workspace/APITest/testData/API测试用例.xlsx";
	
		File f1 = new File(path);
		FileInputStream in = new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheetAt(0);
		Row header = sheet.getRow(0);
		int testCounts=0;
		for(int rownum = 0; rownum <= sheet.getLastRowNum(); rownum++){
			Row row = sheet.getRow(rownum);
			Cell apiNameCell=row.getCell(1);
			if(apiNameCell.getRichStringCellValue().getString().equals(APIname)){
				testCounts++;
			}
		}
		String[][] testMap=new String[testCounts][header.getLastCellNum()];

			String value;
			int casenum=0;
			for(int rownum = 0; rownum <= sheet.getLastRowNum(); rownum++){
				Row row = sheet.getRow(rownum);
				Cell apiNameCell=row.getCell(1);

				if(apiNameCell.getRichStringCellValue().getString().equals(APIname)){
					
					casenum++;
//					System.out.println(casenum);
					  for (int cellnum = 0; cellnum <= row.getLastCellNum(); cellnum++) {
							Cell cell = row.getCell(cellnum);
							if (cell == null) {
								continue;
							} else {
								value = "";
							}
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								value = cell.getRichStringCellValue().getString();
//								System.out.println("String======================"+value);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if (DateUtil.isCellDateFormatted(cell)) {
									value = cell.getDateCellValue().toString();
									
								} else {
									value = Double.toString((int) cell.getNumericCellValue());
//									System.out.println("Double======================"+value);
								}
								break;
							case Cell.CELL_TYPE_BOOLEAN:
								value = Boolean.toString(cell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA:
								value = cell.getCellFormula().toLowerCase();
//								System.out.println("Formula======================"+value);
								break;
							default:
								value = " ";
//								System.out.println();
								break;
							}
							testMap[casenum-1][cellnum] = value;
//							System.out.println("============"+value);
						  }
				}else{
					continue;
				}


		}

		in.close();
		wb.close();
		
		return testMap;
	}

}
