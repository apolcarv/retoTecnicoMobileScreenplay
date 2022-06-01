# retoTecnicoChoucair
-> Se realiza automatizacion MOBILE para una apk de pruebas de amazonshopping.apk en sistema android
 -> Se Utilizan las herramientas appium version 1.20.2, para la toma de localizadores y conexion al servidor por defecto y gratuito que apunta ak la maquina local https//localhost:0.0.0.0
 -> Se utiliza android studio version 2021.2 recordar que aqui es donde creamos un telefono virtual, ya que la herramienta nos permite interactuar con la granja de telefonos y versiones que tienen(Deben apoyarse viendo videos de como se crea un celular virtual)
 IMPORTANTE: El robot se entiende con estas dos herramientas siempre y cuando incluyan la variable del sistema ANDROID_HOME
 Ejemplo:
 ANDROID_HOME="/Users/<user>/Library/Android/sdk/"
 ANDROID_TOOLS="/Users/<user>/Library/Android/sdk/tools"
 ANDROID_PLATFORM_TOOLS="/Users/<user>/Library/Android/sdk/platform-tools"
PATH=$PATH:$ANDROID_HOME:$ANDROID_TOOLS:$ANDROID_PLATFORM_TOOLS

es de aclarar que este dato appium.deviceName  = emulator-5554 --> el valor despues del igual solo saldra siempre y cuando configures bien las variables de entorno y abras las herramientas de android estudio , este dato es super importante ya que lo necesitaras en la configuracion seteando las capabilities del celular a emular 


Es importante configurarlas ya que sin esto, no se podra emular dentro del dispositivo que se crea dentro de la aplicacion android studios y el appium no podria iniciar el servidor al setear las capabilities Mobile con EXITO



 -> Se utilizan patron de diseño screenplay, serenity BDD, gherkin [ES], cucumber, se utilizan algunas dependencias extras como faker y las de APPIUM solo la version 6.1.0 es la mas estable. 
  ** Importante: La automaticion trata de realizar un compra de un producto la cual este solicita llenar un formulario. 
  ** RETO: manejar localizadores de tipo List aplicando un poco de POM, POO, se crean metodos especiales para trabajar con estos localizadores transformando nuestro codigo, haciendo que este sea mas robusto, y mantenible.
  ** NOTA: El proyecto no tiene ningun bug o code smell mayor, ya que se realiza analicis de codigo estatico con la herramienta SonarLint