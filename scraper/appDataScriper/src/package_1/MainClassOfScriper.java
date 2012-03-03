package package_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

public class MainClassOfScriper {

	private static String unscripedAppData = "";
	private String name_2;

	public void search(String name) {

		String urlPart_1 = "http://itunes.apple.com/search?term=";
		String urlPart_2 = "&country=us&entity=software";
		name_2 = name;
		//The Valley Hospital Physician Database

		try {
			URL requestURL = new URL(urlPart_1 + name_2 + urlPart_2);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					requestURL.openStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {

				unscripedAppData += inputLine;
			}
			System.out.println(unscripedAppData);
			System.out.println("\u1000");

			// in.close();
			ScripeApp app = new ScripeApp();
			app.scripe(unscripedAppData);
			app.openSavedData();
		}catch (ConnectException ex) {
			System.out.println("Connection is time out");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
