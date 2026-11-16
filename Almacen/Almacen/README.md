# Almacen

Aplicacion de consola en Java para manejar el stock de un almacen (registrar, vender, ver inventario y stock critico).

Para ejecutar el programa se corre la clase `Main`.

Las pruebas estan en `src/InventarioTest.java`, usan JUnit (el jar esta en `lib/`). Se pueden correr desde VS Code en la pestaña Testing, o por consola:

```
javac -d bin -cp lib/junit-platform-console-standalone-6.1.3.jar src/*.java
java -jar lib/junit-platform-console-standalone-6.1.3.jar execute --class-path bin --scan-class-path
```
