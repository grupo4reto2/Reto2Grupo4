
USE`reto2_g4_true`;

/* Dinero recaudado por cada película con recaudación superior a una cifra
dada.*/

SELECT p.IDPelicula,p.NomPelicula, SUM(e.NumPers * s.Precio) AS Recaudacion
FROM pelicula p JOIN sesion s ON p.IDPelicula = s.IDPelicula
JOIN entrada e ON s.IDSesion = e.IDSesion AND s.FecHoraIni = e.FecHoraIni
GROUP BY p.IDPelicula, p.NomPelicula
having Recaudacion > 500;

/*Duración media de las películas por género.*/

select G.NomGenero, avg(P.Duracion) as DuracionMedia
from Genero G join Pelicula P on G.IDGenero = P.IDGenero
group by G.NomGenero;

/*número de sesiones ofrecidas por película filtradas por genero o por precio*/

select P.IDPelicula, P.NomPelicula, avg(S.IDPelicula) as numSesiones
from Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula
join Genero G on P.IDGenero = G.IDGenero
Where G.IDGenero = '2'
or S.Precio >= 9.5
group by P.IDPelicula, P.NomPelicula;


/*Precio medio de las películas por género.*/ 

select G.NomGenero, avg(S.Precio) as PrecioMedio
from Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula
join Genero G on P.IDGenero = G.IDGenero
group by G.NomGenero;

/*Datos de las películas con mayor recaudación.*/ 

select  P.IDPelicula, P.NomPelicula, P.Duracion, P.IDGenero, SUM(e.NumPers * s.Precio) AS Recaudacion
FROM pelicula p JOIN sesion s ON p.IDPelicula = s.IDPelicula
JOIN entrada e ON s.IDSesion = e.IDSesion AND s.FecHoraIni = e.FecHoraIni
group by P.IDPelicula, P.NomPelicula
order by Recaudacion desc
Limit 5;

/*Datos de los clientes a los que se les ha aplicado mayores descuentos en sus
compras.*/ 

select C.DNICliente, C.Nombre,C.Apellido, C.Correo, max(CO.descuento) as descuento_maximo
from Compra CO join Cliente C on CO.DNICliente = C.DNICliente
group by C.DNICliente, C.Nombre, C.Apellido
order by descuento_maximo desc
Limit 5;

/*Datos de los clientes que han adquirido mayor número de entradas.*/ 

SELECT C.DNICliente, C.Nombre, C.Apellido, C.Correo, COUNT(E.IDEntrada) AS TotalEntradas
FROM Cliente C JOIN Compra CO ON C.DNICliente = CO.DNICliente
JOIN Entrada E ON CO.IDCompra = E.IDCompra
GROUP BY C.DNICliente, C.Nombre, C.Apellido, C.Correo
ORDER BY TotalEntradas DESC
LIMIT 1;

/*Datos de los clientes que han gastado más dinero.*/

SELECT C.DNICliente, C.Nombre, C.Apellido, max(CO.Importe) DineroGastado
FROM Cliente C JOIN Compra CO ON C.DNICliente = CO.DNICliente
GROUP BY C.DNICliente, C.Nombre, C.Apellido, C.Correo
ORDER BY DineroGastado DESC
Limit 1;

/*Datos de las películas con un número de espectadores inferior a una cantidad
dada.*/

select P.IDPelicula, P.NomPelicula, P.Duracion, P.IDGenero, sum(E.NumPers) as TotalEspectadores
from Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula
join Entrada E on S.IDSesion = E.IDSesion AND S.FecHoraIni = E.FecHoraIni
group by P.IDPelicula, P.NomPelicula, P.Duracion, P.IDGenero
having TotalEspectadores < 1000;

/*Datos de los clientes que aún no han comprado ninguna entrada.*/

SELECT c.DNICliente, c.Nombre, c.Apellido, c.Correo
FROM cliente c
LEFT JOIN compra co ON c.DNICliente = co.DNICliente
LEFT JOIN entrada e ON co.IDCompra = e.IDCompra
GROUP BY c.DNICliente, c.Nombre, c.Apellido
HAVING COUNT(e.IDEntrada) = 0;