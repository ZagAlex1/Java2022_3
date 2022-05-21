package java_3.lessons.Grigoriev.Lesson_1;

//T(ype) E(lement) K(ey) V(alue) N(umber)
//public class GenericBox<X, Y, Z>

public class GenericBox<TYPE> {

// private static TYPE staticField; - в Generic нет static переменных

    private TYPE obj;

    public GenericBox(TYPE obj) {
        this.obj = obj;
    }

    public GenericBox() {
        // obj = new TYPE();
        // TYPE[] arr = new TYPE[10];
    }

    public TYPE getObj() {
        return obj;
    }

    public void setObj(TYPE obj) {
        this.obj = obj;
    }
}
