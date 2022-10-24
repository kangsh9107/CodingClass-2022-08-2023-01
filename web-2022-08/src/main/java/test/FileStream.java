package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStream {
    String fileName = "FileStreamTest.obj";
    
    public void writer() {
        try {
            String data = "hi...\n하이...\n123\n!@#$";
            FileWriter fw = new FileWriter(fileName);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void append() {
        try {
            String data = "\n추가된 내용입니다.";
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    public void read() {
        try{
            String data = "";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
           
            while( (data = br.readLine() ) != null) {
                System.out.println(data);
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileStream frw = new FileStream();
        frw.writer();
        frw.append();
        frw.read();
    }
	
}
