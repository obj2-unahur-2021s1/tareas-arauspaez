import ar.edu.unahur.obj2.tareas.Empleado
import ar.edu.unahur.obj2.tareas.Responsable
import ar.edu.unahur.obj2.tareas.TareaIntegracion
import ar.edu.unahur.obj2.tareas.TareaSimple

// Pueden usar este archivo para hacer pruebas rápidas,
// de la misma forma en que usaban el REPL de Wollok.

// OJO: lo que esté aquí no será tenido en cuenta
// en la corrección ni reemplaza a los tests.

val empleado1 = Responsable(1000)
val empleado2 = Responsable(1000)
val empleado3 = Responsable(1000)

// Responsable
val teamLeader = Responsable(1000)
val teamLeaderCrack = Responsable(1500)

// Tareas
val tareaSimple1 = TareaSimple(100,teamLeader)
val tareaSimple2 = TareaSimple(100,teamLeader)
val tareaSimple3 = TareaSimple(100,teamLeader)


tareaSimple1.empleados = mutableListOf(empleado1,empleado2,empleado3)
tareaSimple2.empleados = mutableListOf(empleado1,empleado2,empleado3)
tareaSimple3.empleados = mutableListOf(empleado1,empleado2,empleado3)

val tareaIntegracion1 = TareaIntegracion(1000,teamLeader)
tareaIntegracion1.listaTareas = mutableListOf(tareaSimple1,tareaSimple2,tareaSimple3)


