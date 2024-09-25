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

class ListaUsuarios {
    private val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun eliminarUsuario(nombre: String) {
        usuarios.removeIf { it.nombre == nombre }
    }

    fun mostrarLista() {
        if (usuarios.isEmpty()) {
            println("No hay usuarios en la lista.")
        } else {
            for (usuario in usuarios) {
                usuario.mostrarDatos()
            }
        }
    }

    // Nueva función para filtrar usuarios por edad
    fun filtrarPorEdad(edadMinima: Int): List<Usuario> {
        return usuarios.filter { it.edad > edadMinima }
    }

    // Método para mostrar usuarios filtrados
    fun mostrarUsuariosFiltrados(edadMinima: Int) {
        val usuariosFiltrados = filtrarPorEdad(edadMinima)
        if (usuariosFiltrados.isEmpty()) {
            println("No hay usuarios mayores a $edadMinima años.")
        } else {
            println("Usuarios mayores a $edadMinima años:")
            for (usuario in usuariosFiltrados) {
                println("Nombre: ${usuario.nombre}, Edad: ${usuario.edad}")
            }
        }
    }
}

fun main() {
    val listaUsuarios = ListaUsuarios()

    // Crear usuarios y agregarlos a la lista
    val usuario1 = Usuario(nombre = "Maria", edad = 30, trabajo = "Ingeniera")
    val usuario2 = Usuario(nombre = "Pedro", edad = 25, trabajo = null, referencia = usuario1)
    val usuario3 = Usuario(nombre = "Rodrigo", edad = 35, trabajo = "Arquitecto")
    val usuario4 = Usuario(nombre = "David", edad = 28, trabajo = "Diseñador", referencia = usuario3)
    val usuario5 = Usuario(nombre = "Jimena", edad = 32, trabajo = "Contadora")

    // Agregar usuarios a la lista
    listaUsuarios.agregarUsuario(usuario1)
    listaUsuarios.agregarUsuario(usuario2)
    listaUsuarios.agregarUsuario(usuario3)
    listaUsuarios.agregarUsuario(usuario4)
    listaUsuarios.agregarUsuario(usuario5)

    // Mostrar lista de usuarios
    println("Lista de Usuarios:")
    listaUsuarios.mostrarLista()

    // Eliminar un usuario (ejemplo: eliminar a "David")
    listaUsuarios.eliminarUsuario("David")

    // Mostrar lista de usuarios después de la eliminación
    println("Lista de Usuarios después de eliminar a David:")
    listaUsuarios.mostrarLista()

    // Filtrar usuarios mayores a una edad específica
    val edadFiltro = 30
    listaUsuarios.mostrarUsuariosFiltrados(edadFiltro)
}