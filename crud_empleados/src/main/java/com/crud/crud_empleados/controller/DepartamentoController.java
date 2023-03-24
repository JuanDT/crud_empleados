package com.crud.crud_empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.crud_empleados.entities.Departamento;
import com.crud.crud_empleados.service.DepartamentoService;

@Controller
@RequestMapping("/")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/departamento")
    public String listarDepartamentos(Model modelo) {
        modelo.addAttribute("departamentosLista", departamentoService.listarDepartamentos());
        return "departamentos"; // nos retorna al archivo departamentos.html
    }

    @GetMapping("/departamento/nuevo")
    public String mostrarFormularioDeRegistrarDepartamento(Model modelo) {
        Departamento departamento = new Departamento();
        modelo.addAttribute("departamento", departamento);
        return "crear_departamento";
    }

    @PostMapping("/departamento")
    public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {
        departamentoService.guardarDepartamento(departamento);
        return "redirect:/departamento";
    }

    @GetMapping("/departamento/editarDepartamento/{codigo}")
    public String mostrarFormularioDeEditar(@PathVariable Long codigo, Model modelo) {
        modelo.addAttribute("departamento", departamentoService.buscarDepartamentoPorCodigo(codigo));
        return "editar_departamento";
    }

    @PostMapping("/departamento/actualizarDepartamentos/{codigo}")
    public String actualizarDepartamento(@PathVariable Long codigo, @ModelAttribute("departamento") Departamento departamento,
                                       Model modelo) {
        Departamento departamentoExistente = departamentoService.buscarDepartamentoPorCodigo(codigo);
        departamentoExistente.setNombre(departamento.getNombre());
        departamentoExistente.setPresupuesto(departamento.getPresupuesto());
        departamentoExistente.setGastos(departamento.getGastos());

        departamentoService.actualizarDepartamento(departamentoExistente);
        return "redirect:/departamento";
    }

    @GetMapping("/eliminarDepartamento/{codigo}")
    public String eliminarDepartamento(@PathVariable Long codigo) {
        Departamento departamento = departamentoService.buscarDepartamentoPorCodigo(codigo);
        if (departamento.getEmpleados().isEmpty()) {
            departamentoService.eliminarDepartamento(codigo);
            return "redirect:/departamento";
        } else {
            // Mostrar un mensaje de error o redirigir a una página de error
            return "redirect:/departamento?error=El departamento tiene empleados asociados y no puede ser eliminado";
        }        
    }
}

