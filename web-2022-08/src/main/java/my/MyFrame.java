package my;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	JButton b = new JButton("exit");
	
	public MyFrame() {
		setBounds(10,20,400,500); // (x,y,w,h)
		setLayout(null);
		b.setBounds(50,100,150,200);
		add(b);
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true); // true를 해야 화면에 보인다. 안하면 메모리에만 올라감.
	}
	
}









