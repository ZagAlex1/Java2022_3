package java_3.homeworks.HomeWork_1;

import java.util.Arrays;

public class Orange extends Fruit {
    private float weight;

    public Orange(float weight) {
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
        return "(Orange " + weight + ')';
    }
}
