package ar.edu.unahur.obj2.tareas

import kotlin.properties.Delegates

interface TipoTarea{
    fun horasNecesarias(): Int
    fun costoTarea(): Int
    fun salarioTotalEmpleados() : Int
}

class TareaSimple(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    val costoInfraestructura by Delegates.notNull<Int>()
    var empleados = mutableListOf<Empleado>()

    override fun horasNecesarias() = horasEstimadas / empleados.size
    fun salarioEmpleado(empleado: Empleado) = empleado.costoHoraTrabajo * this.horasNecesarias()
    fun salarioResponsable() = responsable.costoHoraTrabajo * horasEstimadas
    override fun salarioTotalEmpleados() = empleados.sumBy { salarioEmpleado(it) }
    override fun costoTarea() = costoInfraestructura + this.salarioTotalEmpleados() + this.salarioResponsable()
}

class TareaIntegracion(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    var listaTareas = mutableListOf<TipoTarea>()

    fun totalHorasSubtareas() = listaTareas.sumBy { it.horasNecesarias() }
    fun horasReuniones() =  this.totalHorasSubtareas() / 8
    override fun horasNecesarias() = this.totalHorasSubtareas() + this.horasReuniones()
    fun totalCostoSubtareas() = listaTareas.sumBy { it.costoTarea() }
    fun porcentajeResponsable() = this.totalCostoSubtareas() * 0.03
    override fun costoTarea() = (this.totalCostoSubtareas() + this.porcentajeResponsable()).toInt()

    override fun salarioTotalEmpleados() = listaTareas.sumBy { it.salarioTotalEmpleados() } // nominaEmpleados
    //Para la nómina de empleados, se debe incluir a las nóminas de las subtareas más al responsable de la tarea de integración.
    //la suma de los registros financieros de los sueldos de los empleados
}