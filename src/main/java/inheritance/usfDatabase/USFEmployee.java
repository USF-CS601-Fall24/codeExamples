package inheritance.usfDatabase;

public class USFEmployee extends USFPerson {
    private int officeNumber;

    public USFEmployee (String name, String id, int num) {
        super(name, id);
        this.officeNumber = num;
    }

    @Override
    protected void print() {
        super.print();
        System.out.println("Office=" + officeNumber);
    }


    // other methods
}

