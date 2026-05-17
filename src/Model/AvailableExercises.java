package Model;

public enum AvailableExercises {
    BENCH_PRESS("Жим штанги лежа"),
    OVERHEAD_PRESS("Армейский жим"),
    SQUAT("Приседания со штангой"),
    LAT_PULLDOWN("Тяга верхнего блока"),
    SEATED_CABLE_ROW("Тяга нижнего блока"),
    BICEPS_CURLS("Сгибания на бицепс"),
    HAMMER_CURLS("Молотковые сгибания"),
    HYPEREXTENSION("Гиперэкстензия"),
    TRICEPS_CURLS("Французский жим"),
    NORDIC_CURLS("Разгибания на бицепс бедра (Нордик)"),
    CAPTAIN_CHAIR("Капитанский стул");




    private final String exercise;
    AvailableExercises(String exercise){
        this.exercise=exercise;
    }

    public String getExercise() {
        return exercise;
    }

    public static void showExercises(){
        AvailableExercises [] exercises=AvailableExercises.values();
        for (int i=0; i<exercises.length; i++){
            System.out.printf("%d. %s \n", i+1, exercises[i].getExercise());
        }
        System.out.println();
    }

}
