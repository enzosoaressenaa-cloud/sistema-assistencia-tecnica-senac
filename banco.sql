CREATE DATABASE IF NOT EXISTS assistencia_tecnica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE assistencia_tecnica;
DROP TABLE IF EXISTS ordem_servico;
DROP TABLE IF EXISTS equipamento;
DROP TABLE IF EXISTS tecnico;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario(id INT AUTO_INCREMENT PRIMARY KEY,nome VARCHAR(100) NOT NULL,login VARCHAR(50) UNIQUE NOT NULL,senha VARCHAR(255) NOT NULL,perfil VARCHAR(30) NOT NULL);
CREATE TABLE cliente(id INT AUTO_INCREMENT PRIMARY KEY,nome VARCHAR(100) NOT NULL,cpf VARCHAR(14) UNIQUE NOT NULL,telefone VARCHAR(20),email VARCHAR(100));
CREATE TABLE tecnico(id INT AUTO_INCREMENT PRIMARY KEY,nome VARCHAR(100) NOT NULL,especialidade VARCHAR(80) NOT NULL,telefone VARCHAR(20));
CREATE TABLE equipamento(id INT AUTO_INCREMENT PRIMARY KEY,tipo VARCHAR(50) NOT NULL,marca VARCHAR(50) NOT NULL,modelo VARCHAR(80) NOT NULL,numero_serie VARCHAR(80) UNIQUE NOT NULL,cliente_id INT NOT NULL,FOREIGN KEY(cliente_id) REFERENCES cliente(id));
CREATE TABLE ordem_servico(id INT AUTO_INCREMENT PRIMARY KEY,data_abertura DATE NOT NULL,descricao_defeito VARCHAR(500) NOT NULL,status VARCHAR(30) NOT NULL,valor DECIMAL(10,2) DEFAULT 0,cliente_id INT NOT NULL,equipamento_id INT NOT NULL,tecnico_id INT NOT NULL,FOREIGN KEY(cliente_id) REFERENCES cliente(id),FOREIGN KEY(equipamento_id) REFERENCES equipamento(id),FOREIGN KEY(tecnico_id) REFERENCES tecnico(id));

INSERT INTO usuario(nome,login,senha,perfil) VALUES('Administrador','admin','1234','ADMIN');
INSERT INTO cliente(nome,cpf,telefone,email) VALUES('João da Silva','123.456.789-00','(13) 99999-1111','joao@email.com'),('Maria Santos','987.654.321-00','(13) 98888-2222','maria@email.com');
INSERT INTO tecnico(nome,especialidade,telefone) VALUES('Carlos Oliveira','Informática','(13) 98888-2222'),('Ana Souza','Eletrônica','(13) 97777-3333');
INSERT INTO equipamento(tipo,marca,modelo,numero_serie,cliente_id) VALUES('Notebook','Dell','Inspiron 15','SN-DL-2026-001',1),('Notebook','HP','14','SN-HP-2026-002',2);
INSERT INTO ordem_servico(data_abertura,descricao_defeito,status,valor,cliente_id,equipamento_id,tecnico_id) VALUES
(CURDATE(),'Notebook não liga e apresenta falha no carregamento.','ABERTA',350,1,1,1),
(DATE_SUB(CURDATE(),INTERVAL 1 DAY),'Troca de teclado.','EM ANDAMENTO',220,2,2,2);
