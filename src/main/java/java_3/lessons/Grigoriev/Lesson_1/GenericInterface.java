package java_3.lessons.Grigoriev.Lesson_1;

public interface GenericInterface<M> {

    M doSomthing(M request);

    class GenClass1<M> implements GenericInterface<M> {

        @Override
        public M doSomthing(M request) {
            return null;
        }
    }

    class GenClass2 implements GenericInterface<String> {

        @Override
        public String doSomthing(String request) {
            return null;
        }
    }

    class GenClass3 implements GenericInterface {

        @Override
        public Object doSomthing(Object request) {
            return null;
        }
    }
}
