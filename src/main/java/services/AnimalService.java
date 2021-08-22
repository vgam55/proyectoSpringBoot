package services;

import java.util.ArrayList;
import java.util.Optional;

import org.json.*;

public interface AnimalService {
	public ArrayList<JSONObject> findAll();
	
	public Optional<JSONObject> findByName(String name);
	
	public Optional<JSONObject> findByFood(String food);
}
