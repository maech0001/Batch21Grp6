package utils;

public class APIPayloadConstants {

    public static String generateTokenPayLoad(){
        String generateTokenPayLoad = "{\n" +
                "  \"email\": \"admin328@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}";
        return generateTokenPayLoad;
    }
}
