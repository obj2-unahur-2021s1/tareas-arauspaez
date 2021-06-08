package ar.edu.unahur.obj2.tareas

import kotlin.properties.Delegates

interface TipoTarea{
    fun horasNecesarias(): Int
    fun costoTarea(): Int
    fun totalTeam(): List<Empleado> //Ex-NominaEmpleados
    //fun nominaEmpleados(): Int
}

class TareaSimple(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    var costoInfraestructura by Delegates.notNull<Int>()
    var empleados = mutableListOf<Empleado>()

    override fun horasNecesarias() = horasEstimadas / empleados.size
    fun salarioEmpleado(empleado: Empleado) = empleado.costoHoraTrabajo * this.horasNecesarias()
    fun salarioResponsable() = responsable.costoHoraTrabajo * horasEstimadas
    fun salarioTotalEmpleados() = empleados.sumBy { salarioEmpleado(it) }
    override fun costoTarea() = costoInfraestructura + this.salarioTotalEmpleados() + this.salarioResponsable()

    override fun totalTeam(): List<Empleado> = empleados + responsable //Ex-NominaEmpleados
        //Nomina: "suma de los registros financieros de los sueldos de los empleados" != totalTeam
    //override fun nominaEmpleados() = this.salarioTotalEmpleados() + this.salarioResponsable()
}

class TareaIntegracion(val horasEstimadas: Int, val responsable: Responsable): TipoTarea{
    var listaTareas = mutableListOf<TipoTarea>()

    fun totalHorasSubtareas() = listaTareas.sumBy { it.horasNecesarias() }
    fun horasReuniones() =  this.totalHorasSubtareas() / 8
    override fun horasNecesarias() = this.totalHorasSubtareas() + this.horasReuniones() //horasNecesarias

    fun totalCostoSubtareas() = listaTareas.sumBy { it.costoTarea() }
    fun porcentajeResponsable() = this.totalCostoSubtareas() * 0.03
    override fun costoTarea() = (this.totalCostoSubtareas() + this.porcentajeResponsable()).toInt() //costo

    override fun totalTeam(): List<Empleado> = listaTareas.flatMap{ it.totalTeam() } + responsable // EX-nominaEmpleados
    //override fun nominaEmpleados()
}