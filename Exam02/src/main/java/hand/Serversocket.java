package hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class Serversocket extends Thread{
	@Override
	public void run() {
		try {
			ServerSocket ss=new ServerSocket(10890);
			Socket s=ss.accept();
			
			FileInputStream fis=new FileInputStream("result.pdf");
			BufferedInputStream bis=new BufferedInputStream(fis);
			 
			
			//fos
			//、FileOutputStream fos=(FileOutputStream) ;
			
			OutputStream os=s.getOutputStream();
			BufferedOutputStream bos=new BufferedOutputStream(os);
			
			byte b[]=new byte[1];
			while(bis.read(b)!=-1)
			{
				bos.write(b);
			}
			
			bos.close();
			os.close();
			bis.close();
			fis.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
