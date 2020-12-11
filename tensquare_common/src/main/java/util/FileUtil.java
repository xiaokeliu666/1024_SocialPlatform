package util;

import sun.awt.geom.AreaOp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void merge(String outFileName, List<String> inFileNames) throws IOException {
        FileWriter writer = new FileWriter(outFileName,true);
        for(String inFileName : inFileNames) {
            try {
                String txt = readToString(inFileName);
                writer.write(txt);
                System.out.println(txt);
            } catch (Exception e){

            }
        }
        writer.close();
    }

    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        for(int i = 0; i < tempList.length; i++) {
            if(tempList[i].isFile()) {
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                files.addAll(getFiles(tempList[i].toString()));
            }
        }
        return files;
    }

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }
}
