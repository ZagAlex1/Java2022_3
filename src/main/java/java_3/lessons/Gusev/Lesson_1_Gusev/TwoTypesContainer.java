package java_3.lessons.Gusev.Lesson_1_Gusev;

public class TwoTypesContainer<T, Y> {
    private T first;
    private Y second;

    public TwoTypesContainer(T first, Y second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }

    void showType() {
        System.out.println("First: " + first.getClass().getName() + " Second: " + second.getClass().getName());
    }
}
