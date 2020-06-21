package logicadenegocios;

import java.util.Arrays;

public class BinaryCodification extends Codification{
	
	public BinaryCodification(String text, int op, String crypt) {
		super(text, op, crypt);
		binary_code_Algorithm(text, op);
	}
	
	String binary_codes[] ={"00000","00001","00010","00011","00100","00101","00110","00111","01000","01001","01010","01011",
			"01100","01101","01110","01111","10000","10001","10010","10011","10100","10101","10110","10111","11000","11001"};

	StringBuffer newcode = new StringBuffer();
	int a;

	
	public void binary_code_Algorithm(String text, int op) {
		if (op ==0) {
			binary_code(text);		
		}
		if (op==1) {
			binary_decode(text);
		}
		
	}
	public void binary_code(String text) {
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' ') {
				newcode.append("*");
			}else {
			a = alphabet.indexOf(text.charAt(i));
			newcode.append(binary_codes[a]);
			newcode.append(" ");

			}
		}
		System.out.println(newcode);
	
	}
	public void binary_decode(String text) {
		for(int i = 0; i < text.length();i++ ) {
			if(text.charAt(i) == '*') {
				newcode.append(" ");
				i++;			
			}
			if(text.charAt(i) == ' ') {
				
			}
			else
				binary_decode_separation(text,i);
				i = i + 5;
			}
		newcode.toString();
		System.out.println(newcode);

			
		}	
	
	public void binary_decode_separation(String text, int contador) {
		 StringBuffer bin = new StringBuffer();
		 for(int i = contador; i < contador+5 ;i++) {
			 
			bin.append(text.charAt(i));
		 }
		 binary_decode_transformation(bin);
	}
	
	public void binary_decode_transformation(StringBuffer bin) {
		String p = "";
		 
		 for(int i = 0;i<5;i++) {
			 p = p.concat(String.valueOf(bin.charAt(i)));
		 }
		 int a;
		 a = Arrays.asList(binary_codes).indexOf(p);
		 newcode.append(alphabet.charAt(a));	
	}
}
