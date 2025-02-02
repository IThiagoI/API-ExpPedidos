alter table pedido_loja add constraint fk_pedido_loja_id_loja_destino foreign key(id_loja_destino) references loja(id);

