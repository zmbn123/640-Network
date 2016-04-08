import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IperfServer {

	public IperfServer(int listenPort ) throws IOException{
		ServerSocket server;
		Socket listenSocket;
		DataInputStream in;
		long totalData = 0;
		long dataRead = 0;
		byte[] read = new byte [1000];
		server = new ServerSocket(listenPort);
		listenSocket = server.accept();
		in = new DataInputStream(listenSocket.getInputStream());
		long timeStart;
		long totalTime;
		timeStart = System.nanoTime();
		while(dataRead != -1){
			dataRead = in.read(read);
			totalData += dataRead;
		}
		totalTime = System.nanoTime() - timeStart;
		System.out.println(dataRead);
		System.out.println(totalData);
		in.close();
		server.close();
		System.out.println(timeStart + " " + totalTime + " " + System.nanoTime());
		long rate = ((totalData+1)*8000)/(totalTime);
		System.out.println("recieved=" + (totalData/1000) +" KB rate =" + rate + " Mbps");
	}
	
}
