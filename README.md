# Formulario de Registro e Inicio de Sesión (JavaFX) 🛡️

Este proyecto es una aplicación de escritorio desarrollada en **Java** utilizando **JavaFX** y gestionada con **Maven**. Implementa un sistema completo de registro e inicio de sesión con validaciones estrictas en tiempo real, persistencia de datos y una interfaz dinámica con elementos multimedia.

## 🚀 Características Principales

* **Sistema de Doble Pantalla (Registro/Login)**: Navegación fluida entre el formulario de registro y la pantalla de inicio de sesión mediante hipervínculos dinámicos.
* **Validación de Datos Robusta**: Implementación de lógica personalizada en `UserDataValidations` para asegurar la integridad de los datos:
* **Registro**: Validación de nombre, DNI (con algoritmo de letra), código postal, fecha de nacimiento, formato de email y contraseña obligatoria.
* **Login**: Comprobación de campos vacíos antes de procesar el acceso.


* **Feedback Visual Dinámico**: Uso de la figura de un "segurata" que reacciona visualmente según las acciones del usuario:
* `segurata_no.png`: Se muestra cuando hay errores en los campos o datos inválidos.
* `segurata_si.png`: Aparece tras un registro o inicio de sesión exitoso.


* **Multimedia Interactiva**:
* Vídeo de seguridad (`segurata_vid.mp4`) integrado en la pantalla principal que se activa mediante el "Botón Mágico".
* **Pantalla de Sorpresa**: Una escena dedicada exclusivamente a la reproducción de contenido multimedia.


* **Persistencia de Usuarios**: Los datos de registro se almacenan automáticamente en un archivo de texto plano llamado `RegistroUsuarios.txt` utilizando una librería personalizada de gestión de ficheros.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje**: Java 11.
* **GUI**: JavaFX 13 (Módulos: controls, fxml, media).
* **Gestión de Dependencias**: Maven.
* **Diseño de Interfaz**: FXML y Scene Builder.

## 📁 Estructura del Proyecto

```text
src/main/java/
├── com.creus.login.login_register_creus/
│   ├── App.java                 # Clase principal y gestión de navegación
│   ├── Launcher.java            # Punto de entrada para el JAR
│   ├── controller/
│   │   ├── Login_gridController.java  # Control del formulario de registro
│   │   ├── Login_loginController.java # Control del inicio de sesión
│   │   └── SurpriseController.java    # Control de la pantalla multimedia
│   └── model/
│       └── UserDataValidations.java   # Lógica de validación de negocio
└── module-info.java             # Configuración de módulos del sistema

src/main/resources/
├── com/creus/login/login_register_creus/
│   ├── login_grid.fxml          # Vista de registro
│   ├── login_login.fxml         # Vista de inicio de sesión
│   └── Surprise.fxml            # Vista de sorpresa
└── img/                         # Recursos visuales (imágenes y vídeos)

```

## ⚙️ Instalación y Ejecución

Para ejecutar este proyecto, necesitas tener instalado **Maven** y un **JDK 11** o superior.

1. **Clonar el repositorio**.
2. **Ejecutar mediante Maven**:
Desde la terminal en la raíz del proyecto, usa el siguiente comando:
```bash
mvn clean javafx:run

```



---

**Autor**: Nil Creus