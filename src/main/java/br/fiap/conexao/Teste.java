package br.fiap.conexao;
import br.fiap.model.Categoria;
import br.fiap.model.CategoriaDAO;
import br.fiap.model.Despesa;
import br.fiap.model.DespesaDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teste {
    public static void main(String[] args) {

        DespesaDAO desp = new DespesaDAO();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Despesa despesa = new Despesa();
        despesa.setId(190L);
        despesa.setDescricao("Lanche na fiap");
        despesa.setValor(12.00);
        despesa.setData(LocalDate.parse("21/08/2025",date));
        despesa.setCategoria(new Categoria(8L,""));
        desp.inserir(despesa);


        desp.listar().forEach( d -> System.out.println(d.getId()+" "+d.getDescricao()+"  "+
                d.getValor()+"  "+d.getData()+"  "+d.getCategoria().getId()));
    }
}
