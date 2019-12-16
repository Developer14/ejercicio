### Registro de Usuarios

El projecto fue construido con Intellij IDEA Community

#### Requisitos para levantar aplicacion
- Java 8
- Gradle 6

#### Pasos para levantar la aplicacion

Clonar el proyecto en directorio local

Abrir consola (de preferencia un emulador de bash como Git Bash o Commander)

Dentro del directorio del proyecto usar los siguientes comandos:

```sh
$ gradle clean bootJar
$ java -jar build/libs/ejercicio-0.0.1-SNAPSHOT.jar
```

#### Endpoints y payloads ejemplo:

Crear Usuario: http://localhost:8080/user (POST)

Payload ejemplo:
```json
{
    "name": "Alan Brito Delgado",
    "email": "alan@gmail.com",
    "password": "Eleven78",
    "phones": [
    	{
    		"number": "95153579",
    		"cityCode": "1",
    		"countryCode": "569"
    	},
    	{
    		"number": "68751621",
    		"cityCode": "1",
    		"countryCode": "569"
    	}
    ]
}
```


Actualizar Usuario: http://localhost:8080/user (PUT)

Payload ejemplo:

```json
{
    "id": 1,
    "name": "Alan Brito Delgado",
    "email": "alan@gmail.com",
    "password": "Bazinga22",
}
```

#### Consola H2 en memoria

- http://localhost:8080/h2-console