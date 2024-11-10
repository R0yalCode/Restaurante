# Sistema de Gestión de Pedidos de Restaurante
Este proyecto tiene como objetivo implementar el módulo de Pedidos dentro de un sistema de gestión para un restaurante. El sistema está basado en un diagrama UML diseñado en la Unidad 1, donde se incluyen los conceptos fundamentales de la programación orientada a objetos (POO), como la abstracción, encapsulación, herencia y polimorfismo.

## Estructura del Proyecto
El sistema está compuesto por 6 módulos principales, cada uno enfocado en diferentes aspectos del restaurante, y mi módulo en particular se encarga de gestionar los pedidos. A continuación se describe la implementación de este módulo.

## Módulo de Pedidos
Este módulo tiene la responsabilidad de gestionar los pedidos realizados por los clientes, mantener un registro de los elementos solicitados y calcular el total de la factura. Los conceptos de abstracción y encapsulación son aplicados a través de clases que representan diferentes entidades como Pedido, Producto, Cliente, entre otros.

### Diagrama UML
Se adjunta el diagrama UML que fue actualizado durante la implementación, reflejando los cambios realizados al modelo original:


## Implementación de POO
### Abstracción y Encapsulación
- Abstracción: Se definen las clases que representan los elementos esenciales del sistema (por ejemplo, Pedido, Producto, Cliente). Estas clases ocultan los detalles de implementación y exponen solo la información necesaria.
- Encapsulación: Los atributos de cada clase son privados y se acceden y modifican mediante métodos públicos (getters y setters). Esto asegura que la información esté protegida y no pueda ser alterada de manera no controlada.

### Herencia y Polimorfismo
Se implementó herencia para crear una jerarquía de clases. Por ejemplo, la clase Pedido es una clase base, mientras que clases como PedidoDomicilio y PedidoMesa heredan de esta clase base, adaptando funcionalidades específicas para cada tipo de pedido.

El polimorfismo se aplica en la ejecución de métodos como calcularTotal(), donde la implementación de este método puede variar dependiendo del tipo de pedido. Las subclases sobreescriben este método para ajustar el cálculo según las reglas del pedido en particular.
