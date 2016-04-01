package Testcase;

import java.io.IOException;

import Utils.ReadExcelCase;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Testcase.TestExcel.java
 * @ClassName:    TestExcel
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月18日 下午3:38:41
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月18日 下午3:38:41 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class TestExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[][] a1=ReadExcelCase.getTestMap("userLogin");
		  for(int i=0;i<a1.length;i++){
			   for(int j=0;j<a1[i].length;j++){
			    System.out.print(a1[i][j]+"  ");    
			   }
			   System.out.println();
			  }
	}

}
