package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec

class TareaTest : DescribeSpec({

  // Empleado
  val empleado1 = Responsable(1000)

  // Responsable
  val teamLeader = Responsable(1000)
  val teamLeaderCrack = Responsable(1500)

  // Tareas
  val tareaSimple = TareaSimple(100,teamLeader)
  val tareaIntegracion = TareaIntegracion(1000,teamLeaderCrack)

  describe("Una tarea...") {  }
})
