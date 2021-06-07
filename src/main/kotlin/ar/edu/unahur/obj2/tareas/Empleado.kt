package ar.edu.unahur.obj2.tareas


open class Empleado(open val costoHoraTrabajo: Int){}

class Responsable(override val costoHoraTrabajo: Int): Empleado(costoHoraTrabajo){}
