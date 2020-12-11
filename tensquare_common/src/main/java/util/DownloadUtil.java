package util;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class DownloadUtil {
    public static void download(String urlStr,String filename,String
            savePath) throws IOException {
        URL url = new URL(urlStr);

        URLConnection connection = url.openConnection();

        connection.setConnectTimeout(5000);

        InputStream in = connection.getInputStream();

        byte [] bytes = new byte[1024];

        int len;

        File file = new File(savePath);
        if(!file.exists())
            file.mkdirs();
        OutputStream out = new
                FileOutputStream(file.getPath()+"\\"+filename);

        while ((len=in.read(bytes)) !=-1){

            out.write(bytes,0,len);
        }

        out.close();
        in.close();
    }

}
