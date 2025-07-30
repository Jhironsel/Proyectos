package sur.softsurena.utilidades.digitalPersonal.consule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Creates UserInterface and UserDatabase instances and runs UserInterface.
 */
public class SampleApp {
    private final static String DEFAULT_UI_FACTORY = "sur.softsurena.utilidades.digitalPersonal.consule.ConsoleUserInterfaceFactory";
    private final static String DEFAULT_DB_FACTORY = "sur.softsurena.utilidades.digitalPersonal.consule.SessionUserDatabaseFactory";

    public static void main (String[] args) {

        try (var cache = Executors.newCachedThreadPool();){
            UserDatabase.Factory dbFactory =  
                    (UserDatabase.Factory) Class.forName(DEFAULT_DB_FACTORY).newInstance();
            
            UserDatabase userDatabase = dbFactory.createDB();

            UserInterface.Factory uiFactory = 
                    (UserInterface.Factory) Class.forName(DEFAULT_UI_FACTORY).newInstance();
            
            UserInterface userInterface = uiFactory.createUI(userDatabase);

            ExecutorService exec = cache;
            exec.execute(userInterface);

            exec.shutdown();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            
        }
    }
}
