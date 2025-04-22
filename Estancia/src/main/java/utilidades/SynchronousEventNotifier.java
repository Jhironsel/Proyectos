package utilidades;

import org.firebirdsql.event.EventManager;
import org.firebirdsql.event.FBEventManager;
import org.firebirdsql.gds.impl.GDSType;

import java.sql.SQLException;

public class SynchronousEventNotifier {

    private EventManager eventManager;
    private static final int TIMEOUT = 10000;

    public SynchronousEventNotifier(String database, String user, String pass) {
        eventManager = new FBEventManager(GDSType.getType("PURE_JAVA"));
        eventManager.setDatabase(database);
        eventManager.setUser(user);
        eventManager.setPassword(pass);
    }

    public void run(String eventName) {
        int eventCount = 0;
        try {
            eventManager.connect();
            System.out.println("Waiting for events");
            while (eventCount < 3) {
                try {
                    int count = eventManager.waitForEvent(eventName, TIMEOUT);
                    if (count == -1) {
                        System.out.println("Timed out");
                        break;
                    }
                    eventCount += count;
                    System.out.println("Received " + count + " instance(s) "
                            + "of event '" + eventName + "', total is "
                            + eventCount);
                } catch (InterruptedException ie) {
                    throw new RuntimeException(ie);
                }
            }
            eventManager.disconnect();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    public static void main(String[] args) {
        String database = "C:\\Users\\Administrator\\Desktop\\FACTURACION.FDB";
        String userName = "SYSDBA";
        String password = "masterkey";
        String eventName = "Jhironsel";

        SynchronousEventNotifier eventNotifier
                = new SynchronousEventNotifier(database, userName, password);
        eventNotifier.run(eventName);
    }
}
