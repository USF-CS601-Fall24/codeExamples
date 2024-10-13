package designPatterns.behavioral.observerExerciseSolution;

public class CaltrainDriver {
    public static void main(String[] args) {
        Subject trainManager = new Caltrain();

        Observer passenger1 = new Passenger("Fatima", 403, trainManager);
        Observer passenger2 = new Passenger("Priya", 702, trainManager);
        Observer passenger3 = new Passenger("Shulin", 753, trainManager);

        trainManager.registerObserver(passenger1);
        trainManager.registerObserver(passenger2);
        trainManager.registerObserver(passenger3);

        ((Caltrain)trainManager).updateDelay(401, 10);
        System.out.println();
        ((Caltrain)trainManager).updateDelay(702, 5);

        System.out.println();
        ((Caltrain)trainManager).updateDelay(753, 8);

        System.out.println();
        ((Caltrain)trainManager).updateDelay(702, 10);


         /* It should print:
        Fatima: Glad to know my train is still on time
        Priya: Glad to know my train is still on time
        Shulin: Glad to know my train is still on time

        Fatima: Glad to know my train is still on time
        Priya: I will wait - the train should be here soon
        Shulin: Glad to know my train is still on time

        Fatima: Glad to know my train is still on time
        Priya: I will wait - the train should be here soon
        Shulin: I will wait - the train should be here soon

        Fatima: Glad to know my train is still on time
        Priya: Bummer, that's too long, I have to take Uber instead.
        Shulin: I will wait - the train should be here soon
         */

    }
}
