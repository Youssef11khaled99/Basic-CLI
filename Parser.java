public class Parser{
	String input;
	Public String takeIn()
	{
		System.out.println("Hello, please can you give us the input?");
		Scanner sc = new Scanner(in);
		input = sc.nextLine();
		System.out.println("Your input is: " + input);
	}
}
