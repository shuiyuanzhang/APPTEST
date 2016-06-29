package thearSleep;

public class ThearSleep {
	public static void sleep(int t) {
		try {
            Thread.sleep(t);
         } catch (InterruptedException e) { }
      }
}
