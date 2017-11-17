package ohtu;

import java.util.List;

public class Submission {
    private int week;
    private int hours;
    private List<Integer> exercises;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public List<Integer> getExercises() {
        return exercises;
    }
    
    // viikko 1: tehtyjä tehtäviä yhteensä: 9, aikaa kului 3 tuntia, tehdyt tehtävät: 1 2 3 4 5 6 7 9 11
    @Override
    public String toString() {
        return "viikko "+ week + ": tehtyjä tehtäviä yhteensä: " + this.exercises.size() + ", aikaa kului "
                + this.hours + " tuntia, tehdyt tehtävät:" + this.printableExercises();
    }
    
    private String printableExercises() {
        String ex = "";
        for (int current : this.exercises) {
            ex += " " + current;
        }
        return ex;
    }
    
}