# Tema 1: Expresiones Regulares + Funciones de Extensió
## 1. ¿Qué es una expresión regular?¶
- Es un tipo de “fórmula” que recoge un conjunto de Strings y permite filtrarlo según unas normas estipuladas, es decir, como un molde de un bizcocho pero con cadena de texto (String).
  
## 2. ¿Para qué se usan?
- Se usan generalmente como validación de formatos, como pueden ser correos electrónicos, números de teléfono o contraseñas. Permitiendo así validar los Strings correctos y anular automáticamente los que no pasen el filtro correctamente.
Se utiliza la clase Regex (Regular Expression) para funciones como buscar una palabra, dar formato o validez a ciertas cadenas de texto.

## 3. Explica las expresiones regulares con un ejemplo práctico.
## 4. Localiza en la práctica del Ahorcado dónde se utiliza una expresión regular. Analiza y explica el código en detalle.

- [Clase Palabra de ejercicio Ahorcado](src/main/kotlin/Palabra.kt)

## 5. ¿Qué es una función de extensión?
## 6. Desarrolla y explica una función de extensión que se llame filtrar para la clase List<String>. Esta función debe utilizar una expresión regular para filtrar los elementos de la lista. El resultado será una lista con los elementos que coincidan con el patrón que se pasará a dicha función.

- Una función extensión parecida a filter podría ser la siguiente:
  
```kotlin
fun List<String>.filtrar(patron: String): List<String> {
    return this.filter { it.matches(Regex(patron)) }
}
```

- Esta función de extensión se define como una extensión de List<String>, lo que significa que se puede llamar directamente sobre cualquier lista de cadenas de texto. El parámetro que recibe es la expresión regular que utilizamos, instanciando un objeto Regex con el patrón dicho, se filtra con matches para conservar las cadenas de texto que coincidan con la expresión regular.
