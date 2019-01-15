package day3.training.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.Comparator;

public class LambdaExcercise {

	public static void main(String[] args) {
		List<Player> team = Arrays.asList(new Player("Virat", "Kohali", 30), new Player("Rohit", "Sharma", 32),
				new Player("Sachin", "Tendulkar", 45), new Player("Mahendra", "Dhoni", 38),
				new Player("Saurav", "Ganguli", 49));

		// Step 1: Sort list by last name

		// Without lambda
		Collections.sort(team, new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// With lambda
		Collections.sort(team, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step 2 :
		// Print all
		// without lambda
		System.out.println("-----------------------Print team without lambda ");
		for (Player p : team) {
			System.out.println(p);
		}
		System.out.println("-----------------------Print team with lambda ");
		// with lambda
		team.forEach(p -> System.out.println(p));

		// Step 3: prints all elements with first name starts with S in the list

		System.out.println("-----------------------Print team with first name starts with S with Specific method");
		printWithFirstNameStartsWithS(team); // this is inefficient and very specific behaviour

		System.out.println("-----------------------Print team with first name starts with S without lambda ");
		// without lambda // remove the behaviour as the interface and specific
		// behaviour in a implemetation
		printConditionally(team, new Condition() {
			@Override
			public boolean test(Player p) {
				return p.getFirstName().startsWith("S");
			}
		});
		// with lambda
		System.out.println("-----------------------Print team with first name starts with S with lambda ");
		printConditionally(team, p -> p.getFirstName().startsWith("S"));

		// Step 4: prints all elements with last name starts with K in the list

		// without lamda
		System.out.println("-----------------------Print team with last name starts with K without lambda ");
		printConditionally(team, new Condition() {
			@Override
			public boolean test(Player p) {
				return p.getLastName().startsWith("K");
			}
		});

		// with lamda
		System.out.println("-----------------------Print team with last name starts with K with lambda ");
		printConditionally(team, p -> p.getLastName().startsWith("K"));
		
		// separating the behaviour from condition
		System.out.println(
				"-----------------------peform team with first name starts with S with lambda ---- print first name");
		performConditionally(team, p -> p.getFirstName().startsWith("S"), p -> System.out.println(p.getFirstName()));

		System.out.println(
				"-----------------------peform team with first name starts with S with lambda --- print last name ");
		performConditionally(team, p -> p.getFirstName().startsWith("S"), p -> System.out.println(p.getLastName()));

	}

	private static void printWithFirstNameStartsWithS(List<Player> team) {
		for (Player e : team) {
			if (e.getFirstName().startsWith("S")) {
				System.out.println(e);
			}
		}
	}

	private static void printConditionally(List<Player> team, Condition condition) {
		for (Player e : team) {
			if (condition.test(e)) {
				System.out.println(e);
			}
		}
	}

	private static void performConditionally(List<Player> team, Condition condition, Consumer<Player> c) {
		for (Player e : team) {
			if (condition.test(e)) {
				c.accept(e);
			}
		}
	}
}

interface Condition {
	boolean test(Player p);
}
