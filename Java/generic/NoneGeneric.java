package Java.generic;

public class NoneGeneric {

    Object data;

    public Object add(Object data) {
        this.data = data;
        return data;
    }

    public Object get() {
        return data;
    }


}
