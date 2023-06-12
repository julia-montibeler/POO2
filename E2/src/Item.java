public class Item {
    private String id;
    private double preco;

    public Item(String id, double preco) {
        this.id = id;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }
}
