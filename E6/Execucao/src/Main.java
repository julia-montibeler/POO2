import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Retangulo retangulo = new Retangulo(8, 5);

        Class c = retangulo.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("A área do retângulo é: "+methods[0].invoke(retangulo));
    }
}
