package com.crud.crud_empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crud_empleados.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}

