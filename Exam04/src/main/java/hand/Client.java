package hand;

import java.io.*;  
import java.net.*;  
  
public class Client   
{  
    Socket socket;  
    BufferedInputStream in;  
    BufferedOutputStream out;  
  
    public Client()   
    {  
        try   
        {  
            socket = new Socket("127.0.0.1",10890);  
              
            FileOutputStream fos=new FileOutputStream("result2.pdf");
            in = new BufferedInputStream(socket.getInputStream());  
            out = new BufferedOutputStream(fos);  
           
            byte[]b=new byte[1024];
           
            while(in.read(b)>0)
            {
            	out.write(b);
            }
            out.close();  
            in.close();  
              
            socket.close();  
              
        } catch (IOException e) {  
        	System.out.println(e);
        }  
    }  
  
    public static void main(String[] args)   
    {  
        new Client();  
    }  
}  