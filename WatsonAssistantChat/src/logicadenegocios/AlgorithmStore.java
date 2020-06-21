package logicadenegocios;

public class AlgorithmStore {
	private SimpleAlgorithmFactory factory;

    public AlgorithmStore(SimpleAlgorithmFactory pFactory){
    factory= pFactory;
    }

    public Algorithm orderCake(String pType) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
    	Algorithm cake;
    	cake= factory.createCake(pType);

    	cake.bake();
    	return cake;

 }
}
