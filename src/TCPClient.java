import java.io. *;
import java.net.*;
import java.util.Scanner;

class TCPClient {
    static void main(String[] argv) throws Exception
    {
        String sentence;
        String modifiedSentence;
        Integer answer;
        Scanner inFromUser =
                new Scanner(System.in);
        //scanner is the ear, listening to keyboard (system.in)

        Socket clientSocket = new Socket ("localhost", 6789);

        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        Scanner inFromServer =
                new Scanner(clientSocket.getInputStream());
        //scanner is the ear, listening from server (socket input stream)

        while (true) {
            System.out.print("Enter a sentence: ");
            sentence = inFromUser.nextLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.nextLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            System.out.print("Press 1 to quit, 2 to continue: ");
            answer = Integer.valueOf(inFromUser.nextLine());
            if (answer == 1) {
                outToServer.writeBytes("done\n");
                clientSocket.close();
                break;
            } else {
                continue;
            }
        }
    }
}
