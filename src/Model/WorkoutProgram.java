package Model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutProgram {
    private String workoutName;
    private List<AssignedExercises> exercisesList=new ArrayList<>();

    public WorkoutProgram(String workoutName){
        this.setWorkoutName(workoutName);
    }

    public void addExercise(AssignedExercises exercise){
        getExercisesList().add(exercise);
    }
    public void removeExercise(AssignedExercises exercise){
        getExercisesList().remove(exercise);
    }


    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void printExercisesList(){
        for (int i = 0; i< getExercisesList().size(); i++){
            System.out.printf("%d. %s\n", i+1, getExercisesList().get(i).getExerciseName());
        }
    }

    public List<AssignedExercises> getExercisesList() {
        return exercisesList;
    }
}


