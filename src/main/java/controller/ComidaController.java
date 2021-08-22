package controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.ComidaService;

import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/comida")
public class ComidaController {
	
    private ComidaService comidaService; 
	
    @RequestMapping(value = "/crearComida/{name}", method = RequestMethod.GET)
    public JSONObject crearComida(String name)
    {
    	return (JSONObject) comidaService.createFood(name);
    }
}
