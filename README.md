# Sistema de Gestión de Pedidos de Restaurante
Este proyecto tiene como objetivo implementar el módulo de Pedidos dentro de un sistema de gestión para un restaurante. El sistema está basado en un diagrama UML diseñado en la Unidad 1, que incluye los conceptos fundamentales de la programación orientada a objetos (POO), tales como la abstracción, encapsulación, herencia y polimorfismo.

## Estructura del Proyecto
El sistema está compuesto por 6 módulos principales, cada uno enfocado en diferentes aspectos del restaurante. El módulo de Pedidos se encarga específicamente de gestionar los pedidos. A continuación se describe la implementación de este módulo.

## Módulo de Pedidos
Este módulo tiene la responsabilidad de gestionar los pedidos realizados por los clientes, mantener un registro de los elementos solicitados y calcular el total de la factura. Los conceptos de abstracción y encapsulación se aplican a través de clases que representan diferentes entidades, como Pedido, Producto, Cliente, entre otros.

### Diagrama UML
Se adjunta el diagrama UML actualizado, que refleja los cambios realizados al modelo original durante la implementación.


![Diagrama UML del restaurante](https://github.com/user-attachments/assets/5cdc074f-d407-4b31-95e8-9c37c3249dc1)
> Diagrama de clases-UML del modulo de pedidos 

# Carpeta java
[Carpeta.java](https://github.com/R0yalCode/Restaurante/blob/release/Correci%C3%B3n/ModuloPedidos2U.vpp)

Esta carpeta te redirecciona a donde se encuentran los archivos.java necesarios para ejecutar el proyecto localmente.

## Implementación de POO
### Abstracción y Encapsulación
- Abstracción: Se definen las clases que representan los elementos esenciales del sistema (por ejemplo, Pedido, Producto, Cliente). Estas clases ocultan los detalles de implementación y exponen solo la información necesaria.
- Encapsulación: Los atributos de cada clase son privados y se acceden y modifican mediante métodos públicos (getters y setters). Esto asegura que la información esté protegida y no pueda ser alterada de manera no controlada.

### Herencia y Polimorfismo
Se implementó herencia para crear una jerarquía de clases. Por ejemplo, la clase Pedido actúa como clase base, mientras que clases como PedidoDomicilio y PedidoMesa heredan de esta clase base, adaptando funcionalidades específicas para cada tipo de pedido.

El polimorfismo se aplica en la ejecución de métodos como `calcularTotal()`, donde la implementación de este método varía dependiendo del tipo de pedido. Las subclases sobreescriben este método para ajustar el cálculo según las reglas del pedido específico.
