package ar.edu.unsam.algo2.contenidos

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate
class SeriesSpec: DescribeSpec ({
    isolationMode = IsolationMode.InstancePerTest
    describe("Test series"){
        it("serie con presupuesto bajo no es interesante"){
            //Arrange
            val serieSinPresupuesto = Serie(presupuesto = 2)
            //Assert
            serieSinPresupuesto.esInteresante() shouldBe false
        }
        it("serie con muchas temporadas no es interesante"){
            //Arrange
            val serieMuchasTemporadas = Serie(presupuesto = 6, temporadas = 5)
            //Assert
            serieMuchasTemporadas.esInteresante() shouldBe false
        }
        it("serie con pocas temporadas y con buen presupuesto es interesante"){
            //Arrange
            val serieInteresante = Serie(presupuesto = 6, temporadas = 4)
            //Assert
            serieInteresante.esInteresante() shouldBe true
        }
    }

})

class PeliculasSpec: DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest
    describe("Test peliculas"){
        it("pelicula con presupeusto bajo no es interesante"){
            //Arrange
            val peliculaSinPresupuesto = Pelicula(presupuesto = 2)
            //Assert
            peliculaSinPresupuesto.esInteresante() shouldBe false
        }
        it("pelicula estrenada hace mucho no es interesante"){
            //Arrange
            val hace2Anios = LocalDate.now().minusYears(2)
            val peliculaVieja = Pelicula(presupuesto = 6, fechaEstreno = hace2Anios)
            //Assert
            peliculaVieja.esInteresante() shouldBe false
        }
        it("pelicula estrenada recientemente y con buen presupuesto es interesante"){
            //Arrange
            val peliculaEstrenada = Pelicula(presupuesto = 6, fechaEstreno = LocalDate.now())
            //Assert
            peliculaEstrenada.esInteresante() shouldBe true
        }
    }
})