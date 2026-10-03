package br.senac.assistenciatecnica;
import java.sql.*;import java.util.*;
public class EquipamentoDAO {
 public List<Equipamento> listar()throws SQLException{List<Equipamento> l=new ArrayList<>();String q="SELECT e.*,c.nome cliente_nome FROM equipamento e JOIN cliente c ON c.id=e.cliente_id ORDER BY e.id";try(Connection c=ConexaoMySQL.conectar();PreparedStatement p=c.prepareStatement(q);ResultSet r=p.executeQuery()){while(r.next())l.add(new Equipamento(r.getInt("id"),r.getString("tipo"),r.getString("marca"),r.getString("modelo"),r.getString("numero_serie"),r.getInt("cliente_id"),r.getString("cliente_nome")));}return l;}
}