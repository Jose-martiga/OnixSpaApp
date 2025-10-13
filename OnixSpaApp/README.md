# OnixSpaApp

## Descripción
Aplicación Java orientada a objetos para la gestión de reservas de Ónix Spa.  
Permite insertar, consultar, actualizar y eliminar reservas conectándose a MySQL mediante JDBC.

## Requisitos previos
- Java JDK 8 o superior
- MySQL Server instalado y en ejecución
- Conector JDBC (`mysql-connector-j-<versión>.jar`) agregado a las bibliotecas del proyecto
- NetBeans o IntelliJ IDEA

## Instalación de la base de datos
1. Abre MySQL Workbench o consola.
2. Ejecuta el script **`onixspa_schema.sql`** incluido en el proyecto:
   ```sql
   mysql -u root -p < onixspa_schema.sql

