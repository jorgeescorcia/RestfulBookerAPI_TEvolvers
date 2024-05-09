#language: es

Característica: Consume PUT de la APi de reservas
  Yo como Jorge Escorcia
  Quiero realizar el consumo a un servicio api rest de tipo PUT
  para comprobar la funcionalidad y validar si actualiza los datos

  Antecedentes:
    Dado "Andres" obtiene la baseurl de la api

  @Successful
  Escenario: Actualiza(put) los datos que arroje el consumo de la api
    Cuando configura la peticion a obtener
    Entonces valida que los datos consultados fueron actualizados