package java_3.lessons.Lesson_1_Gusev;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Посчитать статистику
 */
public class Stats<T extends Number> {
    private T[] nums;

    public Stats(T... nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    /**
     * Сравнить два объекта статистики
     *
     * @param another
     * @return
     */
    boolean isSameAvg(Stats<?> another) {
        return Math.abs(this.avg() - another.avg()) < 0.00001; //BigDecimal
    }

    boolean isSameAvgList(List<? extends Number> another) {
        return true;
    }

    <V extends Number> boolean isSameAvgListTyped(List<V> another) {
        return true;
    }

    boolean isSameAvgListSuper(List<? super Number> another) {
        return true;
    }


    static class StatsApp {
        public static void main(String[] args) {
            Stats<Integer> statsInt = new Stats<>(1, 2, 3, 4, 5);//new int[] {}
            Stats<Integer> statsInt2 = new Stats<>(1, 2, 3);
            Stats<Double> statsDouble2 = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);

//            Stats<String> stats = new Stats<String>("2", "3"); так нельзя т.к. extends Number

            System.out.println("stats int1 " + statsInt.avg());
            System.out.println("stats int2 " + statsInt2.avg());
            System.out.println("stats double " + statsDouble2.avg());

            System.out.println("int1 == int2 - " + statsInt.isSameAvg(statsInt2));
            System.out.println("int1 == double - " + statsInt.isSameAvg(statsDouble2));

            List<String> stringList = new ArrayList<>();
            List<Object> objects = new LinkedList<>();
            List<Integer> integers = new LinkedList<>();

            statsInt.isSameAvgList(integers);
//            statsInt.isSameAvgList(stringList); //нельзя, в методе стоит ? extends Number

            statsInt.isSameAvgListSuper(objects);
        }
    }
}
