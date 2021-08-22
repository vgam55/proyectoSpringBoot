package services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/animal")
public class AnimalServiceImpl implements AnimalService{

	String [] nombreAnimal= {"perro", "gato", "araña","canario", "jilguero"};
	String [] tipoComida= {"carne","pescado", "verduras","fruta","hidratos de carbono"};
	
	private ArrayList<JSONObject> animales=new ArrayList<JSONObject>();
	
	public AnimalServiceImpl()
	{
		JSONObject temporalAnimal;
		//Creamos una lista de animales para simular que lo cogimos de una BBDD
		for (int i=0; i<=4; i++)
		{
			temporalAnimal=new JSONObject();
			temporalAnimal.put("nombre",nombreAnimal[i]);
			temporalAnimal.put("comida", tipoComida[i]);
			animales.add(temporalAnimal);
		}
	}
	
	@Override
	@RequestMapping("/all")
	public ArrayList<JSONObject> findAll() {
		return animales;
	}

 /*
    Busca una animal por el nombre del animal y lo devuelve
    (si existe). Por eso eso usamos el tipo Optional
 */
@Override
@RequestMapping("/findbyname/{name}")
public Optional<JSONObject> findByName(String name)
{
    ArrayList<JSONObject> animalTemp=new ArrayList();       
    JSONObject animal=new JSONObject();

    //Busca el animal con un stream
    animalTemp = (ArrayList<JSONObject>) animales.stream().filter(animales->animales.get("nombre")==name).collect(Collectors.toList());

    //Busca el animal con un stream
    animal=animalTemp.get(0);
    return Optional.ofNullable(animal);
}

/*
    Busca una animal por la comida de la que se alimenta y la devuelve
    (si existe). Por eso eso usamos el tipo Optional
*/
@Override
@RequestMapping("/findbyfood/{name}")
 public  Optional<JSONObject> findByFood(String name)
{
    ArrayList<JSONObject> animalTemp=new ArrayList();       
    JSONObject animal=new JSONObject();
   
    //Busca el animal con un stream
    animalTemp= (ArrayList<JSONObject>) animales.stream().filter(animales->animales.get("comida")==name).collect(Collectors.toList());
   
    //Sacamos los datos del animal en un objeto y lo devolvemos
    animal=animalTemp.get(0);
    return Optional.ofNullable(animal);
}

}
