package designPatterns.behavioral.jobPostings;

import java.util.ArrayList;
import java.util.List;

public class Company implements Subject {
    private String name;
    private List<Observer> observerList;
    private List<String> internships;

    public Company(String name) {
        this.name = name;
        observerList = new ArrayList<>();
        internships = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int indexOf = observerList.indexOf(observer);
        if (indexOf >= 0)
            observerList.remove(indexOf);
    }

    public void addInternship(String jobDescription) {
        internships.add(jobDescription);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList) {
            o.update(getInfo());
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(System.lineSeparator());
        for (String internship: internships) {
            sb.append(internship + System.lineSeparator());
        }
        return sb.toString();
    }
}
