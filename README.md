# 📱 TecnoStore

Sistema de gestión para una tienda de teléfonos celulares desarrollado en **Java 17**, utilizando **Programación Orientada a Objetos (POO)**, **JDBC**, **MySQL** y **Maven**.

El sistema automatiza la administración de celulares, clientes, ventas e inventario mediante una aplicación de consola.

---

# ✨ Características

- 📱 Gestión completa de celulares (CRUD).
- 👤 Gestión completa de clientes (CRUD).
- 💰 Registro de ventas con cálculo automático del IVA (19%).
- 📦 Actualización automática del inventario.
- 📊 Reportes de ventas.
- 📄 Generación automática del archivo `reporte_ventas.txt`.
- 🗄️ Persistencia de datos mediante JDBC.
- 🏭 Implementación del patrón de diseño Factory.
- ⚡ Uso de Stream API y colecciones.

---

# 🛠 Tecnologías

- Java 17
- Maven
- MySQL 8
- JDBC
- Stream API
- Programación Orientada a Objetos

---

# 📂 Estructura del proyecto

```
Proyecto_Java17
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   ├── app
│   │   │   └── Main.java
│   │   │
│   │   ├── dao
│   │   │   ├── CelularDAO.java
│   │   │   ├── ClienteDAO.java
│   │   │   ├── VentaDAO.java
│   │   │   ├── DetalleVentaDAO.java
│   │   │   └── ReporteDAO.java
│   │   │
│   │   ├── database
│   │   │   ├── Conexion.java
│   │   │   └── TecnoStore_DB.sql
│   │   │
│   │   ├── enums
│   │   │
│   │   ├── factory
│   │   │   └── CelularFactory.java
│   │   │
│   │   ├── gestores
│   │   │
│   │   ├── models
│   │   │
│   │   └── utils
│   │
│   └── resources
│
├── README.md
├── pom.xml
└── reporte_ventas.txt
```

---

# 📱 Gestión de celulares

El sistema permite:

- Registrar celulares.
- Actualizar información.
- Eliminar celulares.
- Consultar el catálogo.
- Validar precio y stock.
- Gestionar disponibilidad automáticamente.

---

# 👤 Gestión de clientes

Permite:

- Registrar clientes.
- Actualizar clientes.
- Eliminar clientes.
- Consultar clientes.
- Validar correo electrónico.
- Validar identificación única.

---

# 💰 Gestión de ventas

El sistema permite:

- Seleccionar cliente.
- Seleccionar celular.
- Registrar la venta.
- Calcular IVA (19%).
- Calcular subtotal y total.
- Registrar detalle de la venta.
- Actualizar el stock automáticamente.
- Generar factura en consola.

---

# 📊 Reportes

Actualmente incluye:

- Ingresos totales.
- Celular más vendido.
- Cliente con mayor número de compras.
- Exportación de ventas a `reporte_ventas.txt`.

---

# 🗄️ Base de datos

El sistema utiliza MySQL con las siguientes tablas:

- celulares
- clientes
- ventas
- detalle_ventas

Todas relacionadas mediante llaves foráneas para garantizar la integridad de los datos.

---

# 🏛 Arquitectura

El proyecto sigue una arquitectura por capas.

```
Main
   │
   ▼
Gestores
   │
   ▼
DAO
   │
   ▼
Conexión JDBC
   │
   ▼
MySQL
```

---

# 🧩 Conceptos aplicados

- Programación Orientada a Objetos
- Encapsulamiento
- Composición
- Enumeraciones (Enums)
- Colecciones (`ArrayList`)
- Stream API
- JDBC
- Try-with-resources
- Patrón de diseño Factory

---

# ⚙️ Configuración

Modificar los datos de conexión si es necesario:

```java
private static final String URL =
"jdbc:mysql://localhost:3306/TecnoStore_DB";

private static final String USUARIO =
"tecnostore";

private static final String PASSWORD =
"TecnoStore123!";
```

Luego ejecutar el script:

```
TecnoStore_DB.sql
```

para crear la base de datos.

---

# ▶️ Ejemplo de ejecución

```
=========== TECNOSTORE ===========

1. Gestionar celulares
2. Gestionar clientes
3. Gestionar ventas
4. Reportes
5. Salir
```

---

# 📄 Archivo generado

Después de registrar ventas el sistema puede generar automáticamente:

```
reporte_ventas.txt
```

con el resumen de todas las ventas registradas.

---

# 👨‍💻 Autor

**Angelux 331**

Proyecto desarrollado como solución para la gestión de inventario, clientes y ventas de **TecnoStore**, aplicando Programación Orientada a Objetos, JDBC, MySQL y buenas prácticas de desarrollo.