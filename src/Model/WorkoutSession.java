package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class WorkoutSession {
    private LocalDate date;
    private List<String> workoutsHistory=new ArrayList<>();
    private String programName;

    public WorkoutSession(WorkoutProgram workout){
        this.date=LocalDate.now();
        this.programName=workout.getWorkoutName();
        for (int i=0; i<workout.getExercisesList().size(); i++){
            AssignedExercises exercises =workout.getExercisesList().get(i);
            String info="Упражнение: " + exercises.getExerciseName() + " "
                    + exercises.getWeight()
                    + " кг " + exercises.getActualRepetitions().size() + " подхода по "
                    + exercises.getActualRepetitions() + " повторений";

            workoutsHistory.add(info);
        }
    }

    public void printWorkoutHistory() {
        System.out.println("Тренировка: " + programName);
        System.out.println(date + " ");
        for (int i=0; i<workoutsHistory.size(); i++){
            System.out.println(workoutsHistory.get(i));
        }
    }
}
