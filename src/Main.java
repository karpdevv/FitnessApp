import Model.AssignedExercises;
import Model.AvailableExercises;
import Model.WorkoutProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        runMenu();







    }

    public static void createWorkout (Scanner cin){
        boolean addMore=true;
        System.out.println("Введите название программы");
        String workoutName = cin.nextLine();
        WorkoutProgram workout = new WorkoutProgram(workoutName);

        while (addMore) {
            workout.addExercise(assignExercise(cin));
            System.out.println("Добавить еще упражнение? (Да/Нет)");
            String question=cin.nextLine();
            if (question.equals("Нет")){
                addMore=false;
            }
        }


    }

    public static AssignedExercises assignExercise(Scanner cin){
        AvailableExercises[] exercises=AvailableExercises.values();
        System.out.println("Выберите номер упражнения для добавления в программу");
        showExercises();
        int choice=cin.nextInt();
        cin.nextLine();
        System.out.println("Количество подходов: ");
        int sets=cin.nextInt();
        cin.nextLine();
        System.out.println("Количество повторений");
        int reps=cin.nextInt();
        cin.nextLine();
        System.out.println("Вес");
        double weight=cin.nextDouble();
        cin.nextLine();
        AssignedExercises exercise=new AssignedExercises(exercises[choice-1], reps, sets, weight);
        return (exercise);

    }




    public static void runMenu(){
        boolean exit=true;
        Scanner cin=new Scanner(System.in);
        while(exit){
            showMenu();
            int menuChoice=cin.nextInt();
            cin.nextLine();
            switch(menuChoice){
                case 1 -> showExercises();
                case 2 -> createWorkout(cin);
                case 3 -> goToWorkouts(cin);
                case 5 -> {
                    exit=false;
                    System.out.println("Всего доброго, до свидания!");
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }

    public static void goToWorkouts(Scanner cin){
//        if (programs.isEmpty()){
//            System.out.println("Программ нет");
//        }
//        else {
//            for (int i=0; i<programs.size(); i++){
//                System.out.printf("%s\n", programs.get(i).getWorkoutName());
//                System.out.println();
//                programs.get(i).printExercisesList();
//            }
//
//        }

    }

    public static void showExercises(){
        AvailableExercises [] exercises=AvailableExercises.values();
        for (int i=0; i<exercises.length; i++){
            System.out.printf("%d. %s \n", i+1, exercises[i].getExercise());
        }
        System.out.println();
    }

    public static void showMenu(){
        System.out.println("Добро пожаловать в FitnessApp. Выберите дальнейшие действия\n"+
                "1. Просмотр доступных упражнений \n2. Создать новую программу \n" +
                "3. Перейти к существующей программе \n" +
                "4. Просмотр последней тренировки \n" +
                "5. Выйти из программы\n");
    }
}