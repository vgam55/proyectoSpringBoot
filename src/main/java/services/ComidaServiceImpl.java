package services;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service("ComidaService")

public class ComidaServiceImpl implements ComidaService {
	String [] tipoComida= {"carne","pescado", "verduras","fruta","hidratos de carbono"};
	private ArrayList<JSONObject>comida=new ArrayList<JSONObject>();
	private JSONObject temporalComida;
	
	public ComidaServiceImpl()
	{
		//Creamos una lista de objetos Json con los nombres de varia comidas
		//para simular que lo hemos cogido de una BD
		for(int i=0;i<=4;i++)
		{
			temporalComida=new JSONObject();
			temporalComida.put("nombre", tipoComida[i]);
			comida.add(temporalComida);
			}
			
	}
	@PostMapping("/create/{food}")
	@Override
	public JSONObject createFood(String food) {
		temporalComida=new JSONObject();
		temporalComida.put("nombre", food);
		comida.add(temporalComida);
		return temporalComida;
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public ArrayList<JSONObject> selectAll()
	{
		return comida;
	}
	
}
