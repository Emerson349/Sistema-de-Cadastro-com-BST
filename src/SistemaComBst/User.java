package SistemaComBst;

import java.util.Objects;

public class User{
    private String name;
    private int id;
    private String email;
    private User left;
    private User right;

    public User(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public User getLeft() {
        return left;
    }

    public User getRight() {
        return right;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(User left) {
        this.left = left;
    }

    public void setRight(User right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Nome: " + name + "\nEmail: " + email + "\n" + "Id: " + id + "\n";
    }
}
