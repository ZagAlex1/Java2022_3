package java_3.lessons.Grigoriev.Lesson_3;

import java.io.Serializable;

public class Animal implements Serializable{

    private String type;

    public Animal(String type) {
//        this.type = type;
        System.out.println("Animal born");
    }
}
