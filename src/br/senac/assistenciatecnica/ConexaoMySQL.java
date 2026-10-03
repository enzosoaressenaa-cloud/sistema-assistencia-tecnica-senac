package br.senac.assistenciatecnica;
import java.sql.*;
public class ConexaoMySQL {
 private static final String URL="jdbc:mysql://localhost:3306/assistencia_tecnica?useSSL=false&serverTimezone=UTC";
 private static final String USUARIO="root"; private static final String SENHA="";
 public static Connection conectar() throws SQLException{return DriverManager.getConnection(URL,USUARIO,SENHA);}
}