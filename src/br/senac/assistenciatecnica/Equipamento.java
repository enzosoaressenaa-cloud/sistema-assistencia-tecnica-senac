package br.senac.assistenciatecnica;
public class Equipamento {
 private int id; private String tipo,marca,modelo,numeroSerie; private int clienteId; private String clienteNome;
 public Equipamento(int id,String tipo,String marca,String modelo,String numeroSerie,int clienteId,String clienteNome){this.id=id;this.tipo=tipo;this.marca=marca;this.modelo=modelo;this.numeroSerie=numeroSerie;this.clienteId=clienteId;this.clienteNome=clienteNome;}
 public int getId(){return id;} public String getTipo(){return tipo;} public String getMarca(){return marca;} public String getModelo(){return modelo;} public String getNumeroSerie(){return numeroSerie;} public int getClienteId(){return clienteId;} public String getClienteNome(){return clienteNome;}
 public String toString(){return marca+" "+modelo+" - "+numeroSerie;}
}