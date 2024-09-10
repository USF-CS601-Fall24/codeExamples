package inheritance.usfDatabase;

public class USFStaff extends USFEmployee {
    private int numVacationDays;

    public USFStaff(String name, String id, int num, int numVacationDays) {
        super(name, id, num);
        this.numVacationDays = numVacationDays;
    }
    @Override
    protected void print() {
        super.print();
        System.out.println("Number of vacation days: " + numVacationDays);
    }

    // other methods

}
