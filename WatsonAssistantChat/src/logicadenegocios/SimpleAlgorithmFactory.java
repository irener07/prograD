package logicadenegocios;

public class SimpleAlgorithmFactory {
	
	public Codification createCake(String type) throws Exception{
		Codification codification =(Codification)Class.forName("logicadenegocios."+type).newInstance();
        return codification;
    }
}
