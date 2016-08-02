package hand;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class CustomSocket{
//private Socket s;
//
//
//public CustomSocket(Socket s) {
//	super();
//	this.s = s;
//}


public  void out()
{
	
	try {

		File file = new File("result2.pdf");
		//获取新文件的输出流
		PrintStream ps2 = new PrintStream(file);
		//获取socket的输入流
		Socket  s = new Socket("127.0.0.1",10891);
		BufferedInputStream bis2 = new BufferedInputStream(s.getInputStream());
		byte[] b2 =new byte[1024];
		int len2 = 0;
		System.out.println("开始下载...");
		int count2=0;
		while((len2 = bis2.read(b2)) != -1){
			count2+=len2;
			ps2.write(b2, 0, len2);
			System.out.println(count2);
		}
		System.out.println("下载完成!");
		bis2.close();
		ps2.close();
		//fos
		//、FileOutputStream fos=(FileOutputStream) ;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
