package fr.mine.Grade;

public class Grade {

    private String name;
    private String prefix;
    private String permission;

    public Grade() { this.name = "default";}

    public Grade(String name, String prefix, String permission){
        this.name = name;
        this.prefix = prefix;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
