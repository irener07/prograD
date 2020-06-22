package Algorithms;

public class Reverse_Message extends Transposition {

	public Reverse_Message(String text, int op, String crypt) {
		super(text, op, crypt);
		code(text);
		
	}
	
	public void code(String password) {
		StringBuffer newpassword = new StringBuffer();
		for(int i = password.length()-1; i > 0;i--) {
			newpassword.append(password.charAt(i));
			
		}
		System.out.println(newpassword);
		
	}



}
