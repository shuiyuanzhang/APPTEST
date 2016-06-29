package startApp;

public class StartAPP {
	public static void start() throws Throwable {
		try {
			Runtime.getRuntime().exec("adb shell am start -n "+ getParameter.GetActivityName.getActivityName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
