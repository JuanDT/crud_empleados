package com.crud.crud_empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crud.crud_empleados.entities.Empleado;
import com.crud.crud_empleados.service.DepartamentoService;
import com.crud.crud_empleados.service.EmpleadoService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private DepartamentoService departamentoService;
     
    @GetMapping({ "/",""}) 
    public String listarEmpleados(Model model) {      
        model.addAttribute("empleadosLista", empleadoService.listarEmpleados());   
        return "empleados";
    }

    
    @GetMapping("/empleado")
    public String mostrarFormularioAgregar(Model model) {
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        return "crear_empleado";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEditar(@PathVariable("codigo") long codigo, Model model) {
        Empleado empleado = empleadoService.buscarEmpleadoPorCodigo(codigo);
        model.addAttribute("empleado", empleado);
        model.addAttribute("departamentos", departamentoService.listarDepartamentos());
        return "editar_empleado";
    }

    @PostMapping("/modificar/{codigo}")
    public String editarEmpleado(@PathVariable("codigo") long codigo, @ModelAttribute("empleado") Empleado empleado) {
        Empleado esmpladoExistente = empleadoService.buscarEmpleadoPorCodigo(codigo);
        esmpladoExistente.setCodigo(codigo);;
        esmpladoExistente.setNombre(empleado.getNombre());
        esmpladoExistente.setApellido1(empleado.getApellido1());
        esmpladoExistente.setApellido2(empleado.getApellido2());
        esmpladoExistente.setEmail(empleado.getEmail());

        empleadoService.actualizarEmpleado(empleado);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarEmpleado(@PathVariable("codigo") long codigo) {
        empleadoService.eliminarEmpleado(codigo);
        return "redirect:/";
    }
}


