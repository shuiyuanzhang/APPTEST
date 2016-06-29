package testData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetData {
	/**
	 * 获取TCP_RCV流量值
	 * 
	 * Created on 2016/06/06
	 * 
	 * @author Main.z
	 * @throws Throwable 
	 *
	 */ 

	public static Integer tcp_rcv() throws Throwable {
		try {
			Process tcp_rcv_process=Runtime.getRuntime().exec("adb shell cat /proc/uid_stat/"+getParameter.GetUid.getAPPUid()+"/tcp_rcv");
			InputStream in = tcp_rcv_process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String Number =br.readLine();
			br.close();
			return Integer.parseInt(Number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (Integer) null;
	}
	
	

	
	/**
	 * 获取TCP_SND流量值
	 * 
	 * Created on 2016/06/06
	 * 
	 * @author Main.z
	 * @throws Throwable 
	 *
	 */  
	public static Integer tcp_snd() throws Throwable  {
		try {
			Process tcp_snd_process = Runtime.getRuntime().exec("adb shell cat /proc/uid_stat/"+getParameter.GetUid.getAPPUid()+"/tcp_snd");
			thearSleep.ThearSleep.sleep(1000);
			InputStream in = tcp_snd_process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String Number =br.readLine();
			return Integer.parseInt(Number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Integer) null;

	}
}
