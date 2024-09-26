package cl.bootcamp.myapplication3

fun main() {
    // Solicitar el número de usuarios
    var numeroDeUsuarios: Int

    do {
        println("¿Cuántos usuarios quieres ingresar? (mínimo 2)")
        numeroDeUsuarios = readLine()?.toIntOrNull() ?: 0
    } while (numeroDeUsuarios < 2)

    // Lista para almacenar los datos de los usuarios
    val usuarios = mutableListOf<Map<String, Any?>>()

    // Ciclo para ingresar los datos de cada usuario
    for (i in 1..numeroDeUsuarios) {
        println("Ingrese los datos del usuario $i:")

        // Validación del nombre
        var nombre: String
        do {
            println("Por favor ingresa tu nombre:")
            nombre = readLine() ?: ""
        } while (nombre.isBlank())

        // Validación de la edad
        var edadInput: String
        var edad: Int
        do {
            println("Por favor ingresa tu edad (debe ser un número entero):")
            edadInput = readLine() ?: ""
        } while (edadInput.isBlank() || !edadInput.all { it.isDigit() })

        // Convertir la edad a Int
        edad = edadInput.toInt()

        // Ingreso de trabajo y referencia (pueden quedar vacíos)
        println("Trabajo (puede quedar vacío):")
        val trabajo = readLine() ?: ""

        println("Referencia (puede quedar vacío):")
        val referencia = readLine() ?: ""

        // Agregar los datos del usuario a la lista
        usuarios.add(mapOf(
            "Nombre" to nombre,
            "Edad" to edad,
            "Trabajo" to trabajo,
            "Referencia" to referencia
        ))
    }

    // Mostrar los datos ingresados
    println("\nDatos ingresados:")
    for ((index, usuario) in usuarios.withIndex()) {
        println("Usuario ${index + 1}:")
        println("Nombre: ${usuario["Nombre"]}")
        println("Edad: ${usuario["Edad"]}")
        println("Trabajo: ${usuario["Trabajo"] ?: "N/A"}")
        println("Referencia: ${usuario["Referencia"] ?: "N/A"}")
        println("-------------------------")
    }
}