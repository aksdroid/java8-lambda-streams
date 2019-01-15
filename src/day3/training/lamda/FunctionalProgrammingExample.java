package day3.training.lamda;

public class FunctionalProgrammingExample {

	public static void main(String[] args) {
		FunctionalProgrammingExample fpExample = new FunctionalProgrammingExample();

		// STEP 1 : use implemetation
		fpExample.printMessage(new PrintPerformer());

		// Step 2 : use annonymous implemetation class
		// Performer performer = new Performer() {
		// public void perform() {
		// System.out.println("Hello!!!");
		// };
		// };

		// fpExample.printMessage(performer);

		// Step 3 :
		// passing the function itself as value instead of the implementation like
		// PrintPerfomer
		// This is lamda expression () -> System.out.println("Hello!!!")
		fpExample.printMessage(() -> System.out.println("Hello!!!"));
	}

	/**
	 * 
	 * @param performer
	 */
	public void printMessage(Performer performer) {
		performer.perform();
	}

}
