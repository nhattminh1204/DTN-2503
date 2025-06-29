package Proxy_2;

public class User {
    private final String name;
    private final String role; // admin, guest, ...

    public User(String name, String role) {
        this.name = name;
        this.role = role.toLowerCase();
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
