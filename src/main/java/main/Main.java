package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.GetRequestServlet;
import java.util.logging.Logger;

import static java.util.logging.Logger.*;

/**
 * Created by doc.juice on 18.05.2018.
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        GetRequestServlet servlet = new GetRequestServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(servlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        log.info("Server started");
        server.join();
    }

}
