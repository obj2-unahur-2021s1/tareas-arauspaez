package ar.edu.unahur.obj2.tareas

abstract class TipoEmpleado(open val costoHoraTrabajo: Int){ }

class Empleado(override val costoHoraTrabajo: Int) : TipoEmpleado(costoHoraTrabajo) { }

class Responsable(override val costoHoraTrabajo: Int) : TipoEmpleado(costoHoraTrabajo) { }
