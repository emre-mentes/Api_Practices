package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class ReusableMethods {

    /*
    string data tipinde json formatinda bir datayi alip mape dönüstüren reusable method olusturduk
     */
    public static Map<String,Object> jsonToMap (String json){

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, HashMap.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }



}