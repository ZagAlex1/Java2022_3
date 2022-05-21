package java_3.lessons.Gusev.Lesson_1_Gusev;

public class TypeContainerApp {
    public static void main(String[] args) {
        TypedContainer<Integer> container1 = new TypedContainer<>(42);
        TypedContainer<Integer> container2 = new TypedContainer<>(197);
        System.out.println(container1.getObj() + container2.getObj());

        int c1 = container1.getObj();

        TypedContainer<String> stringTypedContainer = new TypedContainer<>("typedString");

        String string = stringTypedContainer.getObj();
        System.out.println(string);

        container1.showType();
        stringTypedContainer.showType();

        TwoTypesContainer<String, Integer> twoTypesContainer = new TwoTypesContainer<>("str", 100);
        twoTypesContainer.showType();
    }
}
