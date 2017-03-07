/**
 * Created by Ирина on 07.03.2017.
 *
 * Lazy initialization
 *
 */
public class Singleton {
    static class SingletonHolder{
        private static Singleton INSTANCE = new Singleton();

        public Singleton getInstance(){
            return INSTANCE;
        }
    }
}
