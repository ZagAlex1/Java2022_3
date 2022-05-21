package java_3.lessons.Gusev.Lesson_1_Gusev;

public class TypedContainer<T> {
    private T obj;

    public TypedContainer(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * Напечатать тип хранимого объекта
     */
    void showType() {
        System.out.println("Type is " + obj.getClass().getName());
    }
}
