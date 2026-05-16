package Model;

import java.util.ArrayList;
import java.util.List;

public class AssignedExercises {
    private AvailableExercises exerciseType;
    private int plannedRepetitions;
    private int plannedSets;
    private double weight;
    private List<Integer> actualRepetitions=new ArrayList<>();

    public AssignedExercises(AvailableExercises exerciseType, int plannedRepetitions,
                      int plannedSets, double weight){
        this.exerciseType=exerciseType;
        this.plannedRepetitions=plannedRepetitions;
        this.plannedSets=plannedSets;
        this.weight=weight;
    }

    public String getExerciseName(){
        return exerciseType.getExercise();
    }

    public AvailableExercises getExerciseType() {
        return exerciseType;
    }

    public int getPlannedRepetitions() {
        return plannedRepetitions;
    }

    public int getPlannedSets() {
        return plannedSets;
    }

    public double getWeight() {
        return weight;
    }

    public List<Integer> getActualRepetitions() {
        return actualRepetitions;
    }

    public void recordSet(int count){
        actualRepetitions.add(count);
    }

    public boolean isComplete(){
        return actualRepetitions.size()==plannedSets;
    }


}
