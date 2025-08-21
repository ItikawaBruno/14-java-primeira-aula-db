package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private final static String USERNAME = "";
    private final static String PASSWORD = "";

    private Conexao() {}

    public static Connection conectar(){
        try{
            Connection d =DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Conectou!");
            return d;
        }catch(SQLException e){
            System.out.println("Erro ao conectar com banco: \n"+e);
        }
        return null;
    }

}
