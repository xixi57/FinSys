import java.util.HashMap;

/**
 * Created by raoyinchen on 3/5/17.
 */
public class Login {

    private static HashMap<String, String> usertable = new HashMap<>();
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (usertable.containsKey(username) && usertable.get(username).equals(password)) {
            return true;
        }
        return false;
    }
    public static void register(String username, String password) {
        usertable.put(username,password);
    }
}
