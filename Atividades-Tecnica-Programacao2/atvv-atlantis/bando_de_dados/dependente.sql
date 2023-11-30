create database if not exists `atlantis`
use `atlantis`;

-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
-- Host: localhost    Database: atlantis

create table dependente
(dep_id int primary key,
dep_nome varchar(100),
key `fk_cli_id` (`cli_id`),
constraint `fk_cli_id` foreign key (`cli_id`) references `cliente`(`cli_id`),
key `fk_tit_id` (`tit_id`),
constraint `fk_tit_id` foreign key (`tit_id`) references `titular`(`tit_id`));