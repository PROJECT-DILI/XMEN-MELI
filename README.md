# XMEN-MELI
Repositorio "Descubriemiento de ADN Mutante para los XMEN". Código BacKend para prueba de Mercado
Libre.

El proyecto se encuentra alojado en la sigueinte ruta: 
(http://test-1342397840.us-east-1.elb.amazonaws.com:3049/swagger-ui.htm)

##Instalación local

Descargar e instalar:
*Java Jdk 11
*Maven
*Intellij IDEA
*Doker

##Ejecución local
*Desde la raía del proyecto ejecutar `maven clean` y `mvn package`.
*Desde la ruta src/presentation/ApiApplication.java click derecho y ejecutar.
*El proyecto se ejecuta en el puerto 8080 en el swagger inmerso. (http://localhost:8080/swagger-ui.htm)

##Ejecución CLOUD
*Se preparó una infraestructura de prueba en la nube de AWS, solo basta con ejecutar el pipeline
del proyecto quién se encargará de realizar una instalación limpia.