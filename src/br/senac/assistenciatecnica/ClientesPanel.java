package br.senac.assistenciatecnica;
import javax.swing.*;import javax.swing.table.*;import java.awt.*;import java.sql.*;
public class ClientesPanel extends JPanel{
 DefaultTableModel m;JTable t;JTextField nome=new JTextField(),cpf=new JTextField(),tel=new JTextField(),email=new JTextField();
 public ClientesPanel(){setLayout(new BorderLayout(10,10));setBorder(BorderFactory.createEmptyBorder(20,20,20,20));JLabel h=new JLabel("Clientes");h.setFont(new Font("SansSerif",1,26));add(h,BorderLayout.NORTH);
 JPanel f=new JPanel(new GridLayout(2,4,8,4));f.add(new JLabel("Nome"));f.add(new JLabel("CPF"));f.add(new JLabel("Telefone"));f.add(new JLabel("E-mail"));f.add(nome);f.add(cpf);f.add(tel);f.add(email);JButton save=new JButton("Salvar cliente");save.addActionListener(e->save());JPanel top=new JPanel(new BorderLayout());top.add(f);top.add(save,BorderLayout.SOUTH);add(top,BorderLayout.CENTER);
 m=new DefaultTableModel(new Object[]{"ID","Nome","CPF","Telefone","E-mail"},0);t=new JTable(m);refresh();add(new JScrollPane(t),BorderLayout.SOUTH);}
 void refresh(){m.setRowCount(0);try{for(Cliente c:new ClienteDAO().listar())m.addRow(new Object[]{c.getId(),c.getNome(),c.getCpf(),c.getTelefone(),c.getEmail()});}catch(SQLException e){err(e);}}
 void save(){if(nome.getText().isBlank()||cpf.getText().isBlank()){JOptionPane.showMessageDialog(this,"Nome e CPF são obrigatórios.");return;}try{new ClienteDAO().inserir(new Cliente(nome.getText(),cpf.getText(),tel.getText(),email.getText()));nome.setText("");cpf.setText("");tel.setText("");email.setText("");refresh();JOptionPane.showMessageDialog(this,"Cliente salvo no MySQL.");}catch(SQLException e){err(e);}}
 void err(Exception e){JOptionPane.showMessageDialog(this,e.getMessage(),"Erro de banco",JOptionPane.ERROR_MESSAGE);}
}