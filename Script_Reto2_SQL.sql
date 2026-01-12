use reto2_g4;

create table Sala(
IDSala int unsigned primary key,
NomSala char (30) not null
);
alter table Sala
add Aforo int unsigned not null default 200;

alter table Sala 
modify IDSala varchar (3) primary key; 

create table Sesion(
IDSesion int unsigned primary key,
FecHoraIni timestamp not null,
FecHoraFin timestamp not null,
Precio double unsigned not null,
IDSala int unsigned not null,
Constraint FK_Sesion_Sala Foreign key (IDSala) references Sala(IDSala) on update cascade
);

alter table Sesion
modify FecHoraIni timestamp not null,
modify FecHoraFin timestamp null;

alter table Sesion 
modify IDSala varchar (3) not null; 

create table Pelicula(
IDPelicula int unsigned primary key,
Duracion time not null,
IDSesion int unsigned not null,
constraint FK_Pelicula_Sesion foreign key (IDSesion) references sesion (IDSesion) on update  cascade
);

alter table Pelicula
modify Duracion int unsigned not null;

create table Genero(
IDGenero int unsigned primary key,
NomGenero char(20) not null,
IDPelicula int unsigned not null,
constraint FK_Genero_Pelicula foreign key (IDPelicula) references pelicula (IDPelicula) on update cascade
);

create table Entrada (
IDEntrada int unsigned primary key,
NumPers int unsigned not null,
IDSesion int unsigned not null,
IDCompra int unsigned not null,
constraint fk_Entrada_Sesion foreign key (IDSesion) references Sesion(IDSesion) on update cascade,
constraint fk_Entrada_Compra foreign key (IDCompra) references Compra(IDCompra) on update cascade
);


create table Compra (
IDCompra int unsigned primary key,
Fecha date not null,
DNICliente varchar (9) not null,
constraint fk_Compra_Cliente foreign key (DNICliente) references cliente (DNICliente) on update cascade
);

alter table Compra
modify Fecha timestamp not null,
drop Hora;

alter table Compra
add descuento double not null;

alter table Compra
add constraint chk_Canal check (canal In (0,1)); 

create table Cliente (
DNICliente varchar (9) primary key,
Nombre char (30) not null,
Apellido char (30) not null,
Correo char (30) not null
);

alter table Cliente
add Contraseña varchar(20)  not null;



