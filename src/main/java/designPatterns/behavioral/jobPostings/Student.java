package designPatterns.behavioral.jobPostings;

public class Student implements  Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String info) {
        System.out.println(name + ": Great! I will go apply for this internship now!");
        System.out.println(info);

        // apply for a job - not shown here
    }


}
