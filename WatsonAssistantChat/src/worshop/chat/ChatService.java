package worshop.chat;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.Context;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.assistant.v1.model.RuntimeEntity;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

@Path("/chatservice")  
public class ChatService {

	private String urlDB;
	private String userDB;
	private String passwordDB;
	private String apiKey="5ykNjgYi-3Vf893r1ArYEJat8TV85OJ7axFBlCHDrics";
	private String assistantURL="https://api.us-south.assistant.watson.cloud.ibm.com/instances/5f1750c0-acc6-4bd2-bf69-61d0be196d18";
	private static String workspaceId = "be5aeb9f-f32f-4887-9cba-23a2af2c346a";
	
	public ChatService(){
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@GET
	@Produces("application/json")
	public Response getResponse(@QueryParam("conversationMsg") String conversationMsg, @QueryParam("conversationCtx") String conversationCtx) {
		
		IamOptions iAmOptions = new IamOptions.Builder()
			.apiKey(apiKey)
		    .build();

		Assistant service = new Assistant("2018-09-20", iAmOptions);
		service.setEndPoint(assistantURL);
		
		// Initialize with empty value to start the conversation.
		JSONObject ctxJsonObj = new JSONObject(conversationCtx);
		Context context = new Context();
		context.putAll(ctxJsonObj.toMap());		
		
		InputData input = new InputData.Builder(conversationMsg).build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).context(context).build();
		
		MessageResponse assistantResponse = service.message(options).execute();
		System.out.println(assistantResponse);
		
		String variableObtenida = (String) context.get("todo");
		System.out.println(variableObtenida);
		
		String tipoAlgoritmo = (String) context.get("tipo");
		String EsCodificacion = (String) context.get("DecodCodif");
		String texto = (String) context.get("textoADecodificar");
		
//		//DespuEs del assistant Response manipulamos el contexto
//		//Metemos informaciOn
//		context.put("pruebaVariable", "Soy un valor del cOdigo");
//		//downCast de info obtenida del contexto
//		String variableObtenida = (String) context.get("colorEscogido");
//		//obtenemos entidades
//		List<RuntimeEntity> entidades= assistantResponse.getEntities();
//		String entidad= obtenerEntidad(entidades, "colores");
//		
		
		//RepeticiOn innecesaria (mete nuevo contexto a la conversaciOn)
		input = new InputData.Builder(conversationMsg).build();
        options = new MessageOptions.Builder(workspaceId).input(input).context(context).build();
        
        assistantResponse = service.message(options).execute();    
		
		
		
		// Print the output from dialog, if any.
		List<String> assistantResponseList = assistantResponse.getOutput().getText();
		JSONObject object = new JSONObject();
		
		String assistantResponseText = "";
		for (String tmpMsg : assistantResponseList)
			assistantResponseText = assistantResponseText + System.lineSeparator() + tmpMsg;
			
		object.put("response", assistantResponseText);
		object.put("context", assistantResponse.getContext());
		return Response.status(Status.OK).entity(object.toString()).build();
	}
	
	  //obtener las entidades
		private String obtenerEntidad(List<RuntimeEntity> pEntidades,String pNombre) {
	        String entidad="";
	        for (int i = 0; i < pEntidades.size(); i++) {
	            if(pEntidades.get(i).getEntity().equalsIgnoreCase(pNombre)) {
	                entidad+= pEntidades.get(i).getValue();
	                i= pEntidades.size();
	            }
	        }
	        return entidad;
	    }
	
}
