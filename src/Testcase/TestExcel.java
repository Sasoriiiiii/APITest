package Testcase;

import java.io.IOException;

import Utils.ReadExcelCase;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Testcase.TestExcel.java
 * @ClassName:    TestExcel
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��18�� ����3:38:41
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��18�� ����3:38:41 
 * @UpdateRemark: ˵�������޸�����  
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
