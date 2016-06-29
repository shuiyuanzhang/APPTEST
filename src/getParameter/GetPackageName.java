package getParameter;

public class GetPackageName {
	
	public static String getPackageName() throws Throwable {
		String packname = getParameter.GetActivityName.getActivityName().split("/")[0];
		return packname;
		
	}
}
