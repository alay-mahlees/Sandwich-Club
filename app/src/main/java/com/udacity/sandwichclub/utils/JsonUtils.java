package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {





    public static Sandwich parseSandwichJson(String json) {



        try {
            JSONObject rootJson = new JSONObject(json);
            JSONObject SandwichName = rootJson.getJSONObject("name");
            String mainName = SandwichName.getString("mainName");
            JSONArray AlsoKnownArray = SandwichName.getJSONArray("alsoKnownAs");
            String PlaceOfOrigin = rootJson.getString("placeOfOrigin");

            String DescriptionObj = rootJson.getString("description");
            String ImageURLObj = rootJson.getString("image");
            JSONArray IngredientArray = rootJson.getJSONArray("ingredients");





            List<String> test =new ArrayList<>();
            for(int i = 0; i<AlsoKnownArray.length(); i++) {

                test.add(AlsoKnownArray.getString(i));

                }


            List<String> test3 = new ArrayList<>();
            for(int i = 0; i<IngredientArray.length(); i++){
                test3.add(IngredientArray.getString(i));




            }

            Sandwich mySandwich = new Sandwich(mainName, test, PlaceOfOrigin, DescriptionObj, ImageURLObj, test3);

            mySandwich.setAlsoKnownAs(test);
            mySandwich.setMainName(mainName);
            mySandwich.setPlaceOfOrigin(PlaceOfOrigin);
            mySandwich.setDescription(DescriptionObj);
            mySandwich.setImage(ImageURLObj);
            mySandwich.setIngredients(test3);


        return mySandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }

      return null;
    }
}
