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