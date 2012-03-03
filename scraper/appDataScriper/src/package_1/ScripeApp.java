package package_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.json.*;

;

public class ScripeApp {

	private String name;
	private String id;
	private String URL;
	private FileOutputStream appsFile;
	private static Writer bufferWriter;

	public ScripeApp() {
		try {
			appsFile = new FileOutputStream("AppsData.csv");
			bufferWriter = new BufferedWriter(new OutputStreamWriter(appsFile,"UTF8"));
			bufferWriter.write("Name,ID,URL");
			bufferWriter.append("\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scripe(String appData) {

		JSONObject newObject;
		JSONObject secondJSONObject;
		try {

			int i = 0;
			int totalResults;
			newObject = new JSONObject(appData);
			JSONArray msg = (JSONArray) newObject.get("results");
			totalResults = (int) newObject.getInt("resultCount");
			while (i < totalResults) {

				secondJSONObject = (JSONObject) msg.get(i);
				name = secondJSONObject.get("trackName").toString();
				URL = secondJSONObject.get("trackViewUrl").toString();
				id = secondJSONObject.get("trackId").toString();
				bufferWriter.append(name + "," + id + "," + URL);
				bufferWriter.append("\r\n");
				i++;
			}
			bufferWriter.close();

			System.out.println("\nResults are :" + totalResults);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void openSavedData() {
		System.out.println("Name= " + name + " ID= " + id + " URL= " + URL);
		if (new File("AppsData.csv").exists()) {
			Process p;
			/*try {
				p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler AppsData.csv");
				p.waitFor();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/
		} else {

			System.out.println("File is not exists");

		}

	}

}