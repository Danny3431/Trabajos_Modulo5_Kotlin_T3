package cl.bootcamp.myapplication3

data class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String? = null,
    val referencia: String? = null,

)

class GestorUsuarios {
    private val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun eliminarUsuario(indice: Int) {
        if (indice in usuarios.indices) {
            usuarios.removeAt(indice)
        } else {
            println("Índice fuera de rango: $indice")
        }
    }

    fun mostrarLista() {
        if (usuarios.isEmpty()) {
            println("No hay usuarios en la lista.")
            return
        }

        println("\nLista de Usuarios:")
        for ((index, usuario) in usuarios.withIndex()) {
            println("Usuario ${index + 1}:")
            println("Nombre: ${usuario.nombre}")
            println("Edad: ${usuario.edad}")
            println("Trabajo: ${usuario.trabajo ?: "N/A"}")
            println("Referencia: ${usuario.referencia ?: "N/A"}")
            println("-------------------------")
        }
    }
}

fun main() {
    val gestor = GestorUsuarios()

    // Agregar cinco usuarios
    gestor.agregarUsuario(Usuario("Maria", 30, "Ingeniera", null))
    gestor.agregarUsuario(Usuario("Pedro", 25,  null ,  "Referencia1"))
    gestor.agregarUsuario(Usuario("Rodrigo", 35, "Arquitecto", null))
    gestor.agregarUsuario(Usuario("Ana", 28, "Diseñadora", "Referencia2"))
    gestor.agregarUsuario(Usuario("Luis", 35, null, null))

    // Mostrar la lista de usuarios
    gestor.mostrarLista()

    // Eliminar un usuario (por ejemplo, el segundo)
    gestor.eliminarUsuario(3) // Elimina a Ana

    // Volver a mostrar la lista de usuarios
    gestor.mostrarLista()
}

