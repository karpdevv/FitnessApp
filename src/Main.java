import Model.AssignedExercises;
import Model.AvailableExercises;
import Model.WorkoutProgram;
import Model.WorkoutSession;
import Service.Tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Service.Tracker.*;


public class Main {
    public static void main(String[] args) {
        runMenu();








    }





    public static void runMenu(){
        boolean exit=true;
        Tracker tracker=new Tracker();
        Scanner cin=new Scanner(System.in);
        while(exit){
            showMenu();
            int menuChoice=cin.nextInt();
            cin.nextLine();
            switch(menuChoice){
                case 1 -> AvailableExercises.showExercises();
                case 2 -> tracker.createWorkout();
                case 3 -> tracker.goToWorkout();
                case 4 -> tracker.printLastWorkout();
                case 5 -> {
                    exit=false;
                    System.out.println("Всего доброго, до свидания!");
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }




    public static void showMenu(){
        System.out.println("Добро пожаловать в FitnessApp. Выберите дальнейшие действия\n"+
                "1. Просмотр доступных упражнений \n2. Создать новую программу \n" +
                "3. Перейти к существующей программе \n" +
                "4. Просмотр последней тренировки \n" +
                "5. Выйти из программы\n");
    }
}