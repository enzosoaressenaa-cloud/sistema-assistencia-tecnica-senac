package br.senac.assistenciatecnica;
import javax.swing.*;import javax.swing.table.*;import java.awt.*;import java.sql.*;import java.util.*;
public class OrdensPanel extends JPanel{
 DefaultTableModel m;JTable t;java.util.List<OrdemServico> dados=new ArrayList<>();
 public OrdensPanel(){setLayout(new BorderLayout(10,10));setBorder(BorderFactory.createEmptyBorder(20,20,20,20));JLabel h=new JLabel("Ordens de Serviço");h.setFont(new Font("SansSerif",1,26));add(h,BorderLayout.NORTH);m=new DefaultTableModel(new Object[]{"OS","Cliente","Equipamento","Técnico","Status","Valor"},0);t=new JTable(m);refresh();add(new JScrollPane(t),BorderLayout.CENTER);JButton b=new JButton("Alterar status");b.addActionListener(e->status());add(b,BorderLayout.SOUTH);}
 void refresh(){m.setRowCount(0);try{dados=new OrdemServicoDAO().listar();for(OrdemServico o:dados)m.addRow(new Object[]{o.getId(),o.getClienteNome(),o.getEquipamentoNome(),o.getTecnicoNome(),o.getStatus(),String.format("R$ %.2f",o.getValor())});}catch(SQLException e){err(e);}}
 void status(){int r=t.getSelectedRow();if(r<0){JOptionPane.showMessageDialog(this,"Selecione uma OS.");return;}String[] s={"ABERTA","EM ANDAMENTO","AGUARDANDO PECA","CONCLUIDA","CANCELADA"};String v=(String)JOptionPane.showInputDialog(this,"Novo status","Atualização",1,null,s,s[0]);if(v!=null)try{new OrdemServicoDAO().atualizarStatus(dados.get(r).getId(),v);refresh();}catch(SQLException e){err(e);}}
 void err(Exception e){JOptionPane.showMessageDialog(this,e.getMessage(),"Erro de banco",0);}
}