package ar.edu.unahur.obj2.tareas

import kotlin.properties.Delegates

interface TipoTarea{
    fun horasNecesarias(): Int
    fun costoTarea(): Int
    fun nominaEmpleados(): List<Empleado>
}

class TareaSimple(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    val costoInfraestructura by Delegates.notNull<Int>()
    var empleados = mutableListOf<Empleado>()

    override fun horasNecesarias() = horasEstimadas / empleados.size
    fun salarioEmpleado(empleado: Empleado) = empleado.costoHoraTrabajo * this.horasNecesarias()
    fun salarioResponsable() = responsable.costoHoraTrabajo * horasEstimadas
    fun salarioTotalEmpleados() = empleados.sumBy { salarioEmpleado(it) }
    override fun costoTarea() = costoInfraestructura + this.salarioTotalEmpleados() + this.salarioResponsable()

    override fun nominaEmpleados(): List<Empleado> = empleados + responsable
}

class TareaIntegracion(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    var listaTareas = mutableListOf<TipoTarea>()

    fun totalHorasSubtareas() = listaTareas.sumBy { it.horasNecesarias() }
    fun horasReuniones() =  this.totalHorasSubtareas() / 8
    override fun horasNecesarias() = this.totalHorasSubtareas() + this.horasReuniones() //horasNecesarias

    fun totalCostoSubtareas() = listaTareas.sumBy { it.costoTarea() }
    fun porcentajeResponsable() = this.totalCostoSubtareas() * 0.03
    override fun costoTarea() = (this.totalCostoSubtareas() + this.porcentajeResponsable()).toInt() //costo

    override fun nominaEmpleados(): List<Empleado> = listaTareas.flatMap{ it.nominaEmpleados() } + responsable // nominaEmpleados

}