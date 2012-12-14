create table programa
(
id SERIAL PRIMARY KEY,
nome varchar(50),
genero varchar(20),
horarioInicio varchar(20),
horarioFim varchar(20));


-- inserts


insert into programa(nome,genero,horarioInicio,horarioFim)
values ('Domingão do Faustão','auditório','15:00','19:00'),
       ('Fantástico','reportagem','21:00','23:00'),
       ('Tele-Domingo','reportagem','24:00','1:00'),
       ('Corujão','filme','1:00','4:00');


select *from programa;
