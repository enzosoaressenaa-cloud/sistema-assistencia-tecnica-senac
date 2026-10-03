package br.senac.assistenciatecnica;
import javax.swing.*;import java.awt.*;
public class MainFrame extends JFrame{
 JPanel content; JLabel status;
 public MainFrame(String user){setTitle("Assistência Técnica - Gestão");setSize(1180,720);setLocationRelativeTo(null);setDefaultCloseOperation(EXIT_ON_CLOSE);
 JPanel root=new JPanel(new BorderLayout());JPanel top=new JPanel(new BorderLayout());top.setBackground(new Color(23,50,77));top.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));JLabel t=new JLabel("Assistência Técnica");t.setForeground(Color.WHITE);t.setFont(new Font("SansSerif",1,22));top.add(t,BorderLayout.WEST);JLabel u=new JLabel("Usuário: "+user);u.setForeground(Color.WHITE);top.add(u,BorderLayout.EAST);root.add(top,BorderLayout.NORTH);
 JPanel menu=new JPanel();menu.setLayout(new BoxLayout(menu,BoxLayout.Y_AXIS));menu.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));String[] ns={"Dashboard","Clientes","Equipamentos","Ordens de Serviço"};for(String n:ns){JButton b=new JButton(n);b.setMaximumSize(new Dimension(200,42));b.setAlignmentX(LEFT_ALIGNMENT);b.addActionListener(e->go(n));menu.add(b);menu.add(Box.createVerticalStrut(8));}root.add(menu,BorderLayout.WEST);
 content=new JPanel(new BorderLayout());root.add(content,BorderLayout.CENTER);status=new JLabel(" Pronto");root.add(status,BorderLayout.SOUTH);add(root);go("Dashboard");}
 void go(String n){status.setText(" "+n);content.removeAll();JPanel p;switch(n){case"Clientes":p=new ClientesPanel();break;case"Equipamentos":p=new EquipamentosPanel();break;case"Ordens de Serviço":p=new OrdensPanel();break;default:p=new DashboardPanel();}content.add(p);content.revalidate();content.repaint();}
}