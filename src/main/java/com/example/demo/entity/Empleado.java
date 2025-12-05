// ProyectoController.java
package com.example.demo.entity;

import com.example.demo.dto.EmpleadoAsignadoDTO;
import com.example.demo.dto.ProyectoEmpleadoDTO;
import com.example.demo.dto.RegistrarProyectoInput;
import com.example.demo.entity.*;
import com.example.demo.service.ProyectoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // QUERIES

    @QueryMapping
    public List<ProyectoEmpleadoDTO> proyectosPorEmpleado(@Argument String cedula) {
        return proyectoService.obtenerProyectosPorEmpleado(cedula);
    }

    @QueryMapping
    public Proyecto obtenerProyecto(@Argument Long id) {
        return proyectoService.obtenerProyecto(id);
    }

    @QueryMapping
    public Empleado obtenerEmpleado(@Argument String cedula) {
        return proyectoService.obtenerEmpleado(cedula);
    }

    @QueryMapping
    public List<Proyecto> listarProyectos() {
        return proyectoService.listarProyectos();
    }

    @QueryMapping
    public List<Empleado> listarEmpleados() {
        return proyectoService.listarEmpleados();
    }

    // MUTATIONS

    @MutationMapping
    public Proyecto registrarProyecto(@Argument RegistrarProyectoInput input) {
        return proyectoService.registrarProyecto(input);
    }

    @MutationMapping
    public AsignacionProyecto asignarEmpleadoAProyecto(
            @Argument Long proyectoId,
            @Argument String cedula,
            @Argument String rol) {
        return proyectoService.asignarEmpleadoAProyecto(proyectoId, cedula, rol);
    }

    @MutationMapping
    public Proyecto actualizarEstadoProyecto(
            @Argument Long id,
            @Argument EstadoProyecto estado) {
        return proyectoService.actualizarEstadoProyecto(id, estado);
    }

    // FIELD RESOLVERS

    @SchemaMapping(typeName = "Proyecto", field = "empleadosAsignados")
    public List<EmpleadoAsignadoDTO> empleadosAsignados(Proyecto proyecto) {
        return proyectoService.obtenerEmpleadosDeProyecto(proyecto.getId());
    }

    @SchemaMapping(typeName = "Empleado", field = "proyectosAsignados")
    public List<ProyectoEmpleadoDTO> proyectosAsignados(Empleado empleado) {
        return proyectoService.obtenerProyectosPorEmpleado(empleado.getCedula());
    }
}