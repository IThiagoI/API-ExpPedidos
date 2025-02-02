create table usuario(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    senha varchar(100) not null,
    nivel_acesso ENUM('ADM','USUARIO'),

    primary key(id)

);