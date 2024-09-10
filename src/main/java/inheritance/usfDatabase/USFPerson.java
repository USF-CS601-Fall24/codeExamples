package inheritance.usfDatabase;

public class USFPerson {
    private String name;
    private String id;

    public USFPerson(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    protected void print() {
        System.out.println("Name = " + name);
        System.out.println("ID = " + id);
    }

    // other methods
}
