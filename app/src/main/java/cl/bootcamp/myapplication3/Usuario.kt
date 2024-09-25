package cl.bootcamp.myapplication3


class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,         // Trabajo puede ser nulo
    val referencia: Usuario? = null      // Referencia puede ser otro Usuario, o nulo
) {
    fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Edad: $edad")
        println("Trabajo: ${trabajo ?: "No especificado"}")
        println("Referencia: ${referencia?.nombre ?: "Ninguna"}")
        println("*************************************") // Línea separadora
    }
}

fun main() {
    // Crear usuarios
    val usuario1 = Usuario(nombre = "Maria", edad = 30, trabajo = "Ingeniera")
    val usuario2 = Usuario(nombre = "Pedro", edad = 25, trabajo = null, referencia = usuario1)

    // Mostrar datos de los usuarios
    usuario1.mostrarDatos()
    usuario2.mostrarDatos()
}
