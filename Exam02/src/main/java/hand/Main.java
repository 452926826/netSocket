package hand;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new Serversocket().start();
			new CustomSocket().out();
		//System.out.println(new File("").getAbsolutePath().replaceAll("2", "1")); 
		
	}

}
