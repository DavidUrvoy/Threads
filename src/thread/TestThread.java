package thread;

public class TestThread {

	public static void main(String[] args) {

		TestThread test = new TestThread();

		ThreadClass t = test.new ThreadClass();

		System.out.println("avant");

		try {
			Thread thread = t.error();
			thread.setUncaughtExceptionHandler((Thread th, Throwable ex) -> {
				System.out.println(ex.getMessage());
			});
			thread.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("après");
	}

	class ThreadClass {
		public Thread error() {
			return new Thread(() -> {
				throw new RuntimeException("Thread error");
			});
		}
	}

}
