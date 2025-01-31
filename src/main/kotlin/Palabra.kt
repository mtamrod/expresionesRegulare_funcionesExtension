package es.iesra.prog2425_ahorcado

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.gson.*
import kotlinx.coroutines.runBlocking

class Palabra(val palabraOculta: String) {

    private val progreso: Array<Char> = Array(palabraOculta.length) { '_' }

    companion object {
        fun generarPalabras(cantidad: Int, tamanioMin: Int, tamanioMax: Int, idioma: Idioma = Idioma.ES): MutableSet<Palabra> {
            val client = HttpClient {
                install(ContentNegotiation) {
                    gson()
                }
            }

            val palabras = mutableSetOf<Palabra>() // Usamos un conjunto para evitar repeticiones
            val url = "https://random-word-api.herokuapp.com/word?number=${cantidad * 10}&lang=${idioma.codigo}"

            val patron = if (idioma == Idioma.ES) {
                "^[a-záéíóúüñ]+$" // + : Tener al menos 1 letra // $ : Terminar con 1 letra // ^ : Empezar con 1 letra
            } else {
                "^[a-z]+$"
            }

            runBlocking {
                try {
                    while (palabras.size < cantidad) {
                        // Hacemos la solicitud GET
                        val respuesta: Array<String> = client.get(url).body()

                        // Filtramos las palabras según las condiciones
                        val filtradas = respuesta
                            .map { it.trim().lowercase() } // Convertimos a minúsculas
                            .filter { it.length in tamanioMin..tamanioMax } // Filtramos por tamaño
                            .filter { it.matches(Regex(patron)) } // Solo letras
                            .filter { !it.contains(" ") } // Excluye palabras que contengan espacios
                            .map { Palabra(it) } // Mapeamos a la objetos de tipo Palabra

                        palabras.addAll(filtradas)
                    }
                } catch (e: Exception) {
                    println("Error al obtener las palabras: ${e.message}")
                }
            }

            client.close()
            return palabras.take(cantidad).toMutableSet()
        }
    }

    fun revelarLetra(letra: Char): Boolean {
        var acierto = false
        for (i in palabraOculta.indices) {
            if (palabraOculta[i].quitarAcentos() == letra.quitarAcentos()) {
                progreso[i] = palabraOculta[i]
                acierto = true
            }
        }
        return acierto
    }

    fun obtenerProgreso(): String {
        return progreso.joinToString(" ")
    }

    fun esCompleta(): Boolean {
        return !progreso.contains('_')
    }
}

