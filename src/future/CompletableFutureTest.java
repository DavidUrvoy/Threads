package future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	public static void main(String[] args) {

		CompletableFutureTest test = new CompletableFutureTest();

		CompletableFutureClass c = test.new CompletableFutureClass();

		System.out.println(CompletableFuture.supplyAsync(c::async)
				.thenApply(c::apply)
				.thenAccept(c::accept));

	}

	class CompletableFutureClass {
		String async() {
			System.out.println("async");
			return "async";
		}

		String accept(String s) {
			s = "accepted : " + s;
			System.out.println(s);
			return s;
		}

		String apply(String s) {
			s = "applied : " + s;
			System.out.println(s);
			return s;
		}
	}

}
