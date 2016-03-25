desc contatos;

use fj21;

create table CONTATOS (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	endereco VARCHAR(255),
	dataNascimento DATE,
	primary key (id)
);

-- drop TABLE CONTATOS;

select * from CONTATOS;

select * from CONTATOS order by id desc;

-- delete from contatos where id in (34, 35);

