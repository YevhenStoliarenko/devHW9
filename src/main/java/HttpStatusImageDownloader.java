import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws IOException, RequestExeption {

        URL url = new URL(HttpStatusChecker.getStatusImage(code));
        try(InputStream inputStream = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("image.jpg");) {
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=inputStream.read(buf)))
            {
                byteArrayOutputStream.write(buf, 0, n);
            }
            byte[] response = byteArrayOutputStream.toByteArray();
            fileOutputStream.write(response);
        }

    }


}
