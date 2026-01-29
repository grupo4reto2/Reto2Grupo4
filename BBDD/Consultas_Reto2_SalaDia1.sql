use reto2_g4_true;
SELECT SA.NomSala, S.CodigoSesion, SA.IdSala, S.FecHoraIni, S.IDsesion, S.IDPelicula, P.NomPelicula
FROM Sesion S left join Sala SA on S.IDSala = SA.IDSala
left join Pelicula P on S.IDPelicula = P.IDPelicula
where SA.IDSala = '1' and FecHoraIni between '2026-01-15 10:00:00' and '2026-01-16 00:00:00';



SELECT SA.NomSala, S.CodigoSesion, SA.IdSala, S.FecHoraIni, S.IDsesion, S.IDPelicula, P.NomPelicula
FROM Sesion S left join Sala SA on S.IDSala = SA.IDSala
left join Pelicula P on S.IDPelicula = P.IDPelicula
where SA.IDSala = '2' and FecHoraIni between '2026-01-15 10:00:00' and '2026-01-16 00:00:00';



SELECT SA.NomSala, S.CodigoSesion, SA.IdSala, S.FecHoraIni, S.IDsesion, S.IDPelicula, P.NomPelicula
FROM Sesion S left join Sala SA on S.IDSala = SA.IDSala
left join Pelicula P on S.IDPelicula = P.IDPelicula
where SA.IDSala = '3' and FecHoraIni between '2026-01-15 10:00:00' and '2026-01-16 00:00:00';



SELECT SA.NomSala, S.CodigoSesion, SA.IdSala, S.FecHoraIni, S.IDsesion, S.IDPelicula, P.NomPelicula
FROM Sesion S left join Sala SA on S.IDSala = SA.IDSala
left join Pelicula P on S.IDPelicula = P.IDPelicula
where SA.IDSala = '4' and FecHoraIni between '2026-01-15 10:00:00' and '2026-01-16 00:00:00';




SELECT SA.NomSala, S.CodigoSesion, SA.IdSala, S.FecHoraIni, S.IDsesion, S.IDPelicula, P.NomPelicula
FROM Sesion S left join Sala SA on S.IDSala = SA.IDSala
left join Pelicula P on S.IDPelicula = P.IDPelicula
where SA.IDSala = '5' and FecHoraIni between '2026-01-15 10:00:00' and '2026-01-16 00:00:00';


Select P.NomPelicula, P.IDPelicula, SA.NomSala, SA.IDSala, S.IDSesion, S.FecHoraIni
From Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula 
left join Sala SA on S.IDSala = SA.IDSala
where FecHoraIni = '2026-01-15 10:00:00'
limit 4;



select P.IDPelicula, P.NomPelicula, S.FecHoraIni, S.IDSesion, SA.NomSala, S.Precio
From Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula
join Sala SA on SA.IDSala = S.IDSala;

SELECT DISTINCT DATE(S.FecHoraIni) AS Fecha, P.NomPelicula
FROM Sesion S join Pelicula P on S.IDPelicula = P.IDPelicula
where P.IDPelicula ='1'
ORDER BY Fecha;


Select S.FecHoraIni, SA.NomSala, S.Precio
from Sesion S join Sala SA on S.IDSala = SA.IDSala
join Pelicula P on P.IDPelicula = S.IDPelicula
where P.IDPelicula = '1' and S.FecHoraIni >= '2026-01-15 00:00:00'
and S.FecHoraIni <= '2026-01-16 00:00:00';


select P.NomPelicula, S.FecHoraIni, round(E.cantidad) as NumEspectadores
from Entrada E join sesion S on E.IDSesion = S.IDSesion
join Pelicula P on S.IDPelicula = P.IDPelicula
where E.IDEntrada = ?;

