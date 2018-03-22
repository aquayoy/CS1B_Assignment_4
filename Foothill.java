/** CS1B_Assignment_4;option A & B1
 * Creeger, Adam/ Kishore, Nand/ Lo, YaFan
 */
public class Foothill {
	public static void main(String[] args) {

		System.out.println("Base Class Testing ***********************");

		InternetUser user1 = new InternetUser();
		InternetUser user2 = new InternetUser("Foothill", "75.75.75.75");
		InternetUser user3 = new InternetUser("default", "1122334455667788");
		InternetUser user4 = new InternetUser("a", "0.0.0.0");

		System.out.println(user1.toString() + "\n");
		System.out.println(user2.toString() + "\n");
		System.out.println(user3.toString() + "\n");
		System.out.println(user4.toString() + "\n");

		System.out.println("-----------Derived Class (Communicator Class) Constructor Testing-----------");

		Communicator communicator1 = new Communicator();
		communicator1.setPrimes(109, 113);
		System.out.println(communicator1.toString());

		Communicator communicator2 = new Communicator(0, 0);
		System.out.println(communicator2.toString());

		Communicator communicator3 = new Communicator("yan kam", "127.90.32.14");
		Communicator communicator4 = new Communicator("sally", "123451234512345123", 461, 463);
		Communicator communicator5 = new Communicator("s", "123.456.123.45",83, 97);
		Communicator communicator6 = new Communicator("betty", "1.3.5.7", 461, 461);
		Communicator communicator7 = new Communicator("bob", "2.4.6.8", 8, 9);

		System.out.println(communicator3.toString());
		System.out.println(communicator4.toString());
		System.out.println(communicator5.toString());
		System.out.println(communicator6.toString());
		System.out.println(communicator7.toString());
		
		System.out.println("\n\n-----------Derived and Base Class Mutator Testing-----------");

		communicator7.setPrimes(41, 43);
		System.out.println(communicator7.toString()+"\n" );
		
		user4.setIp("00.89.546.1");
		user4.setName("aa");
		System.out.println(user4.toString() );

		System.out.println("\n\n-----------accessors Testing-----------");
		System.out.println("communicator7's public key: "+communicator7.getPublicKey());
		System.out.println("communicator7's private key: "+communicator7.getPrivateKey());
		System.out.println("communicator7's name: "+communicator7.getName());
		System.out.println("communicator7's ip: "+communicator7.getIp());
		
		System.out.println("\n\n***************Option B1***************");

		// create an IuStack. Then push() various InternetUsers onto the stack
		IuStack iustk = new IuStack();
		InternetUser iu, current;
		iu = new InternetUser("Aaron", "1.1.1.1");
		iustk.pushIu(iu);
		iu = new InternetUser("Michael", "2.2.2.2");
		iustk.pushIu(iu);
		iu = new InternetUser("Helen", "3.3.3.3");
		iustk.pushIu(iu);
		iu = new InternetUser("Ray", "4.4.4.4");
		iustk.pushIu(iu);
		iu = new InternetUser("Joyce", "5.5.5.5");
		iustk.pushIu(iu);
		/*
		 * Finally, in a loop, pop() everything off the IuStack and print it out as you
		 * pop(). Go beyond the end of the Stack so you can confirm that your code does
		 * not break when you pop() things off an empty Stack.
		 */
		// 3 more times test for empty stack
		for (int i=0; i<8; i++ ) {
			if ( (current = iustk.popIu()) != iustk.STACK_EMPTY)
	            System.out.println(current+"\n");
		}
		
	}
		
}
