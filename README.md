# Sistema de Gestión de Pedidos de Restaurante
Este proyecto tiene como objetivo implementar el módulo de Pedidos dentro de un sistema de gestión para un restaurante. El sistema está basado en un diagrama UML diseñado en la Unidad 1, que incluye los conceptos fundamentales de la programación orientada a objetos (POO), tales como la abstracción, encapsulación, herencia y polimorfismo.

## Estructura del Proyecto
El sistema está compuesto por 6 módulos principales, cada uno enfocado en diferentes aspectos del restaurante. El módulo de Pedidos se encarga específicamente de gestionar los pedidos. A continuación se describe la implementación de este módulo.

## Módulo de Pedidos
Este módulo tiene la responsabilidad de gestionar los pedidos realizados por los clientes, mantener un registro de los elementos solicitados y calcular el total de la factura. Los conceptos de abstracción y encapsulación se aplican a través de clases que representan diferentes entidades, como Pedido, Producto, Cliente, entre otros.

### Diagrama UML
Se adjunta el diagrama UML actualizado, que refleja los cambios realizados al modelo original durante la implementación.


![Diagrama_UML_Pedidos](https://github.com/user-attachments/assets/6b05f02c-bbea-43ee-afff-6912223fa713)
> Diagrama de clases-UML del modulo de pedidos 

# Carpeta java
[Carpeta.java](https://github.com/R0yalCode/Restaurante/blob/release/Correci%C3%B3n/ModuloPedidos2U.vpp)

Esta carpeta te redirecciona a donde se encuentran los archivos.java necesarios para ejecutar el proyecto localmente.

## Implementación de POO
### Reflexion
- Abstracción:
La abstracción se implementó al momento de crear las clases las cuales representan nuestro sistema de pedidos, dentro de nuestro diagrama UML encontramos las clases Persona, Cliente, Empleado, Plato y Pedido. Donde cada clase tiene sus métodos y atributos que son esenciales para que cumplan su propósito dentro del sistema que hemos creado.
- Encapsulación:
La encapsulación se implementó definiendo atributos como privados y accediendo a ellos mediante métodos públicos (getters y setters). Esto asegura que los datos de las clases sean protegidos y que su manipulación se realice de manera controlada. Por ejemplo, en la clase Cliente, los atributos cedula, nombre y telefono son privados, y su acceso está restringido mediante métodos. Esto garantiza que los datos no puedan ser alterados de forma directa y promueve la integridad del sistema.
- Herencia:
La herencia se utilizó para crear una jerarquía clara entre las clases del sistema. Por ejemplo, Cliente y Empleado heredan de la clase base Persona, reutilizando atributos y métodos comunes como nombre y telefono, lo que reduce la redundancia en el código. Adicionalmente, las subclases PersonalCocina y Mesero extienden la clase Empleado, proporcionando funcionalidades específicas según sus roles. Este diseño mejora la organización y la capacidad de mantenimiento del sistema.

- Polimorfismo:
El polimorfismo se aplicó mediante el uso de interfaces, como InteraccionPedido e InteraccionCliente, y métodos sobrescritos en las clases derivadas. Por ejemplo, las clases PersonalCocina y Mesero implementan el método prepararPedido() de formas diferentes, según sus responsabilidades. Este uso del polimorfismo permite que distintas clases respondan de manera específica a las mismas operaciones, promoviendo un diseño más flexible y extensible.

Cambios realizados:
Comparando con el diagrama de clases de la unidad 1, se realizaron varios cambios en nuestro sistema esto debido a que con las clases impartidas se obtuvo un mejor conocimiento acerca del tema, lo que podemos desatacar como cambio principal es el aumento de clases que será detallado a continuación.
-	Cambio de la clase Producto a Plato: Este cambio se realizo con el fin de que el usuario tenga un enfoque mucho más específico ya que dentro de un restaurante un producto se lo podría representar como un plato que vendría a ser parte del menú.

-	Incorporación clase Menú: Esto cambio se dio debido a que, mediante un Menú, podemos organizar los platos disponibles que tenemos dentro de un restaurante mejorando la estructura de nuestro sistema.

-	En nuestro primer diagrama UML, la clase Reservación cumplía con un papel más directo en relación con el cliente. Pero dentro del nuevo diseño el Cliente se encarga de interactuar de manera directa respecto a la clase Pedidos y Mesas, con esto se elimina la dependencia de la reservación. 

-	Cambio de ProductoPedido a ItemPedido: en el nuevo diseño se hizo esta nueva estructura mucho más general, la cual la mas flexibilidad y encapsula mejor la relación que hay éntrelos elementos de un pedido y los platos.

-	Destacamos el uso de interfaces en nuestro nuevo diseño donde tenemos InteraccionPedido e InteraccionCliente, permitiendo a nuestro sistema definir operaciones que serán implementadas por otras clases.

-	Se modifica la enumeración Estado organizando mejor y añadiendo un nuevo estado que es “Reservado”.

-	Se destaca el cambio de una jerarquía mucho mas detallada en nuestro nuevo sistema organizando mejor los roles (PersonalCocina y Mesero) ya que en el primer diagrama solo existía la clase Cocina.

-	Se realiza una mejor distribución en nuestro diagrama de clases respecto a las reponsabilidades donde se puede tomar como ejemplo la clase Mesa ahora contiene métodos mas claros que son reservar( ) o desocupar( ). 

-	Por ultimo se hace cambios a las calse Historial teniendo una mayor claridad.
Las dificultades que hemos presentado en la elaboración de nuestro proyecto a sido la manera en relacionar las diferentes clases de los diagramas UML esto debido a la falta de abstracción, pero mediante las diferentes clases e indicaciones del docente hemos mejorado nuestro diagrama con respecto a lo que se elaboro en la primera unidad.
#### Justificación: 
Este diseño lo hemos elaborado con el fin de que cualquier persona pueda entenderlo y de igual manera tenga una guía para que desarrolle su propio sistema.




