package java_3.lessons.Gusev.Lesson_1_Gusev;

/**
 * Реализовать класс - хранилище для объектов.
 */

public class SimpleContainer {
    private Object object;

    public SimpleContainer(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
