package br.fiap.model;

import br.fiap.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    public void inserir(Categoria categoria){
        sql = "Insert into java_categoria values (?,?)";

        try(Connection connection = Conexao.conectar()){
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,categoria.getId());
            preparedStatement.setString(2,categoria.getCategoria());
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println("Erro na inserção da categoria \n"+e);
        }
    }

    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        sql = "select * from java_categoria";
        try(Connection connection = Conexao.conectar()){
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                lista.add(new Categoria(resultSet.getLong("id_categoria"),resultSet.getNString("categoria")));
            }
        }catch (SQLException e){
            System.out.println("Erro no nome da tabela ou listar as categorias.\n"+e);
        }
        return lista;
    }



}
