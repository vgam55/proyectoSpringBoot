package controller;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.AnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	public AnimalController(AnimalService animalService)
	{
		this.animalService=animalService;
	}
	@RequestMapping(value = "/all}", method = RequestMethod.GET)
	public ArrayList<JSONObject> findAll()
	{
		return animalService.findAll();
	}
	
	@RequestMapping(value = "/findbyname/{name}}", method = RequestMethod.GET)
	public Optional<JSONObject> findByName(String name)
	{
		return animalService.findByName(name);
	}
	
	@RequestMapping(value = "/findbyfood/{name}}", method = RequestMethod.GET)
	public Optional<JSONObject> findByFood(String name)
	{
		return animalService.findByFood(name);
	}
}
