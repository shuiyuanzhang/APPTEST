package getParameter;

public class GetData {
	public static Integer Data() {

		try {
			Integer RawData = testData.GetData.tcp_rcv()+testData.GetData.tcp_snd();
			return RawData;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Integer) null;

	}


}
