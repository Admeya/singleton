/**
 * Created by Ирина on 07.03.2017.
 */
public enum SingletonEnum {
    INSTANCE;
    private Object obj = null;
    public Object createInstance(){
        if (obj == null){
            obj = new Object();
        }
        return obj;
    }
}
