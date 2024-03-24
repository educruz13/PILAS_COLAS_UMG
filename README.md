# PILAS_COLAS_UMG
Dicho programa contendrá una opción para generar un millón de números aleatorios negativos y positivos (en un rango de -10,000,000 a 10,000,000)
Dichos números deberán ser insertados en una pila y posteriormente extradíos.
Dichos números deberán ser insertados en una cola y posteriormente extradíos.

Indique cuaal de los dos metodos es mas eficiente.

La eficiencia entre usar una pila y una cola para procesar los números, no debería marcar una diferencia significativa en términos de complejidad temporal, ya que ambos enfoques realizan operaciones similares de inserción y eliminación de elementos en el orden en que se recibieron.

Sin embargo, si consideramos la implementación específica en Java, en términos de rendimiento puro, una pila (Stack) puede ser ligeramente más eficiente que una cola (Queue) en este caso. La razón es que la clase Stack en Java está diseñada específicamente para operaciones de pila, mientras que la interfaz Queue y sus implementaciones como LinkedList están más orientadas a operaciones de cola, lo que puede llevar a una leve ventaja en términos de rendimiento.

cola 1mn 4sg tiempo en terminal
pila 47 seg  tiempo en terminal


