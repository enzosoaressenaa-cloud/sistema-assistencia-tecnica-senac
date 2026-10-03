package br.senac.assistenciatecnica;
public class Tecnico {
 private int id; private String nome,especialidade,telefone;
 public Tecnico(int id,String nome,String especialidade,String telefone){this.id=id;this.nome=nome;this.especialidade=especialidade;this.telefone=telefone;}
 public int getId(){return id;} public String getNome(){return nome;} public String getEspecialidade(){return especialidade;} public String getTelefone(){return telefone;}
 public String toString(){return nome;}
}