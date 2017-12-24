public class User {
    private String _login;
    private String _password;

    User(String login, String password){
        _login = login;
        _password = password;
    }

    public String getLogin() {
        return _login;
    }

    public String getPassword() {
        return _password;
    }

}
