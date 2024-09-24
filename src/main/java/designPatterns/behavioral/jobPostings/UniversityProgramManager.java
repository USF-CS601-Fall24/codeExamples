package designPatterns.behavioral.jobPostings;

public class UniversityProgramManager implements Observer {
    private String name;
    private String university;

    public UniversityProgramManager(String name, String university) {
        this.name = name;
        this.university = university;
    }

    @Override
    public void update(String jobDescr ) {
        if (jobDescr.contains("software development")) {
            // SEND TO the mailing list
            System.out.println(name + ": Post to the student mailing list");
        }
    }
}
