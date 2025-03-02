package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String generateTokenPayLoad() {
        String generateTokenPayLoad = "{\n" +
                "  \"email\": \"admin328@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}";
        return generateTokenPayLoad;


    }

    /*public static String createUserPayLoad() {
        String createUserPayLoad = "{\n" +
                "  \"name\": \"adminbatch212\",\n" +
                "  \"email\": \"admin528@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}";

        return createUserPayLoad;

    }*/

    public static String createUserPayLoad(String name, String email, String password){
        JSONObject obj= new JSONObject();
        obj.put("name", "adminbatch212");
        obj.put("email", "admin528@test.com");
        obj.put("password", "Test@123");

        return obj.toString();
    }


}

