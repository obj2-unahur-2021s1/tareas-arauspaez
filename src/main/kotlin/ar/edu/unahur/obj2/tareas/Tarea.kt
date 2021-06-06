package ar.edu.unahur.obj2.tareas

open class Tarea(open val horasEstimadas: Int,open val responsable: TipoEmpleado){
    var costoInfraestructura: Int = 0 // Tratar de que no tenga un inicializador
    lateinit var empleados: MutableList<TipoEmpleado>

    fun horasNecesarias() = horasEstimadas / empleados.size
    fun salarioEmpleado(empleado: TipoEmpleado) = empleado.costoHoraTrabajo * this.horasNecesarias()
    fun salarioResponsable() = responsable.costoHoraTrabajo * horasEstimadas
    fun salarioTotalEmpleados() = empleados.sumBy { salarioEmpleado(it) }
    fun costoTarea() = this.salarioTotalEmpleados() + this.salarioResponsable() + costoInfraestructura
}

class TareaIntegracion(override val horasEstimadas: Int,override val responsable: TipoEmpleado): Tarea(horasEstimadas,responsable){ }