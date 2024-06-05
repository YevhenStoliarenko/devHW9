import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public static String getStatusImage(int code) throws IOException, RequestExeption {
        String result = null;
        URL url = new URL("https://http.cat/" + code);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200){
            result = String.valueOf(url + ".jpg");
        } else {
            throw new RequestExeption("Statuscode is wrong");
        }
        return result;
    }

}
