package hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Server   
{  
    private ServerSocket ss;  
    private Socket socket;  
    private BufferedInputStream in;  
    private BufferedOutputStream out;  
  
    public Server()   
    {  
        try   
        {  
            ss = new ServerSocket(10890);  
              
           
            while(true)   
            {  
                socket = ss.accept();  
                System.out.println("客户端连接。。。");
                in = new BufferedInputStream(new FileInputStream(new File(new File("").getAbsolutePath().replaceAll("4", "1")+"/result.pdf")));  
                out = new BufferedOutputStream(socket.getOutputStream());  
               
                byte[]b=new byte[1024];
                while(in.read(b)>0)
                {
                	out.write(b);
                }
               // String line = in.readLine();  
                  
               // System.out.println("you input is : " + line);  
                  
                //out.println("you input is :" + line);  
                  
                out.close();  
              in.close();  
                socket.close();  
                  
                if("123".equalsIgnoreCase("quit") || "123".equalsIgnoreCase("exit"))  
                    break;  
            }  
              
            ss.close();  
              
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("找不到源文件！");
        }  
    }  
  
    public static void main(String[] args)   
    {  
        new Server();  
    }  
}  