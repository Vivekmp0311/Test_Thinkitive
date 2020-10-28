package TestCases.ThinkitiveTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Assignment_1 {

	public static void main(String[] args) throws IOException {

		Assignment_1 obj = new Assignment_1();
		try  
		{  
			File file=new File("C:\\Users\\Vivek\\eclipse-workspace\\ThinkitiveTest\\src\\main\\java\\TestCases\\ThinkitiveTest\\dataset.txt");    //creates a new file instance  
			FileReader fr=new FileReader(file);   
			BufferedReader br=new BufferedReader(fr);  
			String line;  
			int row=0;
			List<Integer[]> resultArray = new ArrayList<Integer[]>();
			while((line=br.readLine())!=null)  
			{  
				obj.multiply(line, 5, row, resultArray);
				row++;
			}  
			fr.close();      
			obj.write(resultArray); 
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  
	}  
	
	private void multiply(String line, int factor, int row, List<Integer[]> resultArray) {
		StringTokenizer strTokenObj = new StringTokenizer(line, "|");
		List<Integer> rowResultArray = new ArrayList<Integer>();
		while (strTokenObj.hasMoreTokens()) {
			Integer numObj = Integer.parseInt(strTokenObj.nextToken());
			int result = numObj.intValue() * factor;
			rowResultArray.add(result);
		}
		Integer[] rowResult = new Integer[rowResultArray.size()];
		rowResult = rowResultArray.toArray(rowResult);
		resultArray.add(rowResult);
	}
	
	private void write(List<Integer[]> resultArray) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("C:\\Users\\Vivek\\eclipse-workspace\\ThinkitiveTest\\src\\main\\java\\TestCases\\ThinkitiveTest\\result.txt");
			for (int i = 0; i < resultArray.size(); i++) {
				for (int j = 0; j < resultArray.get(i).length; j++) {
					if (j+1 < resultArray.get(i).length) {
						writer.write(resultArray.get(i)[j]+"|");
					} else {
						writer.write(resultArray.get(i)[j]+"");
					}
				}
				writer.write("\n");
			}
			System.out.println("result.txt file created successfully !!");
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}


}
