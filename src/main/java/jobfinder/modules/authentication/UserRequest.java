package jobfinder.modules.authentication;

/**
 * Created by jiaweizhang on 2/29/16.
 */
public class UserRequest {
    private String email;
    private char[] password;

    public String getEmail() {
        return email;
    }

    public char[] getPassword() {
        return password;
    }
}
