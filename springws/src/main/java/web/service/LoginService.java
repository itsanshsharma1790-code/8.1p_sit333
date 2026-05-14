package web.service;

public class LoginService {

    public static boolean login(String username, String password, String dob) {

        System.out.println("Username received: " + username);
        System.out.println("Password received: " + password);
        System.out.println("DOB received: " + dob);

        if (username == null || password == null || dob == null) {
            return false;
        }

        username = username.trim();
        password = password.trim();
        dob = dob.trim();

        return username.equals("ansh")
                && password.equals("ansh_pass")
                && (dob.equals("2004-01-01") || dob.equals("01/01/2004"));
    }
}