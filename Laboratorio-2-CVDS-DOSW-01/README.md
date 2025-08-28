## Laboratorio 2 DOSW

## INTEGRANTES
Felipe Calvache
Sebastian Duque


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



# Reto 4 - Casa de Cambio

## Patrón de Diseño
Estructural

## Patrón Utilizado
Facade (Fachada)

## Justificación
El patrón Facade permite centralizar y simplificar la interacción con sistemas complejos. En este caso, la clase `CasaDeCambio` actúa como fachada, ocultando la lógica de conversión y tasas detrás de una interfaz sencilla para el usuario y el resto del sistema.

## Cómo lo aplico
La clase `CasaDeCambio` expone el método `convertir` para realizar la conversión entre monedas, mientras que el resto del sistema solo interactúa con esta fachada sin preocuparse por los detalles internos. Las transacciones se gestionan de forma independiente y los totales se calculan usando streams.

# Reto 6 - Soporte Técnico

## Patrón de Diseño
Comportamiento

## Patrón Utilizado
Chain of Responsibility (Cadena de Responsabilidad)

## Justificación
El patrón Chain of Responsibility permite desacoplar el emisor de una petición de sus receptores, encadenando objetos que pueden procesar la petición. Así, cada técnico puede intentar resolver el ticket y, si no puede, lo pasa al siguiente técnico en la cadena.

## Cómo lo aplico
Cada técnico (`Tecnico`) implementa el método `procesar` y tiene una referencia al siguiente técnico en la cadena. Los tickets se procesan desde el técnico básico, pasando por intermedio y avanzado según el nivel y prioridad. Si ningún técnico puede resolver el ticket, se marca como pendiente de escalamiento. Se usan streams para generar estadísticas de tickets resueltos por nivel.

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
