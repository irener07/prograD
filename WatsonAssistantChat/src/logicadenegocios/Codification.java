package logicadenegocios;

public abstract class Codification {
	String text; 
	int op;
	String crypt;
	
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	
	public Codification(String text, int op, String crypt) {
		text = this.text;
		op = this.op;
		crypt = this.crypt;
		//codification_category(crypt);
		//System.out.println(crypt);		
	}
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getOp() {
		return op;
	}


	public void setOp(int op) {
		this.op = op;
	}


	public String getCrypt() {
		return crypt;
	}


	public void setCrypt(String crypt) {
		this.crypt = crypt;
	}
	
	/*
	public void codification_category(String crypt) {
		if((crypt == "cesar") || (crypt == "vigenere") || (crypt == "key")) {
			new Sustitution(text,op,crypt);	
		}
		if (crypt == "phone_code") {
			new Phone_Code(text,op,crypt);
		}
		if ((crypt == "reverse_message") || (crypt == "reverse_word")) {
			new Transposition(text,op,crypt);		
		}
		if (crypt == "binary_codification" ){
			new Binary_Codification(text,op,crypt);
		}
		else {
			System.out.println("Operacion no valida");	
		}				
	}*/
}
