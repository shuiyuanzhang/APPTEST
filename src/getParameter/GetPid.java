package getParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetPid {
	/**
	 * ͨ������ȥ��ȡPID
	 * 
	 * Created on 2016/06/06
	 * 
	 * @author Main.z
	 * @throws Throwable 
	 *
	 */  
	public static String getAPPPid() throws Throwable {
		try {
			
			Process getAPPcmd = Runtime.getRuntime().exec("adb shell ps |grep tran.com.android.taplaota");
			InputStream in = getAPPcmd.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//��ȡpidʱ����ȡ���ַ�����Ҫע��s
			String pid = br.readLine().substring(9, 15).trim().split(" ")[0];
			br.close();
			return pid;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// com.tencent.mm/.ui.LauncherUI
		//com.UCMobile/com.uc.browser.InnerUCMobile
	}
}
