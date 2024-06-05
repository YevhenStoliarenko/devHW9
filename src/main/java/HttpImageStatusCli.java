import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpImageStatusCli {
    static void askStatus() throws RequestExeption, IOException {
        System.out.println("Enter HTTP status code");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String result = scanner.nextLine();
            if (result.matches("-?\\d+")) {
                URL url = new URL("https://http.cat/" + result);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    HttpStatusImageDownloader.downloadStatusImage(Integer.parseInt(String.valueOf(result)));
                } else {
                    System.out.println("There is not image for HTTP status <" + result + ">");
                }
                break;
            } else {
                System.out.println("Please enter valid number");
            }

        }

    }

}
