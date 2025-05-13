package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCSV {
    public static List<String> readFileCSV(String path){
        File file = new File(path);
        List<String> listStrings = new ArrayList<>();
        try(FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr)){
            String line ;
            while((line = bf.readLine())!=null){
                listStrings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listStrings;
    }

    public static void writeFileCSV(String path,List<String> stringList,boolean append){
        File file = new File(path);

        try(FileWriter fw = new FileWriter(file,append);
            BufferedWriter bw  = new BufferedWriter(fw)
        ){
            for(String line : stringList){
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Không thể viết vào file");
            e.printStackTrace();
        }
    }
}
