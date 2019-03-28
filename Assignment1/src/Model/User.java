package Model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String type;

    public User(){
    }

    public User(int id, String username, String password, String type) {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setRole(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
