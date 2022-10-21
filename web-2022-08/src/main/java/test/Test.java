package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	List<Data> list = new ArrayList<>();
	String fileName = "TestText3.obj";
	
	public void writer() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Data d1 = new Data("a001","kim","korea","010-1",90);
            Data d2 = new Data("a002", "lee",  "korea", "010-2", 80);
            Data d3 = new Data("a003", "park", "korea", "010-3", 70);

            list.add(d1);
            list.add(d2);
            list.add(d3);
            
            oos.writeObject(list);
            
            oos.close();
            fos.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
    public void read() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
           
            List<Data> readData = (List<Data>) ois.readObject();
           
            for(Data d : readData) {
                System.out.println(d.toString());
            }
           
            ois.close();
            fis.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


	
	public static void main(String[] args) {
		Test t = new Test();
		t.writer();
		t.read();
	}

}
