package java_3.lessons.Grigoriev.Lesson_1;

public class GenericBoxMultyType<X, Y, Z, A, B, C> {

    private X xObj;
    private Y yObj;
    private Z zObj;
    private A aObj;
    private B bObj;
    private C cObj;

    public GenericBoxMultyType(X xObj, Y yObj, Z zObj, A aObj, B bObj, C cObj) {
        this.xObj = xObj;
        this.yObj = yObj;
        this.zObj = zObj;
        this.aObj = aObj;
        this.bObj = bObj;
        this.cObj = cObj;
    }

    public X getxObj() {
        return xObj;
    }

    public void setxObj(X xObj) {
        this.xObj = xObj;
    }

    public Y getyObj() {
        return yObj;
    }

    public void setyObj(Y yObj) {
        this.yObj = yObj;
    }

    public Z getzObj() {
        return zObj;
    }

    public void setzObj(Z zObj) {
        this.zObj = zObj;
    }

    public A getaObj() {
        return aObj;
    }

    public void setaObj(A aObj) {
        this.aObj = aObj;
    }

    public B getbObj() {
        return bObj;
    }

    public void setbObj(B bObj) {
        this.bObj = bObj;
    }

    public C getcObj() {
        return cObj;
    }

    public void setcObj(C cObj) {
        this.cObj = cObj;
    }
}
