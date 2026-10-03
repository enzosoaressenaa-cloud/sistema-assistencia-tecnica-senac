package br.senac.assistenciatecnica;
import java.time.LocalDate;
public class OrdemServico {
 private int id; private LocalDate data; private String defeito,status; private double valor; private int clienteId,equipamentoId,tecnicoId; private String clienteNome,equipamentoNome,tecnicoNome;
 public OrdemServico(int id,LocalDate data,String defeito,String status,double valor,int clienteId,int equipamentoId,int tecnicoId,String clienteNome,String equipamentoNome,String tecnicoNome){this.id=id;this.data=data;this.defeito=defeito;this.status=status;this.valor=valor;this.clienteId=clienteId;this.equipamentoId=equipamentoId;this.tecnicoId=tecnicoId;this.clienteNome=clienteNome;this.equipamentoNome=equipamentoNome;this.tecnicoNome=tecnicoNome;}
 public int getId(){return id;} public LocalDate getData(){return data;} public String getDefeito(){return defeito;} public String getStatus(){return status;} public double getValor(){return valor;} public int getClienteId(){return clienteId;} public int getEquipamentoId(){return equipamentoId;} public int getTecnicoId(){return tecnicoId;} public String getClienteNome(){return clienteNome;} public String getEquipamentoNome(){return equipamentoNome;} public String getTecnicoNome(){return tecnicoNome;}
 public void setStatus(String s){status=s;}
}