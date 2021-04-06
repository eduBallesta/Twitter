# Twitter
Pequeño proyecto con Stream de Twitter y algunos microservicios

Proyecto de consuminición de publicaciones Twitter usando las librerías ofrecidas por org.twitter4j

	El proyecto consta de dos partes diferenciadas:

	Por una parte, una conexión en Streaming que, aplicados unos filtros prestablecidos con el prefijo default en el fichero application.properties,
	obtiene diferentes twitts publicados en tiempo real y lo persiste en una base en memoria del tipo h2.
	
	Para que el proyecto funcione, el usuario se debe registrar como developer en https://developer.twitter.com/en
	y generar las credenciales desde su cuenta. Dichas credenciales deben de ser copiadas correctamente en el fichero twitter4j.properties
	
	
		debug=true
		oauth.consumerKey=XXXXXXXXXXXXXXXXXXXXXXXX
		oauth.consumerSecret=XXXXXXXXXXXXXXXXXXXXXXXX
		oauth.accessToken=XXXXXXXXXXXXXXXXXXXXXXXX
		oauth.accessTokenSecret=XXXXXXXXXXXXXXXXXXXXXXXX
	
	Por otra parte, existen diferentes endPoints sobre Api Rest que se encargan de:
	
		Consultar los tweets que hay en la bbdd de memoria.
		Establecer tweets como validados.
		Consultar los tweets que están validados.
		Devolver los N hashtags más usados.
	
	Las entidades utilizadas para persistencia son:

		- tweet: Tweets que se almacen en bbdd después de ser filtrados. 
		- hashtags: entidad con todos los hashtags
		- TweetHashTag: lista de hagtags relacionados con un twitt
		- user_tweet: información del usuario
	
	
	La información almacenada de un tweet en el proyecto es parcial. Aquí tiene un ejemplo de un registro de tipo JSON de un tweet. 
	
		{
		"id": "1379344816757223425",
		"user": {
		  "id": 21,
		  "name": "DADDY MOU ®",
		  "email": "",
		  "location": "",
		  "followersCount": 7369,
		  "status": null,
		  "friendsCount": 3400,
		  "createdAt": "2010-04-03T12:07:59.000+0000",
		  "favouritesCount": 47343
		},
		"text": "Ahora la Sputnik. Esto se parece al Rastro. A ver quien me la pinta más barata, bonita y buena",
		"isValidated": false,
		"hashTags": []
	  },
	
	
	NOTA: El campo text, ha tenido que ser establecido como @LOB para que guarde caracteres extraños y emoticonos
	
	
	Dichos endPoints se pueden probar mediante Swagger, puesto que YA está configurado en el proyecto.
	Para poder acceder a ellos introduzca la siguiente url en su navegador
	
		http://localhost:8085/mytwitter/swagger-ui.html#/
	
	 El puerto configurado en el application.properties es 8085, si varía la propiedad deberá tenerlo en cuenta.
	 
		server.port=8085
	
	
	Por último, el proyecto contiene una serie de Pruebas Unitarias con JUnits y Jupiter.
	
	Las clases a las que se le han realizado las pruebas unitarias son las clases 

		- Service
		- Repository
		- Controller
		
	Para las pruebas del repository, se cuenta con un fichero sql en el directorio resources, que carga algunos datos 
	en las tablas memoria al realizar la ejecución.
