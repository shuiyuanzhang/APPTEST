package clearChace;

import java.io.IOException;

public class Clearpackage {
	public static void cleanAPP() throws Throwable{
		try {
			Runtime.getRuntime().exec("adb shell pm clear "+ getParameter.GetPackageName.getPackageName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
