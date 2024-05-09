#language: es

Característica: Consume POST de la APi de reservas
  Yo como Jorge Escorcia
  Quiero realizar el consumo a un servicio api rest de tipo POST
  para comprobar la funcionalidad y validar si envia lo datos

  Antecedentes:
    Dado "Jorge" obtiene la baseurl de la api

  @Successful
  Escenario: Enviar(post) los datos que arroje el consumo de la api
    Cuando configura la solicitud a consumir
    Entonces valida los datos consultados