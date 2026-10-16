import java.io. *;
import java.net.*;

class HTTPClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("example.com", 80); //port is 80 for http
        //after this line^ you are connected!! no request sent yet
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        //the http request (STRICT FORMAT)
        //http is just formated text over a TCP socket!!!!
        out.writeBytes("GET / HTTP/1.1 \r\n");
        out.writeBytes("Host: example.com \r\n");
        out.writeBytes("Connection: close \r\n");
        out.writeBytes("\r\n");
        out.flush();

        String line;
        while ((line=in.readLine()) != null) {
            System.out.println(line);

        }
        socket.close();
    }
}
