package getParameter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * 开启应用后，获取当前应用的activity名
 * 
 * Created on 2016/06/06
 * 
 * @author Main.z
 *
 */ 
public class GetActivityName {
	public static String getActivityName() throws Throwable {
		Process aProcess =Runtime.getRuntime().exec("adb shell dumpsys package tran.com.android.taplaota");
		InputStream in = aProcess.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String ActivityName=null;
		while ((ActivityName= br.readLine())!=null) {
			if (ActivityName.endsWith("Activity")){
				String aString= ActivityName.trim().split(" ")[1];
				return aString;
			}
		}
		br.close();
		return null;	
	}
}
