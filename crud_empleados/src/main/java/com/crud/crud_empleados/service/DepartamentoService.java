package com.crud.crud_empleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.crud_empleados.entities.Departamento;

@Service
public interface DepartamentoService {

    List<Departamento> listarDepartamentos();

    Departamento guardarDepartamento(Departamento departamento);

    Departamento actualizarDepartamento(Departamento departamento2);

    void eliminarDepartamento(Long codigo);

    Departamento buscarDepartamentoPorCodigo(Long codigo);

}




