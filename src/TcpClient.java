
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {

    private ServerSocket ss;
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;
    private String msg;

    public TcpClient() {
        try {
            //
            //step 1 open port
            s = new Socket("127.0.0.1",8888);//ขอ port 8888 ของ localhost

          
            //step 2 create input and output
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());
            //step 3 process
            out.println("อิอิ หิวข้าว");
            out.flush();
            msg=in.readLine();
            System.out.println("Server echo !"+msg);
            //step 4 close
            s.close();
          
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        new TcpClient();
    }
}
