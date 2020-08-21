import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servicelayer.RecServiceHandle;

public class RecMain {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8680);
        server.setHandler(new RecServiceHandle());

        server.start();
        server.join();
    }
}
