# Tema 1: Expresiones Regulares + Funciones de Extensión
## 1. ¿Qué es una expresión regular?
- Es un tipo de “fórmula” que recoge un conjunto de Strings y permite filtrarlo según unas normas estipuladas, es decir, como un molde de un bizcocho pero con cadena de texto (String).
  
## 2. ¿Para qué se usan?
- Se usan generalmente como validación de formatos, como pueden ser correos electrónicos, números de teléfono o contraseñas. Permitiendo así validar los Strings correctos y anular automáticamente los que no pasen el filtro correctamente.
Se utiliza la clase Regex (Regular Expression) para funciones como buscar una palabra, dar formato o validez a ciertas cadenas de texto.

## 3. Explica las expresiones regulares con un ejemplo práctico. 
- Las expresiones regulares (regex) son patrones que se usan para buscar y manipular texto. En Kotlin,
se pueden usar para validar correos, extraer datos de cadenas, reemplazar texto y más(Ósea que es como un replace() o un substring() pero más flexible).
pero más flexible).

## 4. Localiza en la práctica del Ahorcado dónde se utiliza una expresión regular. Analiza y explica el código en detalle.

### Algunos ejemplos de metodos con expresiones regulares son:
```kotlin
- find(): Para encontrar la primera ocurrencia de un subtexto que cumple una expresión regular dentro de un texto
- findAll(): Busca todas las coincidencias de una expresión regular en un texto y devuelve una secuencia.
- split(): Divide una cadena en una lista usando una expresión regular como separador.
- replace(): Reemplaza las coincidencias de la expresión regular en la cadena por otro texto.
- containsMatchIn(): Verifica si la cadena contiene al menos una coincidencia de la expresión regular.

Nota: La expresion regular es 'Regex' o el patrón que se le indique.
```

| Símbolo | Significado |
|---------|------------|
| `.` | Cualquier carácter |
| `^` | Inicio de cadena |
| `$` | Fin de cadena |
| `*` | 0 o más repeticiones |
| `+` | 1 o más repeticiones |
| `?` | 0 o 1 repetición |
| `{n}` | Exactamente `n` repeticiones |
| `{n,}` | Al menos `n` repeticiones |
| `{n,m}` | Entre `n` y `m` repeticiones |


- [Clase Palabra de ejercicio Ahorcado](src/main/kotlin/Palabra.kt)

## 5. ¿Qué es una función de extensión?

- La función de extensión permite agregar nuevas funciones a una clase sin modificar su código original.
Esto es útil para mejorar clases ya existentes, como String, List, etc.

## 6. Desarrolla y explica una función de extensión que se llame filtrar para la clase List<String>. Esta función debe utilizar una expresión regular para filtrar los elementos de la lista. El resultado será una lista con los elementos que coincidan con el patrón que se pasará a dicha función.

- Una función extensión parecida a filter podría ser la siguiente:
  
```kotlin
fun List<String>.filtrar(patron: String): List<String> {
    return this.filter { it.matches(Regex(patron)) }
}
```

- Esta función de extensión se define como una extensión de List<String>, lo que significa que se puede llamar directamente sobre cualquier lista de cadenas de texto. El parámetro que recibe es la expresión regular que utilizamos, instanciando un objeto Regex con el patrón dicho, se filtra con matches para conservar las cadenas de texto que coincidan con la expresión regular.
