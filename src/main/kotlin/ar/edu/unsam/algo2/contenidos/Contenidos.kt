package ar.edu.unsam.algo2.contenidos

import java.time.LocalDate

abstract class Contenido(val presupuesto: Int) {
    open fun esInteresante() = presupuesto > 5

}

class Serie(presupuesto: Int, val temporadas: Int = 5) : Contenido(presupuesto) {
    override fun esInteresante() = super.esInteresante() && temporadas < 5
}

class Pelicula(presupuesto: Int, val fechaEstreno: LocalDate = LocalDate.now()) : Contenido(presupuesto){
    override fun esInteresante() = super.esInteresante() && seEstrenoRecientemente()

    fun seEstrenoRecientemente() = fechaEstreno.year == LocalDate.now().year
}