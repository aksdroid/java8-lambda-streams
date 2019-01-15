package day3.training.lamda;

public class TypeInferenceExample {

	public static void main(String[] args) {

		StringLengthLambda l0 = new StringLengthLambda() {
			@Override
			public int getLength(String s) {
				return s.length();
			}
		};

		System.out.println(l0.getLength("Hello"));

		printLambda(l0);

		StringLengthLambda l1 = (String s) -> s.length();
		StringLengthLambda l2 = (s) -> s.length();
		StringLengthLambda l3 = s -> s.length();

		System.out.println(l3.getLength("Hello"));

		printLambda(s -> s.length());
	}

	public static void printLambda(StringLengthLambda l) {
		System.out.print(l.getLength("Hello Lambda"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}

}
