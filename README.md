# APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

Desarrolle una aplicación Web segura con los siguientes requerimientos:

1. Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
2. Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
3. Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.

**** 

## :newspaper: Diseño 

Aplicación Web segura

## :mag_right: Arquitectura 

![image](https://user-images.githubusercontent.com/63822072/227381284-64f1072c-58c0-4b2c-95fd-0c5909840a46.png)

****

## :bulb: Construcción 

### CREACIÓN DE SERVIDORES

![image](https://user-images.githubusercontent.com/63822072/227381368-0778a22c-bd92-4cf9-8b83-c2829171704a.png)

### CONFIGURACIÓN DE SERVIDORES  

Cada servidor tiene un end-point para conectarse localmente con el mismo y otro end-point para conectarse al otro servidor.

#### Servidor1

![image](https://user-images.githubusercontent.com/63822072/227381650-54bd7d48-56f3-4935-aa12-4daa082ec0e8.png)

#### Servidor2

![image](https://user-images.githubusercontent.com/63822072/227381671-ef22bde0-a04a-445d-ad80-4e1b143f1df3.png)

### CLASE URLReader

Ambos servidores se conectan a la clase URLReader, la cual se encarga de validar los certificados validos que aceptará el servidor

![image](https://user-images.githubusercontent.com/63822072/227381760-f373046c-0a7c-4883-983f-03c37debc23d.png)

### CREACIÓN DE CERTIFICADOS 

1. Se creo una carpeta llamada certificates en la raiz del proyecto
2. Se creo dos carpetas para cada maquina
3. Se genero un certificado digital con el siguiente comando

    ```
    keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
    ```
   Se debe de llenar con la siguiente informacion( de manera local)
   ```
   localhost-> aqui debe ir el nombre del servidor o el DNS de AWS
   eci
   eci
   Bogota
   Bogota D.C.
   CO
   yes
   ```

![image](https://user-images.githubusercontent.com/63822072/227382278-7506f22c-6212-48f8-8e4f-9ebef5344859.png)

![image](https://user-images.githubusercontent.com/63822072/227382330-612a5a29-6637-4971-92a4-832ba060c965.png)

#### Exportando certificado a un archivo 

![image](https://user-images.githubusercontent.com/63822072/227382666-5f45bf31-c8e3-4e33-988d-1a8c326ea7b3.png)

#### Importando el certificado a un TrusStore

![image](https://user-images.githubusercontent.com/63822072/227382473-d671cd6d-2662-4f6e-b234-5a4090909993.png)

![image](https://user-images.githubusercontent.com/63822072/227382541-aebdb69c-01e8-4f70-9af8-2a05b72f8894.png)

### CREACIÓN DE INSTANCIAS

![image](https://user-images.githubusercontent.com/63822072/227382855-10178fab-504d-424a-9a22-531c11b135a1.png)

**En cada una de las instancias se coloca el target y se instala java.** y luego se corre para probar las maquinas  

### Pruebas

#### MAQUINA 1

![image](https://user-images.githubusercontent.com/63822072/227383106-ca35d08b-393d-4b70-8fb7-a1cd26444868.png)

![image](https://user-images.githubusercontent.com/63822072/227383572-ec63b8ff-63d3-4e11-9de7-aac4c6ed73b5.png)

A maquina 2

![image](https://user-images.githubusercontent.com/63822072/227383623-d121a853-1676-494d-960b-7bf1f386890e.png)



#### MAQUINA 2

![image](https://user-images.githubusercontent.com/63822072/227383159-d1e5cfa4-2ca7-41f2-ad16-ca932c81913c.png)

![image](https://user-images.githubusercontent.com/63822072/227383258-3dda5054-0cda-4fa0-8834-f77258122c26.png)

A maquina 1

![image](https://user-images.githubusercontent.com/63822072/227383309-8321563e-0dbc-4308-83a9-10a2ec2cbcec.png)


****
### :chart_with_downwards_trend: Prerrequisitos

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)

****

### :bulb: Construido con

* [Maven](https://maven.apache.org/) - Dependency Management
* [AWS](https://aws.amazon.com/) - Instancia EC2

## :mag_right: Versionamiento

Para definir el versionamiento se pudo obserar los tags del repositorio, y el versionaiento es 1.0 

## :woman: Actores

* **Carol Tatiana Cely Rodriguez** 
