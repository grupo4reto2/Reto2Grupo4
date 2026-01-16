


select P.IDPelicula, P.NomPelicula, sum(E.NumPers * S.Precio) as Recaudacion
from Pelicula P join Sesion S on P.IDPelicula = S.IDPelicula
join Entrada E on s.IDSesion = E.IDSesion and S.FecHoraIni = E.FecHoraIni
group by P.IDPelicula, P.NomPelicula
having sum(E.NumPers * S.Precio) > 1000;