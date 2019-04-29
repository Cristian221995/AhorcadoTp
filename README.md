THREADS:

-Diferencia entre RUNNABLE y THREAD:

 Un Thread se encarga de crear un proceso en segundo plano. La 
 cantidad posible de Threads queda a cargo del usuario. 
 El problema principal que encontramos con un Thread es que no 
 podemos modificar datos en el hilo principal de la aplicación.
 Runnable Runnable es una interfaz que es necesaria para instanciar 
 un Thread (Hilo), El Thread ya tiene la capacidad de generar un
 hilo pero si deseamos que una clase sea ejecutada en un Thread 
 debemos implementar esta interface.
 
-Ciclo de vida de un THREAD: 

 1- Nuevo Thread, el thread es creado pero no inicializado, es decir,
 todavia no se ejecuto el metodo start().
 2- Thread ejecutandose, el thread se ejecuta luego del llamado
 al metodo start().
 3- Thread bloqueado, El thread podría estar ejecutándose, pero hay 
 alguna actividad interna suya que lo impide. Si un thread está en 
 este estado, no se le asigna tiempo de CPU.
 4- Thread muerto, la forma habitual de que un thread muera es 
 finalizando el método run(). También puede llamarse al método 
 stop() de la clase Thread.
 
-Metodos de un THREAD:

 -Start: comienza la ejecucion del thread.
 -Sleep: Pone el hilo en pausa el tiempo en milisegundos que le 
 pasemos por parametro.
 -Yield: Pausa el hilo en ejecución para permitir la ejecución de 
 otros.
 -Join: Este metodo asegura que otro thread no se ejecute hasta que
 el que llamo a este metodo finalice.