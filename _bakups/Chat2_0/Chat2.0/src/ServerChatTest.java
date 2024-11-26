import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerChatTest {

    private static final int PORT = 4444;
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Server2 [port]" + PORT);
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                clientSockets.add(clientSocket);
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String line;
            while ((line = inputBufferedReader.readLine()) != null) {
                if (line.equals("/quit")) {
                    System.out.println("Client disconnected: " + clientSocket);
                    break;
                }
                System.out.println("Received: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}

