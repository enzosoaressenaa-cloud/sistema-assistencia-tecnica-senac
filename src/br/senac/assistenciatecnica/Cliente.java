package br.senac.assistenciatecnica;
public class Cliente {
 private int id; private String nome,cpf,telefone,email;
 public Cliente(int id,String nome,String cpf,String telefone,String email){this.id=id;this.nome=nome;this.cpf=cpf;this.telefone=telefone;this.email=email;}
 public Cliente(String nome,String cpf,String telefone,String email){this(0,nome,cpf,telefone,email);}
 public int getId(){return id;} public String getNome(){return nome;} public String getCpf(){return cpf;} public String getTelefone(){return telefone;} public String getEmail(){return email;}
 public void setId(int v){id=v;} public void setNome(String v){nome=v;} public void setCpf(String v){cpf=v;} public void setTelefone(String v){telefone=v;} public void setEmail(String v){email=v;}
 public String toString(){return nome;}
}