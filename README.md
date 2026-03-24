# Formulario de Registro e Inicio de Sesión (JavaFX + SQLite) 🛡️

Este proyecto es una aplicación de escritorio desarrollada en **Java** utilizando **JavaFX**, gestionada con **Maven** e integrada con una base de datos **SQLite**. El sistema permite el registro de usuarios con validaciones en tiempo real y un inicio de sesión funcional contra una base de datos persistente.

## 🚀 Características Principales

* **Persistencia con SQLite**: Migración de archivos de texto plano a una base de datos relacional local (`registerBBDD.db`) para una gestión de datos más robusta.
* **Sistema de Navegación**: Flujo dinámico entre pantallas (Registro ↔ Login ↔ Sorpresa) utilizando un método centralizado en `App.java`.
* **Validación de Datos Avanzada**: Lógica personalizada en `UserDataValidations` que asegura la integridad de los campos antes de interactuar con la base de datos:
    * Validación de DNI (Algoritmo de letra), Código Postal (rango nacional), Fecha y Correo electrónico.
    * Comprobación de campos obligatorios y contraseñas vacías.
* **Feedback Visual Dinámico**: Uso de la figura de un "segurata" que reacciona según el éxito o error de las operaciones:
    * `segurata_no.png`: Error en validación o credenciales incorrectas.
    * `segurata_si.png`: Registro o inicio de sesión exitoso.
* **Elementos Multimedia**:
    * Reproducción de vídeo de seguridad en la pantalla principal.
    * Pantalla dedicada `Surprise.fxml` con control de `MediaView`.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje**: Java 11.
* **GUI**: JavaFX 13 (Módulos: controls, fxml, media).
* **Base de Datos**: SQLite JDBC.
* **Gestión de Dependencias**: Maven.
* **Diseño**: FXML y Scene Builder.

## 📁 Estructura del Proyecto

```text
src/main/java/
├── com.creus.login.login_register_creus/
│   ├── App.java                 # Clase principal y gestión de escenas
│   ├── Launcher.java            # Lanzador de la aplicación
│   ├── controller/
│   │   ├── Login_gridController.java  # Control del registro y BBDD
│   │   ├── Login_loginController.java # Control del inicio de sesión
│   │   └── SurpriseController.java    # Control de multimedia
│   └── model/
│       ├── DatabaseManager.java       # Gestión de la conexión SQLite
│       └── UserDataValidations.java   # Lógica de validación de negocio
└── module-info.java             # Configuración de módulos (java.sql incluido)

src/main/resources/
├── com/creus/login/login_register_creus/
│   ├── login_grid.fxml          # Vista de registro
│   ├── login_login.fxml         # Vista de login
│   └── Surprise.fxml            # Vista sorpresa
└── img/                         # Recursos (imágenes y vídeo)
```

## ⚙️ Instalación y Ejecución

Para ejecutar este proyecto, necesitas **Maven** y un **JDK 11** o superior.

1. **Clonar el repositorio**.
2. **Configurar la Base de Datos**: Asegúrate de que el archivo `registerBBDD.db` esté en la raíz del proyecto con la tabla `usuarios` correctamente creada.
3. **Compilar y Ejecutar**:
Usa el comando de Maven para iniciar la aplicación:
```bash
mvn clean javafx:run
```

---

**Autor**: Nil Creus