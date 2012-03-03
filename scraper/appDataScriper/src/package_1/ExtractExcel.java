package package_1;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ExtractExcel {

	private String name = "C:\\ModernETh\\apps_name.txt";
	private FileReader myFile;
	private MainClassOfScriper startEr = new MainClassOfScriper();
	
	public void readNames() {
		
		try {
			myFile = new FileReader(name);
			BufferedReader in = new BufferedReader(myFile);
			String readedLine;

			while ((readedLine = in.readLine()) != null) {

				
				System.out.println(readedLine);
				startEr.search(readedLine);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("here  nnd");
		}
	}
	public static void main(String[] args) {
		ExtractExcel t = new ExtractExcel();
		t.readNames();
	}

}
