import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Livro l = new Livro("1", 32);
        Pedido p = new Pedido("a");
        ItemPedido ip = new ItemPedido(l, 2);

        InspecionarClasse(l.getClass());
        InspecionarClasse(p.getClass());
        InspecionarClasse(ip.getClass());

        ExecutarMetodosPedido(p, ip);
        ExecutarMetodosItemPedido(ip);

    }

    public static void InspecionarClasse(Class c) {
        Field[] atributos = c.getDeclaredFields();
        Method[] metodos = c.getDeclaredMethods();

        System.out.println(c);

        System.out.println("Atributos");
        for (Field f : atributos) {
            System.out.println(f);
        }

        System.out.println("Métodos");
        for (Method m : metodos) {
            System.out.println(m);
        }

        System.out.println("");
    }

    public static void ExecutarMetodosPedido (Pedido p, ItemPedido ip) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method metodo = p.getClass().getMethod("addItem", ItemPedido.class);
        metodo.invoke(p, ip);
        System.out.println("Item adicionado");
        metodo = p.getClass().getMethod("getTotal");
        System.out.println("Valor do pedido: " + metodo.invoke(p));

    }

    public static void ExecutarMetodosItemPedido (ItemPedido ip) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method metodo = ip.getClass().getMethod("adicionarItem");
        metodo.invoke(ip);

        metodo = ip.getClass().getMethod("tirarItem");
        metodo.invoke(ip);
    }
}
