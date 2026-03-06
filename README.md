# LoginJavaMaven 🛡️

Proyecto de escritorio desarrollado en **Java** utilizando **JavaFX** y gestionado con **Maven**. Se trata de un sistema de registro que implementa validaciones de datos en tiempo real, feedback visual dinámico y elementos multimedia.

## 🚀 Características principales

* **Validación Avanzada de Datos**: Implementación de lógica personalizada para verificar la integridad de la información ingresada:
* Validación de **DNI** mediante algoritmo de comprobación de letra.
* Verificación de **Código Postal** dentro del rango del territorio español.
* Validación de formato de **Fecha de Nacimiento** (DD/MM/AAAA) y coherencia cronológica.
* Validación de estructura de **Correo Electrónico**.
* Comprobación de campos obligatorios vacíos.


* **Feedback Visual Dinámico**: El sistema utiliza la figura de un "segurata" que reacciona según el estado del formulario:
* Imagen de advertencia (`segurata_no.png`) si hay errores en la validación.
* Imagen de éxito (`segurata_si.png`) cuando el registro es correcto.
* Resaltado de etiquetas de texto en color rojo ante datos inválidos.


* **Multimedia (Botón Mágico)**: Integración de un `MediaView` para reproducir un vídeo (`segurata_vid.mp4`) con retorno automático a la vista estática al finalizar la reproducción.
* **Persistencia de Datos**: Registro de usuarios exitosos en un archivo de texto plano (`RegistroUsuarios.txt`):
* Uso de una librería externa (`ClassFichero`) para la gestión de flujos de archivos.
* Cierre seguro de flujos al finalizar la aplicación mediante el método `stop()`.



## 🛠️ Tecnologías utilizadas

* **Lenguaje**: Java 11.
* **GUI**: JavaFX 13 (incluyendo módulos `controls`, `fxml` y `media`).
* **Gestión de dependencias**: Maven.
* **Diseño**: FXML y Scene Builder.

## 📁 Estructura del proyecto

```text
src/main/java/
├── com.creus.login.login_register_creus/
│   ├── App.java                 # Clase principal y gestión de ciclo de vida
│   ├── Launcher.java            # Lanzador de la aplicación
│   ├── controller/
│   │   └── Login_gridController.java # Lógica de control de la interfaz
│   └── model/
│       └── ValidationsRescate.java  # Lógica de validación de negocio
└── module-info.java             # Configuración de módulos de Java

src/main/resources/
├── com/creus/login/login_register_creus/
│   └── login_grid.fxml          # Definición de la interfaz gráfica
└── img/                         # Recursos visuales (imágenes y vídeo)

```

## ⚙️ Instalación y ejecución

Para ejecutar este proyecto, asegúrate de tener instalado **Maven** y un **JDK 11** o superior.

1. **Clonar el repositorio**.
2. **Compilar y ejecutar**:
Utiliza el comando integrado de Maven para JavaFX:
```bash
mvn clean javafx:run

```



---

**Autor**: Nil Creus