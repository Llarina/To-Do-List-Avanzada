package com.todolist.controlador;

import com.todolist.modelo.Tarea;
import com.todolist.servicio.TareaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "http://localhost:4200") // Permite la comunicación con Angular
public class TareaController {

    private final TareaService service;

    // Inyectamos el Servicio
    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarea> mostrarTareas(){
        return service.listarTodas();
    }

    @PostMapping
    public Tarea crearTarea (@RequestBody Tarea nuevaTarea){
        return service.guardar(nuevaTarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id){
        service.eliminar(id);
    }
}
