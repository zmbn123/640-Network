
public class Iprefer {
	static int serverPort;
	static int listenPort;
	
	@SuppressWarnings("unused")
	public static void main (String[] args) throws Exception {
		
		if (args[0].equals("-c")) {
			if (args.length != 7) {
				System.out.println( "Error: missing or additional arguments");
			}
			serverPort = Integer.parseInt(args[4]);
			if (serverPort <1024||serverPort>65535) {
				System.out.println("Error: port number must be in the range 1024 to 65535");
			}
			String serverName = args[2];
			long time = Long.parseLong(args[6]);
			IpreferClient newClient = new IpreferClient(serverName, serverPort, time);
		}
				
		if (args[0].equals("-s")) {
			if (args.length != 3) {
				System.out.println("Error: missing or additional arguments");
			}
			listenPort = Integer.parseInt(args[2]);
			if (listenPort <1024||listenPort>65535) {
				System.out.println("Error: port number must be in the range 1024 to 65535");
			}
			IperfServer server = new IperfServer(listenPort);
		}
	}
}
