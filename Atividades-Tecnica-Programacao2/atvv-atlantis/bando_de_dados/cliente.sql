create database if not exists `atlantis`
use `atlantis`;

-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
-- Host: localhost    Database: atlantis

create table clientes
(cli_id int primary key,
cli_nome varchar(100),
cli_nome_social varchar(100),
cli_endereco varchar(30),
cli_data_nascimento date,
cli_data_cadastro date,
cli_telefone int(11));