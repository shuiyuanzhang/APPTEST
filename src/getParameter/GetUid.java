package getParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetUid {
	/**
	 * ͨ��PIDȥ��ȡUId
	 * 
	 * Created on 2016/06/06
	 * 
	 * @author Main.z
	 * @throws Throwable 
	 *
	 */   
	public static String getAPPUid() throws Throwable {
		Process getUidcmd = Runtime.getRuntime().exec("adb shell cat /proc/"+getParameter.GetPid.getAPPPid()+"/status");
		InputStream in = getUidcmd.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String getuid=null;
		try {

			String uid = null;
			while ((uid = br.readLine()) !=null) {
				//�ж����С�Uid���������
				if (uid.contains("Uid")) {
					getuid=uid.split(":")[1].substring(1, 5);	
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
		return getuid;


	}
}
