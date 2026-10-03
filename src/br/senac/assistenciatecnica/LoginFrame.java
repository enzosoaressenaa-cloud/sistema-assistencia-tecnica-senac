package br.senac.assistenciatecnica;
import javax.swing.*;import java.awt.*;import java.sql.*;
public class LoginFrame extends JFrame{
 JTextField login=new JTextField("admin");JPasswordField senha=new JPasswordField("1234");
 public LoginFrame(){setTitle("Assistência Técnica - Login");setSize(520,380);setLocationRelativeTo(null);setDefaultCloseOperation(EXIT_ON_CLOSE);
 JPanel p=new JPanel(new GridLayout(5,1,8,8));p.setBorder(BorderFactory.createEmptyBorder(35,70,35,70));p.add(new JLabel("Acesso ao sistema",SwingConstants.CENTER));p.add(login);p.add(senha);JButton b=new JButton("Entrar");p.add(b);p.add(new JLabel("Banco: MySQL | admin / 1234",SwingConstants.CENTER));b.addActionListener(e->entrar());add(p);}
 void entrar(){try(Connection c=ConexaoMySQL.conectar();PreparedStatement p=c.prepareStatement("SELECT nome FROM usuario WHERE login=? AND senha=?")){p.setString(1,login.getText());p.setString(2,new String(senha.getPassword()));try(ResultSet r=p.executeQuery()){if(r.next()){dispose();new MainFrame(r.getString("nome")).setVisible(true);}else JOptionPane.showMessageDialog(this,"Login ou senha inválidos.");}}catch(SQLException e){JOptionPane.showMessageDialog(this,"Não foi possível conectar ao MySQL. Verifique o banco e o driver JDBC.\n"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);}}
}