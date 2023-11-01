create table veiculo(
	placa char(7) primary key not null,
	tipo varchar(10),
	modelo varchar(150) not null,
	cor varchar(20) not null,
	ano char(4) not null,
	nome_dono varchar(150),
	contato_dono varchar(18),
	created_at timestamp not null,
	created_by varchar(150),
	updated_at timestamp not null,
	updated_by varchar(150)
);

create sequence alocacao_seq;
create table alocacao(
	id int primary key not null DEFAULT nextval('alocacao_seq'),
	placa char(7) not null,
	entrada timestamp not null,
	saida timestamp null,
	created_at timestamp not null,
    created_by varchar(150),
    updated_at timestamp,
    updated_by varchar(150)
);
ALTER SEQUENCE alocacao_seq
OWNED BY alocacao.id;

create sequence parquimetro_seq;
create table parquimetro(
	id int primary key not null DEFAULT nextval('parquimetro_seq'),
	vagas int not null,
	preco_inicial decimal (10,2),
	horas_preco_inicial int,
	preco_hora_extra decimal (10,2),
	created_at timestamp,
    created_by varchar(150),
    updated_at timestamp,
    updated_by varchar(150)

);
ALTER SEQUENCE parquimetro_seq
OWNED BY parquimetro.id;

create sequence extrato_alocacao_seq;
create table extrato_alocacao(
	id int primary key not null DEFAULT nextval('extrato_alocacao_seq'),
	alocacao_id int not null,
	placa char(7) not null,
	horas_estadia int not null,
	valor_calculado decimal(10,2) not null,
	created_at timestamp not null,
    created_by varchar(150),
    updated_at timestamp,
    updated_by varchar(150),
    constraint fk_alocacao
            foreign key (alocacao_id)
                references alocacao(id)
);
ALTER SEQUENCE alocacao_seq
OWNED BY alocacao.id;


insert into parquimetro (vagas) values (150);