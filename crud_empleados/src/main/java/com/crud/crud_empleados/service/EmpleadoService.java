package com.crud.crud_empleados.service;

import java.util.List;

import com.crud.crud_empleados.entities.Empleado;

public interface EmpleadoService {

    List<Empleado> listarEmpleados();

    Empleado guardarEmpleado(Empleado empleado);

    Empleado actualizarEmpleado(Empleado empleado);

    void eliminarEmpleado(long codigo);

    Empleado buscarEmpleadoPorCodigo(long codigo);

    //List<Empleado> buscarEmpleadosPorDepartamento(Long codigoDepartamento);

}



     


