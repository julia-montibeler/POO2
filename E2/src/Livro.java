public class Livro extends Item{

    private String autor;
    private int qtdePaginas;

    public Livro(String id, double preco) {
        super(id, preco);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQtdePaginas() {
        return qtdePaginas;
    }

    public void setQtdePaginas(int qtdePaginas) {
        this.qtdePaginas = qtdePaginas;
    }
}
