package br.fiap.conexao;
import br.fiap.model.CategoriaDAO;

public class Teste {
    public static void main(String[] args) {

        CategoriaDAO cat = new CategoriaDAO();
//        cat.inserir(new Categoria(8L,"moradia"));
        cat.listar().forEach(c -> System.out.println(c.getId()+" --> "+c.getCategoria()));
        System.out.println("Inserido.");

    }
}
