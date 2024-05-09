#language: es

  Característica: Consume get de la APi de reservas
    Yo como Jorge Escorcia
    Quiero realizar el consumo a un servicio api rest de tipo get
    para comprobar la disponibilidad de reservas y validar la consulta de los datos

    Antecedentes:
      Dado "Jorge" obtiene la baseurl de la api

  @Successful
  Escenario: Obtener(get) los datos que arroje el consumo de la api
    Cuando configura la peticion a consumir
    Entonces valida el estado de la peticion