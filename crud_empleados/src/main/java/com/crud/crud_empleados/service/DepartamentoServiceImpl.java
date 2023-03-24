package com.crud.crud_empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud_empleados.entities.Departamento;
import com.crud.crud_empleados.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public void eliminarDepartamento(Long codigo) {
        departamentoRepository.deleteById(codigo);
    }

    @Override
    public Departamento buscarDepartamentoPorCodigo(Long codigo) {
        return departamentoRepository.findById(codigo).orElse(null);
    }

     
}



