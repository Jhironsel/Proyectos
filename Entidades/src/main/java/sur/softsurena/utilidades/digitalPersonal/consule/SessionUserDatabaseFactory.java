package sur.softsurena.utilidades.digitalPersonal.consule;

import com.digitalpersona.onetouch.DPFPFingerIndex;
import com.digitalpersona.onetouch.DPFPTemplate;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation UserDatabase.Factory interface that produce instances of in-memory user database
 * without serialization.
 */
public class SessionUserDatabaseFactory implements UserDatabase.Factory {

    @Override
    public UserDatabase createDB() {
        return new SessionUserDatabase();
    }

    /**
     * In-memory user database without serialization
     */
    private static class SessionUserDatabase implements UserDatabase {
        private final Map<String, User> db = new HashMap<>();

        /**
         * Adds a user to the database
         *
         * @param username user to be added
         * @return user added
         */
        @Override
        public User addUser(String username) {
            User ret = new UserImpl(username);
            db.put(username, ret);
            return ret;
        }

        /**
         * Finds a user by name
         *
         * @param username user to find
         * @return user found, or <code>null</code> if not found)
         */
        @Override
        public User getUser(String username) {
            return db.get(username);
        }

        /**
         * In-memory implementation of UserImpl interface
         */
        private static class UserImpl implements User {
            private final String username;
            private final EnumMap<DPFPFingerIndex, DPFPTemplate> templates;

            public UserImpl(String username) {
                this.username = username;
                templates = new EnumMap<>(DPFPFingerIndex.class);
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public DPFPTemplate getTemplate(DPFPFingerIndex finger) {
                return templates.get(finger);
            }

            @Override
            public void setTemplate(DPFPFingerIndex finger, DPFPTemplate template) {
                templates.put(finger, template);
            }

            @Override
            public boolean isEmpty() {
                return templates.isEmpty();
            }

        }
    }
}
