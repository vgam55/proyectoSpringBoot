package controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/comida")
public class ComidaController {
	
	@Autowired
    private ComidaService comidaService; 
	
	public ComidaController(ComidaService comidaService) 
	{
		this.comidaService=comidaService;
	}
    @RequestMapping(value = "/crearComida/{name}", method = RequestMethod.GET)
    public JSONObject crearComida(String name)
    {
    	return (JSONObject) comidaService.createFood(name);
    }
}
