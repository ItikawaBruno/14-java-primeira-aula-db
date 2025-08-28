package br.fiap.model;

import br.fiap.conexao.Conexao;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public void inserir(Despesa despesa){
        sql = "Insert into java_despesa values(seqd.nextval,?,?,?,?)";
        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
//            ps.setLong(1,despesa.getId());
            ps.setString(2, despesa.getDescricao());
            ps.setDouble(3,despesa.getValor());
            ps.setDate(4, Date.valueOf(despesa.getData()));
            ps.setLong(5,despesa.getCategoria().getId());
            ps.execute();
            System.out.println("passou");
        }catch (SQLException e){
            System.out.println("Erro ao inserir despesa: "+e+" aqui");
        }
    }

    public List<Despesa> listar(){
        List<Despesa> despesas = new ArrayList<>();
        sql = "select * from java_despesa";
        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Despesa despesa = new Despesa();
                despesa.setId(rs.getLong("id_despesa"));
                despesa.setDescricao(rs.getNString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                Date date = rs.getDate("data");
                despesa.setData(date.toLocalDate());
                despesa.setCategoria(new Categoria(rs.getLong("id_categoria"),""));
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            System.out.println("Erro aqui"+e);
        }
        return despesas;
    }

    public List<Despesa> listarRelatorio(){
        List<Despesa> lista = new ArrayList<>();
        sql = "select d.descricao, d.valor, d.data, c.categoria from java_despesa d\n" +
                "join java_categoria c on d.id_categoria = c.id_categoria";
        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Despesa despesa = new Despesa();
                despesa.setDescricao(rs.getNString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                Date date = rs.getDate("data");
                despesa.setData(date.toLocalDate());
                despesa.setCategoria(new Categoria(0L,rs.getString("categoria")));
                lista.add(despesa);
            }
        }catch(SQLException e){
            System.out.println("Erro no select join: "+e);
        };
        return lista;
    }

}
