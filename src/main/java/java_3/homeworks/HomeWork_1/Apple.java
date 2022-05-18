package java_3.homeworks.HomeWork_1;

import java.util.Arrays;

public class Apple extends Fruit {
    private float weight;

    public Apple(float weight) {
        super(weight);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(Apple " + weight + ')';
    }
}
