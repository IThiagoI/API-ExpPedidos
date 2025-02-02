create table pedido(

    id bigint not null auto_increment,
    id_pedido_loja bigint not null,
    id_produto bigint not null,
    quantidade bigint not null,

    primary key(id),
    constraint fk_pedido_id_pedido_loja foreign key(id_pedido_loja) references pedido_loja(id),
    constraint fk_pedido_id_produto foreign key(id_produto) references produto(id)

);