package ar.edu.unahur.obj2.tareas
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe


class TareaTest : DescribeSpec({

    // Empleados
    val empleadoJunior1 = Empleado(600)
    val empleadoJunior2 = Empleado(600)
    val empleadoSenior1 = Empleado(1000)
    val empleadoSenior2 = Empleado(1000)

    // Responsables
    val teamLeader = Empleado(1000)
    val teamLeaderCrack = Empleado(1500)

    // Tareas simples
    val tareaSimpleLight = TareaSimple(50,teamLeader)
    tareaSimpleLight.empleados = mutableListOf(empleadoJunior1,empleadoJunior2)
    tareaSimpleLight.costoInfraestructura = 420

    val tareaSimpleHeavy = TareaSimple(100,teamLeader)
    tareaSimpleHeavy.empleados = mutableListOf(empleadoSenior1,empleadoSenior2)
    tareaSimpleHeavy.costoInfraestructura = 800

    // Tareas de integracion
    val tareaIntegracionLight = TareaIntegracion(500,teamLeaderCrack)
    tareaIntegracionLight.listaTareas = mutableListOf(tareaSimpleLight)

    val tareaIntegracionHeavy = TareaIntegracion(1000,teamLeaderCrack)
    tareaIntegracionHeavy.listaTareas = mutableListOf(tareaIntegracionLight,tareaSimpleHeavy)
    //Incluye una tarea simple y una tarea de integracion.


    //REQ.1
    describe("La nomina de empleados") {
        it("para una TareaSimple") {
            tareaSimpleLight.nominaEmpleados().shouldContainExactlyInAnyOrder (empleadoJunior1,empleadoJunior2,teamLeader)
        }
        it("para una TareaIntegracion con una TareaSimple en listaTareas"){
            tareaIntegracionLight.nominaEmpleados().shouldContainExactlyInAnyOrder (empleadoJunior1,empleadoJunior2,teamLeader,teamLeaderCrack)
        }
        it("para una TareaIntegracion con una TareaSimple y una TareaIntegracion en listaTareas"){
            tareaIntegracionHeavy.nominaEmpleados().shouldContainExactlyInAnyOrder (empleadoJunior1,empleadoJunior2,teamLeader,teamLeaderCrack,empleadoSenior1,empleadoSenior2,teamLeader,teamLeaderCrack)
        }
    }

    //REQ.2
    describe("horasNecesarias"){
        it("para una TareaSimple"){
            tareaSimpleLight.horasNecesarias() shouldBe 25
        }
        it("para una TareaIntegracion"){
            tareaIntegracionHeavy.horasNecesarias() shouldBe 87
        }
    }

    //REQ.3
    describe("costoTarea"){
        it("para una TareaSimple"){
            tareaSimpleLight.costoTarea() shouldBe 80420
        }
        it("para una TareaIntegracion"){
            tareaIntegracionHeavy.costoTarea() shouldBe 292140
        }
    }
})
