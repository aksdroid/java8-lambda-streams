
1	ObjectOrientedExample
2	FunctionalProgrammingExample
3 	How to write lamda expression

	Inline values 
		int i = 10;
		String s = "Hello";
		
	function as inline values
		myFunction = public void printMessage(){
							Sysout();
						}
						
	
	some more examples
	 
	--	myFunction = () -> System.out.println("Hello!");
	
	otherFunction(myFunction);  ----> otherFunction(() -> System.out.println("Hello!")); 
	
	--	
	public int doubleIt(int a){
		return a*2;
	} 
	
	doubleIt = (int a) -> a*2;
	
	----
	public int addIt(int a,int b){
		return a+b;
	} 
	
	addIt = (int a,int b) -> a+b;
	----
	
	public double divideIt(int a, int b) {
		if(b == 0){
			return 0;
		}
		return a/b;
	} 
	
	divideIt = (int a, int b) -> {
		if(b == 0) return 0;
		return a/b;
	}
	
	---
	
	public int stringLength(String s )
	{
		return s.length();
	}
		
		
	stringLength = s -> s.length();
	
	
	--- return type is Interface
	--- should have only one method, enforce it by adding @FunctionalInterface annotation
	--- type inference --- you dont need to specify the input type or return type
	--- JDK already provide few mostly used Functional Interface under java.util.function package
	
	--- Lambda Excercise in detail
	
	--- Method Reference 
	
	 
	
	