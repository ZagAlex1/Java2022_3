package java_3.homeworks.HomeWork_1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWorkApp {
    public static void main(String[] args) {
//      twoMethodsExample();
        boxExample();
    }

    private static void boxExample() {
        Box <Apple> appleBox = new Box<>(new Apple(1.0f), new Apple(1.1f));
        Box <Apple> appleBox1 = new Box<>(new Apple(1.0f), new Apple(1.1f));
        System.out.println(appleBox);
        Box <Orange> orangeBox = new Box<>(new Orange(1.0f), new Orange(1.1f));
        System.out.println(orangeBox);
        orangeBox.addFruit(new Orange(1.2f));
        System.out.println(orangeBox);
        orangeBox.getWeightInfo();
        System.out.println(appleBox.compareBox(appleBox1));
        appleBox.replaceFruits(appleBox1);
        System.out.println(appleBox1);
        System.out.println(appleBox);
    }

    private static void twoMethodsExample() {
        int[] array = {1, 2, 3, 4, 5};
        changeArrayElements(array, 0, 2);
        System.out.println(Arrays.toString(array));
        Integer[] array1 = {1, 2, 3, 4, 5};
        System.out.println(arrayTransform(array1));
    }

    public static int[] changeArrayElements(int[] arr, int first, int second) {
        for (int i = 0; i < arr.length; i++) {
            int buffer = arr[first];
            int buffer2 = arr[second];
            arr[second] = buffer;
            arr[first] = buffer2;
        }
        return arr;
    }

    public static List<Integer> arrayTransform(Integer[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
