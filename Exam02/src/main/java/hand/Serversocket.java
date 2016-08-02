package hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class Serversocket extends Thread{
//	private Socket s;
//	
//	public Serversocket(Socket s) {
//		super();
//		this.s = s;
//	}

	@Override
	public void run() {
		try {
			ServerSocket ss=new ServerSocket(10891);
			Socket s = ss.accept();

			System.out.println("传输。。。");
		
			
			PrintStream ps = new PrintStream(s.getOutputStream());
			//获取需要发送的文件的输入流
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(new File("").getAbsolutePath().replaceAll("2", "1")+"/result.pdf")));
			byte[] b = new byte[1024];
			int len = 0;
			int count=0;
			while((len = bis.read(b)) != -1){
				ps.write(b, 0, len);
				count+=len;
				System.out.println(count);
			}
			
			bis.close();
			ps.close();
			
			
	
			
			
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
}
