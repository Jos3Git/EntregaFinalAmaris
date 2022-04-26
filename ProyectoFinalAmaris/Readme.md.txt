Intrucciones para que el proyecto funcione correctamente

--INFO:
 hexa-layers-demo y greyhawk-...: Dependencias grewhawk.
 ProyectoFinalAmaris: Contiene la funcionalidad del código del ejercicio y la inicialización de los datos de la BBDD en un Bean del configuration.
 ProyectoFinalAmarisSetup: Reglas grewhawk específicas del proyecto. 
 ProjectoFinalAmarisProducer:contiene un producer que genera los mensajes de kafka para su posterior actualización (si procede) en la tabla prices.

--COMPILADO
El proyecto ha sido desarrollado con una serie de dependencias que se engloban dentro del nombre "greyhawk" las cuales hacen que el código tenga que cumplir una serie de reglas (que pueden ser editadas).
Para compilar las dependencias de greyhawk, hay que hacer un maven->clean-install en el orden que especifico a continuación:
1º- hexa-layers-demo
2º- greyhawk-setup
3º- greyhawk-core-setup
4º- greyhawk-core
5º- greyhawk-rest (Hay que ignorar los test)
6º- ProyectoFinalAmarisSetup
7º- ProyectoFinalAmaris
8º- ProjectoFinalAmarisProducer

Si alguno de los pasos de 1º a 5º no compila(clean-install), seguir secuencialmente los pasos hasta el 5º y luego volver a empezar (eso suele solucionar el problema, ya que deberían de estar todas las dependencias en el directorio maven).
Cuando los pasos del 1º al 5º compilen perfectamente proseguir con los siguientes pasos ejecutando clean-install en los proyectos indicados.



--ANTES DE EJECUTAR

 1 MongoDB: Crear la BBDD "proyectoFinalAmaris"
 2 Ejecutar en un terminal \ProyectoFinalAmaris> docker-compose up -d (hay otro docker-compose.yml en el proyecto ProjectoFinalAmarisProducer, pero es el mismo ).
 3 Ejecutar en el directorio donde se tenga el visor de kafka kafdrop el siguiente comando: java --add-opens=java.base/sun.nio.ch=ALL-UNNAMED -jar kafdrop-3.29.0.jar --kafka.brokerConnect=localhost:9092
 3.1 En la url http://localhost:9000/ se ejecutará el kafdrop. 


 
 
--EXTRAS:
 
 1-Adjunto la exportación del postman con las peticiones relacionadas con el proyecto.
 2-Adjunto imágenes con evidencias que el programa.

--NOTA
1 Debido a que el ejercicio solicitaba el reemplazo de la bbdd h2 por mongo, se ha tenido que realizar modificiaciones del código de tal forma que ya no que da casi nada de h2.
2 Debido a que la duda que he posteado en el foro no ha sido resuelta ni por los compañeros ni por nadie de la empresa de formación("No consigo que me funcione los filtros por las fechas en mongoDB con LocalDateTime en el método @Query del mongoRepository ¿Podéis ayudarme?")  he tenido que realizar el filtrado sin fechas y las fechas filtrarlas con lambdas.