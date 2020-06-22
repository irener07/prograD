package Algorithms;

import java.util.Arrays;

public class Phone_Code extends Codification {

	public Phone_Code(String text, int op, String crypt) {
		super(text, op, crypt);
		phone_code_Algorithm(text,op);
	}
	
	String code[] = {"21","22","23","31","32","33","41","42","43","51","52","53","61","62","63","71","72","73","74","81","82","83","91","92","93","94"};
	StringBuffer newcode = new StringBuffer();
	int a;
	
	public void phone_code_Algorithm(String password, int op) {
		if (op ==0) {
			phone_code(password);		
		}
		if (op==1) {
			phone_decode(password);
		}
		
	}
	
	
	public void phone_code(String text) {
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' ') {
				newcode.append("*");
			}else {
			a = alphabet.indexOf(text.charAt(i));
			newcode.append(code[a]);
			newcode.append(" ");

			}
		}
		System.out.println(newcode);
	
	}
	public void phone_decode(String text) {
		for(int i = 0; i < text.length();i++ ) {
			if(text.charAt(i) == '*') {
				newcode.append(" ");
				i++;			
			}
			if(text.charAt(i) == ' ') {
				
			}
			else
				phone_decode_separation(text,i);
				i = i + 2;
			}
		newcode.toString();
		System.out.println(newcode);

			
		}	
	
	public void phone_decode_separation(String text, int contador) {
		 StringBuffer phone = new StringBuffer();
		 phone.append(text.charAt(contador));
		 phone.append(text.charAt(contador+1)); 

		 phone_decode_transformation(phone);
	}
	
	public void phone_decode_transformation(StringBuffer phone) {
		String p = "";
		 p = p.concat(String.valueOf(phone.charAt(0)));
		 p = p.concat(String.valueOf(phone.charAt(1)));
		 int a;
		 a = Arrays.asList(code).indexOf(p);

		 newcode.append(alphabet.charAt(a));	
	}

}
