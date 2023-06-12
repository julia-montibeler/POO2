public class ItemPedido {
    private Item item;
    private int quantidade;

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public void adicionarItem() {
        this.quantidade++;
    }

    public void tirarItem() {
        if (quantidade > 0) {
            this.quantidade--;
        }
    }

    public Item getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
