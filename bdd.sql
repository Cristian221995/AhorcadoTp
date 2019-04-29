create database ahorcado;
use ahorcado;

create table palabras(
    id_palabra int auto_increment,
    palabra varchar(100),
    constraint  pk_id_palabra primary key (id_palabra),
    constraint unq_palabra unique (palabra)
);

create table ganadores(
    id_ganador int auto_increment,
    nombre varchar(100),
    fecha date,
    id_palabra int,
    constraint pk_id_ganador primary key (id_ganador),
    constraint fk_id_palabra foreign key (id_palabra) references palabras (id_palabra)
);

INSERT INTO palabras (palabra) values ('maven') , ('programacion') , ('java') , ('laboratorio') , ('computadora') , ('thread') , ('strategy');

