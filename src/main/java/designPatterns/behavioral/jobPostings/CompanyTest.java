package designPatterns.behavioral.jobPostings;

public class CompanyTest {
    public static void main(String[] args) {
        Subject company = new Company("Vrbo");
        Observer o1 = new Student("Aarthi P.");
        Observer o2 = new Student("Tracy L.");
        Observer o3 = new Student("Hao C.");

        company.registerObserver(o1);
        company.registerObserver(o2);
        company.registerObserver(o3);

        Observer o4 = new UniversityProgramManager("Jim Harry", "USF");
        company.registerObserver(o4);

        // If the company has jobs, it will notify those who are registered as observers
        ((Company)company).addInternship("Looking for a software development intern experienced in Node.js.");
        // addInternship will call notifyObservers

        company.removeObserver(o1);
        ((Company)company).addInternship("Opening for a software engineering intern with experience in React.js");



    }
}
