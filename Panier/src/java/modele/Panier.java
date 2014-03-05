package modele;

import java.util.HashMap;

public class Panier // Mon bean Panier
{
	private HashMap<String,Integer> fruits; // HashMap contenant le nom du fruit associé à sa quantité

	public HashMap<String, Integer> getFruits() 
	{
		return fruits;
	}

	public void setFruits(HashMap<String, Integer> fruits) 
	{
		this.fruits = fruits;
	}

}
