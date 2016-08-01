package hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
public static void main(String[] args) {
	URL u;
	try {
		u = new URL("http://files.saas.hand-china.com/java/target.pdf");
		URLConnection conn=u.openConnection();
		
		InputStream is=conn.getInputStream();
		
		BufferedInputStream bis=new BufferedInputStream(is);
		
		
		FileOutputStream fos=new FileOutputStream("result.pdf");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		byte b[]=new byte[1];
		while(bis.read(b)!=-1)
		{
			
			bos.write(b);
		}
		bos.close();
		fos.close();
		bis.close();
		is.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
