package designPatterns.behavioral.observerExerciseSolution;

public class Passenger implements Observer {
    public final static int MAX_WAIT = 10; // Max time willing to wait  -  10 mins
    private String name;
    private int myTrainNumber;
    private Subject trainManager;

    public Passenger(String name, int myTrainNumber, Subject trainManager) {
        this.name = name;
        this.myTrainNumber = myTrainNumber;
        this.trainManager = trainManager;
    }

    public void update() {
        if (!((Caltrain)trainManager).isOnTime(myTrainNumber)) {
            if (((Caltrain)trainManager).getDelayInfo(myTrainNumber) > MAX_WAIT) {
                System.out.println(name + ": Bummer, that's too long, I have to take Uber instead. ");
            }
            else {
                System.out.println(name +  ": I will wait - the train should be here soon");
            }
        }
        else
            System.out.println(name + ": Glad to know my train is still on time");
    }
}
