package vdmvctrenlop;

public class LoginModel {
    private String name;
    private String password;

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate() {
        return "admin".equals(password);
    }
}
