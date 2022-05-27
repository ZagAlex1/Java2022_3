package java_3.lessons.Grigoriev.Lesson_3;

import java.io.Serializable;
import java.util.Objects;

public class Cat extends Animal implements Serializable {
    public static final long serialVersionUID = 3923913205108357932L;

    private transient final String priv = "priv";

    private String name;

    private String color;

    public Cat() {
        super("Cat");
        System.out.println("Cat born");
    }

    public Cat(String name, String color) {
        this();
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}
