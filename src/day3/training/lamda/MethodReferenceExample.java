package day3.training.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample {

	public static void main(String[] args) {
		List<Player> team = Arrays.asList(new Player("Virat", "Kohali", 30), new Player("Rohit", "Sharma", 32),
				new Player("Sachin", "Tendulkar", 45), new Player("Mahendra", "Dhoni", 38),
				new Player("Saurav", "Ganguli", 49));

		System.out.println("Printing all Players");
		performConditionally(team, p -> true, (p) -> System.out.println(p));

		// Method Reference when the input is passing through in lamda
		performConditionally(team, p -> true, System.out::println);

		System.out.println("------- with interface implementation");
		performConditionally(team, p -> true, new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				customPrinting(t, u);
			}
		});
		System.out.println("------- with Method Reference");
		performConditionally(team, p -> true, MethodReferenceExample::customPrinting);

	}

	private static void customPrinting(String s1, String s2) {
		System.out.println(s1 + " --- " + s2);
	}

	private static void performConditionally(List<Player> people, Predicate<Player> predicate,
			Consumer<Player> consumer) {
		for (Player p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

	private static void performConditionally(List<Player> people, Predicate<Player> predicate,
			BiConsumer<String, String> consumer) {
		for (Player p : people) {
			if (predicate.test(p)) {
				consumer.accept(p.getFirstName(), p.getLastName());
			}
		}
	}
}
