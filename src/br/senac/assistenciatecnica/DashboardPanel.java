package br.senac.assistenciatecnica;
import javax.swing.*;import java.awt.*;import java.sql.*;
public class DashboardPanel extends JPanel{
 public DashboardPanel(){setLayout(new BorderLayout(15,15));setBorder(BorderFactory.createEmptyBorder(25,25,25,25));JLabel h=new JLabel("Dashboard");h.setFont(new Font("SansSerif",1,28));add(h,BorderLayout.NORTH);JPanel cards=new JPanel(new GridLayout(1,3,15,15));try(Connection c=ConexaoMySQL.conectar();Statement s=c.createStatement()){cards.add(card("Clientes",count(s,"cliente")));cards.add(card("Equipamentos",count(s,"equipamento")));cards.add(card("Ordens abertas",countWhere(s,"ordem_servico","status='ABERTA'")));}catch(SQLException e){cards.add(card("Banco","offline"));}add(cards,BorderLayout.CENTER);}
 String count(Statement s,String t)throws SQLException{try(ResultSet r=s.executeQuery("SELECT COUNT(*) FROM "+t)){r.next();return r.getString(1);}}
 String countWhere(Statement s,String t,String w)throws SQLException{try(ResultSet r=s.executeQuery("SELECT COUNT(*) FROM "+t+" WHERE "+w)){r.next();return r.getString(1);}}
 JPanel card(String a,String b){JPanel p=new JPanel(new GridLayout(2,1));p.setBorder(BorderFactory.createLineBorder(new Color(154,168,181)));JLabel x=new JLabel(a,SwingConstants.CENTER),y=new JLabel(b,SwingConstants.CENTER);y.setFont(new Font("SansSerif",1,28));p.add(x);p.add(y);return p;}
}