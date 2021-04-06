CREATE TABLE empresa(
   id bigint(20) not null primary key AUTO_INCREMENT,
 cnpj varchar(255) not null,
 data_criacao datetime not null,
 data_atulizao datetime not null,
 razao_social varchar(255) not null
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;