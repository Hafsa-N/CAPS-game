

package com.example.caps;
import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    private CountryDB db; //each instance of the class associated with a CountryDB instance, hence this attribute

    public Game()
    {
        this.db = new CountryDB(); //constructor simply inits the attribute
    }

    public String qa()
    {

        List<String> capitals = db.getCapitals(); //get ref to the database's capital city list
        int  n = capitals.size(); //determine size of list and call it n
        int index =  (int) (n * Math.random()); //generate random number in [0, n), call it index

        String c = capitals.get(index); //get a random capital city, call it c
        Map<String, Country> data = db.getData(); //get a ref to the database's data map
        Country ref = data.get(c); //invoke get(c) on the map to get ref to a country, call it ref

        String cName = ref.getName(); //p| get Name of country from ref


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
