package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		TestFutureTask test = new TestFutureTask();

		System.out.println("before");

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<String> callable = () -> test.new FutureClass().error();

		FutureTask<String> future = new FutureTask<>(callable);
		// future.get() returns 2 or raises an exception if the thread dies, so
		// safer
		executor.execute(future);
		executor.shutdown();

		System.out.println("after");
		try {
			while (!future.isDone()) {
				System.out.println(future.get());
			}
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		}
	}

	class FutureClass {
		synchronized String error() throws InterruptedException {
			this.wait(2000);
			// throw new RuntimeException("coucou");
			return "coucou";
		}
	}
}
