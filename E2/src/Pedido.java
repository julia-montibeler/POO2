import java.util.ArrayList;

public class Pedido {
    private String cliente;
    private ArrayList<ItemPedido> itens = new ArrayList<>();

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public void addItem (ItemPedido item) {
        itens.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (ItemPedido i : itens) {
            total += (i.getItem().getPreco()) * i.getQuantidade();
        }
        return total;
    }
}
