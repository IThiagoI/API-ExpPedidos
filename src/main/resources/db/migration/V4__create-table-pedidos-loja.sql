create table pedido_loja(

    id bigint not null auto_increment,
    data datetime not null,
    id_loja bigint not null,
    id_usuario bigint not null,

    primary key(id),
    constraint fk_pedido_loja_id_loja foreign key(id_loja) references loja(id),
    constraint fk_pedido_loja_id_usuario foreign key(id_usuario) references usuario(id)

);