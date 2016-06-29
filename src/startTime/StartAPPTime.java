package startTime;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StartAPPTime {
	public static Integer gettime () throws Throwable {
		Process time;
		try {
			time = Runtime.getRuntime().exec("adb shell am start -W "+getParameter.GetActivityName.getActivityName());
			thearSleep.ThearSleep.sleep(1000);
			InputStream inputStream=time.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String aString = null;
			while ((aString=reader.readLine())!=null) {
				if (aString.contains("TotalTime")) {
					return Integer.parseInt(aString.split(":")[1].trim());
				}
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
