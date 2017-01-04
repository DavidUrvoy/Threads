package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		TestFuture test = new TestFuture();

		System.out.println("before");

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<Integer> callable = () -> 2;

		Future<Integer> future = executor.submit(callable);
		// future.get() returns 2 or raises an exception if the thread dies, so
		// safer
		executor.shutdown();

		System.out.println(future.get());

		System.out.println("after");
	}

	class FutureClass {
		String error() {
			return "coucou";
		}
	}
}
