package ar.edu.unahur.obj2.tareas
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


class TareaTest : DescribeSpec({

  // Empleados
  val empleadoJunior1 = Empleado(600)
  val empleadoJunior2 = Empleado(600)
  val empleadoSenior1 = Empleado(1000)
  val empleadoSenior2 = Empleado(1000)

  // Responsables
  val teamLeader = Responsable(1000)
  val teamLeaderCrack = Responsable(1500)

  // Tareas
  val tareaSimpleLight = TareaSimple(50,teamLeader)
  tareaSimpleLight.empleados = mutableListOf(empleadoJunior1,empleadoJunior2)
  //tareaSimpleLight.costoInfraestructura = 420

  val tareaSimpleHeavy = TareaSimple(100,teamLeader)
  tareaSimpleHeavy.empleados = mutableListOf(empleadoSenior1,empleadoSenior2)
  //tareaSimpleHeavy.costoInfraestructura = 800

  val tareaIntegracionLight = TareaIntegracion(500,teamLeaderCrack)
  tareaIntegracionLight.listaTareas = mutableListOf(tareaSimpleLight)

  val tareaIntegracionHeavy = TareaIntegracion(1000,teamLeaderCrack)
  tareaIntegracionHeavy.listaTareas = mutableListOf(tareaIntegracionLight,tareaSimpleHeavy)
  //Incluye una tarea simple y una tarea de integracion.


  //REQ.1
  /*describe("La nomina de empleados") {
    it("para una TareaSimple"){
      tareaSimpleLight.nominaEmpleados() shouldBe 80000
    }
    it("para una TareaIntegracion"){
      tareaIntegracionLightnominaEmpleados() shouldBe x
    }
  }*/

  //REQ.2
  describe("Horas necesarias"){
    it("para una TareaSimple"){
      tareaSimpleLight.horasNecesarias() shouldBe 25
    }
    it("para una TareaIntegracion"){
      tareaIntegracionHeavy.horasNecesarias() shouldBe 87 // Verificar este calculo
    }
  }




})
