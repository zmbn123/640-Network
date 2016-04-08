import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class IpreferClient {
		Socket socket;
		DataOutputStream out;
		long sent = 0;
		byte [] data = new byte[1000];
	
		
	public IpreferClient(String serverName, int serverPort, long time) throws IOException{
		socket = new Socket(serverName, serverPort);
		out = new DataOutputStream(socket.getOutputStream());
		long timeStart = System.nanoTime();
		long newTime = time*1000000000;
		System.out.println(timeStart + " "+ newTime + " " + System.nanoTime());
		while (System.nanoTime()-timeStart <newTime) {
			out.write(data, 0, data.length);
		    sent++;
		}
		out.close();
		socket.close();
		double rate = (sent*8)/(time*1000);
		System.out.println("sent= "+sent+"kilobytes"+" rate="+ rate+"Mbps");
	}
}
