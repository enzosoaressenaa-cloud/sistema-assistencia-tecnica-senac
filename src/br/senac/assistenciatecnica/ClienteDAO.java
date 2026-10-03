package br.senac.assistenciatecnica;
import java.sql.*;import java.util.*;
public class ClienteDAO {
 public List<Cliente> listar() throws SQLException{List<Cliente> l=new ArrayList<>();String q="SELECT * FROM cliente ORDER BY id";try(Connection c=ConexaoMySQL.conectar();PreparedStatement p=c.prepareStatement(q);ResultSet r=p.executeQuery()){while(r.next())l.add(new Cliente(r.getInt("id"),r.getString("nome"),r.getString("cpf"),r.getString("telefone"),r.getString("email")));}return l;}
 public void inserir(Cliente x)throws SQLException{String q="INSERT INTO cliente(nome,cpf,telefone,email) VALUES(?,?,?,?)";try(Connection c=ConexaoMySQL.conectar();PreparedStatement p=c.prepareStatement(q)){p.setString(1,x.getNome());p.setString(2,x.getCpf());p.setString(3,x.getTelefone());p.setString(4,x.getEmail());p.executeUpdate();}}
 public void excluir(int id)throws SQLException{try(Connection c=ConexaoMySQL.conectar();PreparedStatement p=c.prepareStatement("DELETE FROM cliente WHERE id=?")){p.setInt(1,id);p.executeUpdate();}}
}