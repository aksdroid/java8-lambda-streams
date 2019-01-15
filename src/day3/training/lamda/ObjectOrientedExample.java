package day3.training.lamda;

public class ObjectOrientedExample {

	public static void main(String[] args) {
		ObjectOrientedExample oopExample = new ObjectOrientedExample();
		oopExample.printMessage();
		oopExample.printMessage("Hello!!");

		oopExample.printMessage(new PrintPerformer());

		Performer performer = new Performer() {
			public void perform() {
				System.out.println("Hello!!!");
			};
		};
		oopExample.printMessage(performer);
	}

	/**
	 * Only prints Hello! everytime
	 */
	public void printMessage() {
		System.out.println("Hello!");
	}

	/**
	 * prints the message which is passed ot it
	 * 
	 * @param message
	 */
	public void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * performs the object which has behaviour this is still the Object oriented
	 * programming
	 * 
	 * @param performer
	 */
	public void printMessage(Performer performer) {
		performer.perform();
	}
}
