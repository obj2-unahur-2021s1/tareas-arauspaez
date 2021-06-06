package ar.edu.unahur.obj2.tareas

import kotlin.properties.Delegates

interface TipoTarea{
    fun horasNecesarias(): Int
    fun salarioEmpleado(empleado: Empleado): Int
    fun salarioResponsable(): Int
    fun salarioTotalEmpleados(): Int
    fun costoTarea(): Int
}

class Tarea(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{

    val costoInfraestructura by Delegates.notNull<Int>()  // Tratar de que no tenga un inicializador
    val empleados = mutableListOf<Empleado>()

    override fun horasNecesarias() = horasEstimadas / empleados.size
    override fun salarioEmpleado(empleado: Empleado) = empleado.costoHoraTrabajo * this.horasNecesarias()
    override fun salarioResponsable() = responsable.costoHoraTrabajo * horasEstimadas
    override fun salarioTotalEmpleados() = empleados.sumBy { salarioEmpleado(it) }
    override fun costoTarea() = costoInfraestructura + this.salarioTotalEmpleados() + this.salarioResponsable()
}

class TareaIntegracion(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    override fun horasNecesarias() = 1
    override fun salarioEmpleado(empleado: Empleado) = 1
    override fun salarioResponsable() = 1
    override fun salarioTotalEmpleados() = 1
    override fun costoTarea() = 1
}