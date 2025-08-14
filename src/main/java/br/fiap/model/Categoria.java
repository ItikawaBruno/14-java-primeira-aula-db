package br.fiap.model;

public class Categoria {

    private Long id;
    private String categoria;

    public Categoria(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "CategoriaDAO{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
