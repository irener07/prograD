package Algorithms;

public class Cesar extends Sustitution
{

	public Cesar(String text, int op, String crypt) {
		super(text, op, crypt);
		sustitution_Algorithm(text,op);

	}
	
	int a;
	char b;
	
	/*String donde se muestra el alfabeto y su respectiva sustitución en su valor de indice*/
	String sustitution = "defghijklmnopqrstuvwxyzabc";

	
	/*metodo principal que le entra como parametro el texto a modificiar y un valor numerico donde 0 se encarga de 
	*codificar el texto y un 1 si es decodificar, si el valor numerico es diferente a 0 o 1, devuelve una excepción*/
	public void sustitution_Algorithm(String password, int op) {
		if (op ==0) {
			code(password);		
		}
		if (op==1) {
			decode(password);
		}
		
	}
	
	
	/*metodo que se encarga de codificar el texto*/
	private void code(String password) {
		StringBuffer newpassword = new StringBuffer();
		newpassword.append(password);
		for (int i = 0; i < newpassword.length(); i++) {
			if(newpassword.charAt(i) == ' ') {
				i++;
				a = alphabet.indexOf(newpassword.charAt(i)); //'h'
				b = sustitution.charAt(a);
				changechar(newpassword, i);
				
			}else
				a = alphabet.indexOf(newpassword.charAt(i)); //'h'
				b = sustitution.charAt(a);
				changechar(newpassword, i);
				
		}
		System.out.println(newpassword);

	}
	/*metodo que se encarga de decodificar el texto*/
	private void decode(String password) {
		StringBuffer newpassword = new StringBuffer();
		newpassword.append(password);
		for (int i = 0; i < newpassword.length(); i++) {
			if(newpassword.charAt(i) == ' ') {
				i++;
				a = sustitution.indexOf(newpassword.charAt(i)); //'h'
				b = alphabet.charAt(a);
				changechar(newpassword, i);

			}else
			a = sustitution.indexOf(newpassword.charAt(i)); //'h'
			b = alphabet.charAt(a);	
			changechar(newpassword, i);

		}
		
		System.out.println(newpassword);
	}
	private void changechar(StringBuffer newpassword, int i) {
		newpassword = newpassword.insert(i+1,b);
		newpassword = newpassword.deleteCharAt(i);
		newpassword.toString();
		
	}


}
