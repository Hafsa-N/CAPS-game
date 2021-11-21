package com.example.caps;
import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    private CountryDB db; 

    public Game()
    {
        this.db = new CountryDB(); 
    }

    public String qa()
    {

        List<String> capitals = db.getCapitals(); 
        int  n = capitals.size(); 
        int index =  (int) (n * Math.random()); //generate random number in [0, n)

        String c = capitals.get(index); //get a random capital city
        Map<String, Country> data = db.getData(); 
        Country ref = data.get(c); 

        String cName = ref.getName(); 


        //generate random question/answer
        if ((Math.random()) < 0.5)
        {
            String output = "What is the capital of " + cName + "?\n" + c;
            return output;
        }
        else
        {
            String output = c + " is the capital of?\n" + cName;
            return output;
        }
    }

}
