import java.io. *;
import java.net.*;
import java.util.Scanner;

class TCPServer {
    public static void main(String argv[]) throws Exception
    {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            //the thing its connected to
            Scanner inFromClient =
                    new Scanner (connectionSocket.getInputStream());
            //scanner object gets data from client, like an ear.
            //scanner can only listen
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());
            //DataOutputStream object puts out data, like a mouth
            while(true) {
                clientSentence = inFromClient.nextLine();
                if (clientSentence.equals("done")) {
                    connectionSocket.close();
                    break;
                } else {
                    capitalizedSentence = clientSentence.toUpperCase() + '\n';
                    outToClient.writeBytes(capitalizedSentence);
                    //outToClient is connected to output for the client
                }

            }
            connectionSocket.close();

        }
    }
}
