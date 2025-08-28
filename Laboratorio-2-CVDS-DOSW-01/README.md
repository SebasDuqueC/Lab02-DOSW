# Laboratorio 2 SOLID, Patrones de Diseño y UML

**Integrantes:** 
- Felipe Calvache
- Sebastian Duque

**Nombre De la Rama**
'feature/Calvache_Duque_2025-2'

---

# Preguntas Iniciales
1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?
2. ¿Por qué una clase inmutable puede mejorar la seguridad?
3. ¿Qué problema podría aparecer en un sistema si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?
4. ¿Según el principio de Abierto/Cerrado, como deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?
5. ¿Por qué es importante que una clase cumpla con el Principio de única responsabilidad y que ejemplo sencillo podrías dar donde se vulnere?
6. ¿Qué es y porque usamos el pom.xml?
7. ¿Qué diferencia hay entre mvn compile, mvn package y mvn install?
8. ¿Qué diferencia existe entre una interfaz y una clase abstracta?

# Solución Preguntas
1. El polimorfismo permite que diferentes clases implementen métodos con el mismo nombre, facilitando la extensión y el mantenimiento del código. Evita el uso excesivo de condicionales, haciendo el sistema más flexible y escalable.
2. Las clases inmutables no permiten modificar su estado después de ser creadas, lo que previene errores, condiciones de carrera y facilita la concurrencia, aumentando la seguridad y confiabilidad del sistema.
3. Si los atributos son públicos, cualquier parte del código puede modificarlos libremente, lo que puede provocar inconsistencias, dificultar el mantenimiento y vulnerar la encapsulación.
4. Se debe extender el sistema mediante herencia o composición, creando nuevas clases o métodos que añadan la funcionalidad, sin modificar el código ya implementado.
5. Una clase debe tener una sola responsabilidad para facilitar su mantenimiento y reutilización. Ejemplo de violación: una clase que gestiona usuarios y también realiza operaciones de base de datos.
6. El pom.xml es el archivo de configuración de Maven, donde se definen dependencias, plugins y configuraciones del proyecto Java. Permite gestionar el ciclo de vida del proyecto de forma automatizada.
7. - mvn compile: compila el código fuente.
   - mvn package: compila y empaqueta el proyecto (por ejemplo, en un JAR).
   - mvn install: compila, empaqueta y copia el artefacto al repositorio local.
8. Una interfaz solo define métodos sin implementación, mientras que una clase abstracta puede tener métodos implementados y atributos. Una clase puede implementar varias interfaces, pero solo heredar de una clase abstracta.




# Parte 2 - Hackathon Express 2025-2
# Reto 1 - El problema de la tienda de Don Pepe

## Patrón de Diseño
Comportamiento

## Patrón utilizado
Strategy

## Justificación
El patrón que aplicamos es Strategy porque encapsulamos la lógica de los descuentos en un “estrategia” que depende del tipo de cliente. Esto le da flexibilidad y evita código rígido.

# Reto 2 - Hamburguesas

## Patrón de Diseño
Creacional

## Patrón Utilizado
Builder Pattern

## Justificación
El patrón Builder permite construir objetos complejos paso a paso, evitando constructores con demasiados parámetros y ofreciendo flexibilidad para crear distintas combinaciones de un mismo producto.En este caso, una hamburguesa puede contener distintos ingredientes opcionales (pan, carne, queso, vegetales, salsas). El Builder permite que el cliente (usuario) decida qué ingredientes incluir de manera clara y fluida, sin necesidad de múltiples constructores o configuraciones rígidas.

## Cómo lo apliquamos
1. Creé una clase Ingrediente que contiene el nombre y precio de cada ingrediente.
2. La clase Hamburguesa representa el producto final (lista de ingredientes seleccionados).
3. La clase HamburguesaBuilder implementa el patrón Builder, con métodos encadenados (agregarPan(), agregarCarne(), etc.) para añadir ingredientes opcionales.
4. El método build() del builder retorna la hamburguesa final lista para mostrarse.
5. Se usaron Streams (mapToDouble) para calcular el precio total de manera elegante y concisa.
6. En Main, el cliente personaliza su hamburguesa encadenando métodos del builder y genera la hamburguesa final.

# Reto 3 - El Reino de los Vehículos

## Patrón de Diseño
Creacional

## Patrones Utilizados
Abstract Factory y Builder

## Justificación
El patrón Abstract Factory permite crear familias de vehículos (Tierra, Acuático, Aéreo) y sus categorías (Económico, Lujo, Usado) sin acoplar el código a clases concretas. Así, el sistema es flexible y escalable para agregar nuevos tipos o modelos de vehículos.
El patrón Builder facilita la construcción de vehículos con diferentes características y equipamiento, permitiendo agregar atributos de manera ordenada y clara.

## Cómo lo aplico
* Se implementaron fábricas concretas (`TierraFactory`, `AcuaticoFactory`, `AereoFactory`) que generan builders para cada tipo de vehículo y categoría.
* El builder (`VehiculoBuilder`) permite configurar el modelo, categoría, tipo y equipamiento antes de crear la instancia final del vehículo.
* El usuario puede seleccionar X cantidad de vehículos, especificando tipo, categoría y modelo, y el sistema los genera usando los patrones mencionados.
* Se utiliza la API de Streams de Java para calcular el precio total de la compra de manera eficiente y declarativa.


# Reto 4 - Casa de Cambio

## Patrón de Diseño
Estructural

## Patrón Utilizado
Facade (Fachada)

## Justificación
El patrón Facade permite centralizar y simplificar la interacción con sistemas complejos. En este caso, la clase `CasaDeCambio` actúa como fachada, ocultando la lógica de conversión y tasas detrás de una interfaz sencilla para el usuario y el resto del sistema.

## Cómo lo aplico
La clase `CasaDeCambio` expone el método `convertir` para realizar la conversión entre monedas, mientras que el resto del sistema solo interactúa con esta fachada sin preocuparse por los detalles internos. Las transacciones se gestionan de forma independiente y los totales se calculan usando streams.

# Reto 5 - El café personalizado

## Patrón utilizado
Estructural

## Justificacion 
En este reto aplicamos el patrón de diseño estructural, que nos permitió extender dinámicamente las funcionalidades de un objeto (el café) sin necesidad de modificar la clase base.
Fue la mejor elección porque modela perfectamente el concepto de “personalizar un café con múltiples combinaciones de toppings” de manera flexible, reutilizable y mantenible.

# Reto 6 - Soporte Técnico

## Patrón de Diseño
Comportamiento

## Patrón Utilizado
Chain of Responsibility (Cadena de Responsabilidad)

## Justificación
El patrón Chain of Responsibility permite desacoplar el emisor de una petición de sus receptores, encadenando objetos que pueden procesar la petición. Así, cada técnico puede intentar resolver el ticket y, si no puede, lo pasa al siguiente técnico en la cadena.

## Cómo lo aplico
Cada técnico (`Tecnico`) implementa el método `procesar` y tiene una referencia al siguiente técnico en la cadena. Los tickets se procesan desde el técnico básico, pasando por intermedio y avanzado según el nivel y prioridad. Si ningún técnico puede resolver el ticket, se marca como pendiente de escalamiento. Se usan streams para generar estadísticas de tickets resueltos por nivel.


## Reto 7 - El control remoto magico

## Patrón de Diseño
Comportamiento

## Justificacion
Nos dio la flexibilidad de tratar todas las acciones como objetos reutilizables y reversibles.
Encapsular cada acción en una clase independiente respeta SRP (Principio de Responsabilidad Única de SOLID).
Con Command logramos un sistema flexible, extensible, con historial y capacidad de deshacer, exactamente lo que pedía el problema.