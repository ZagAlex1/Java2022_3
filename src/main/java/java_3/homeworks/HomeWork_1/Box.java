package java_3.homeworks.HomeWork_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<B extends Fruit> {
    private List<B> fruits;

    public Box(B... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public List<B> getFruits() {
        return fruits;
    }

    public void setFruits(List<B> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(B fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        float sum = 0.0f;
        for (B fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public void getWeightInfo() {
        System.out.println("Box weight : " + getWeight());
    }

    public boolean compareBox(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
    }

    public void replaceFruits(Box<B> another) {
        if (this == another) {
            return;
        } else {
            another.fruits.addAll(fruits);
        }
        fruits.clear();
    }

    @Override
    public String toString() {
        return "Fruits : " + fruits;
    }
}

