package Service;

import Model.AssignedExercises;
import Model.AvailableExercises;
import Model.WorkoutProgram;
import Model.WorkoutSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tracker {
    List<WorkoutProgram> workoutProgramList = new ArrayList<>();
    List<WorkoutSession> workoutSessions = new ArrayList<>();
    Scanner cin = new Scanner(System.in);


    public void createWorkout() {
        boolean addMore = true;
        System.out.println("Введите название программы");
        String workoutName = cin.nextLine();
        WorkoutProgram workout = new WorkoutProgram(workoutName);
        while (addMore) {
            workout.addExercise(assignExercise());
            System.out.println("Добавить еще упражнение? (Да/Нет)");
            String question = cin.nextLine();
            if (question.equals("Нет")) {
                addMore = false;
            }
        }
        workoutProgramList.add(workout);
    }


    public AssignedExercises assignExercise() {
        AvailableExercises[] exercises = AvailableExercises.values();
        System.out.println("Выберите номер упражнения для добавления в программу");
        AvailableExercises.showExercises();
        int choice = cin.nextInt();
        cin.nextLine();
        System.out.println("Количество подходов: ");
        int sets = cin.nextInt();
        cin.nextLine();
        System.out.println("Количество повторений");
        int reps = cin.nextInt();
        cin.nextLine();
        System.out.println("Вес");
        double weight = cin.nextDouble();
        cin.nextLine();
        AssignedExercises exercise = new AssignedExercises(exercises[choice - 1], reps, sets, weight);
        return (exercise);
    }



    public void printWorkoutExercises() {
        System.out.println("Выберите номер конкретной тренировки для просмотра упражнений");
        int choice=cin.nextInt() -1;
        cin.nextLine();
        workoutProgramList.get(choice).printExercisesList();
        System.out.println();
    }




    public void goToWorkout(){
        printWorkouts();
        int choice;
        boolean isContinue=true;
        while (isContinue){
            printGoToWorkoutMenu();
            choice=cin.nextInt(); cin.nextLine();
            switch(choice){
                case 1 -> startWorkout();
                case 2 -> printWorkoutExercises();
                case 3 -> isContinue=false;
                default -> System.out.println("Такого пункта нет в меню");
            }
        }
    }

    public void printGoToWorkoutMenu(){
        System.out.println("Выберите дальнейшие действия: \n" +
                "1. Начать тренировку\n" +
                "2. Просмотр упражнений в программе\n" +
                "3. Выход");
    }

    public void printWorkouts() {
        if (workoutProgramList.isEmpty()) {
            System.out.println("Программ нет");
        } else {
            System.out.println("Доступны следующие тренировки:");
            for (int i = 0; i < workoutProgramList.size(); i++) {
                System.out.printf("%d.%s\n",i+1, workoutProgramList.get(i).getWorkoutName());
            }
        }
        System.out.println();
    }

    public void startWorkout() {
        System.out.println("Выберите номер тренировки");
        int choice = cin.nextInt();
        cin.nextLine();
        List<AssignedExercises> exercises = workoutProgramList.get(choice - 1).getExercisesList();
        for (int i = 0; i < exercises.size(); i++) {
            for (int j = 0; j < exercises.get(i).getPlannedSets(); j++) {
                System.out.println("Подход: " + j + 1);
                System.out.println("Упражнение: " + exercises.get(i).getExerciseName());
                System.out.println("Количество повторений: " + exercises.get(i).getPlannedRepetitions());
                System.out.println("Вес: " + exercises.get(i).getWeight());
                System.out.println("\nСколько повторений выполнено?");
                exercises.get(i).recordSet(cin.nextInt());
                cin.nextLine();
            }
            System.out.printf("В упражнении: %s выполнено:\n", exercises.get(i).getExerciseName());
            for (int j = 0; j < exercises.get(i).getActualRepetitions().size(); j++) {
                System.out.printf("%d подход: %d\n", (j + 1), exercises.get(i).getActualRepetitions().get(j));
            }
        }
        System.out.println("Поздравляю! Тренировка завершена");


    }
}

