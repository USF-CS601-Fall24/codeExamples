package designPatterns.behavioral.observerExerciseSolution;

import java.util.*;

/** Represents a transportation agency like Caltrain that runs the trains.
 * Implements the Subject interface. */
public class Caltrain implements Subject {
   //  hashmap where the key is the train #, and the value
   public Map<Integer, Integer> trains = new HashMap<>(); // stores a delay in minutes for each train
   public List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int ind = -1;
        if ((ind = observers.indexOf(observer)) > 0)
            observers.remove(ind);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs: observers) {
            obs.update();
        }
    }

    public Integer getDelayInfo(int trainNumber) {
        return trains.get(trainNumber);
    }

    public boolean isOnTime(int trainNumber) {
        return !trains.containsKey(trainNumber);
    }

    public void updateDelay(int trainNumber, int additionalDelay) {
        if (trains.containsKey(trainNumber)) {
            trains.put(trainNumber, trains.get(trainNumber) + additionalDelay);
        }
        else
            trains.put(trainNumber, additionalDelay);
        notifyObservers();
    }
}

