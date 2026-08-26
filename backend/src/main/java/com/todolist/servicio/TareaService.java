package com.todolist.servicio;

import com.todolist.modelo.Tarea;
import com.todolist.repositorio.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    // Inyectamos el repositorio
    public TareaService(TareaRepository repository) {
        this.tareaRepository = repository;
    }

    //Buscar todas las tareas
    public List<Tarea> listarTodas(){
        return tareaRepository.findAll();
    }

    //
    public Tarea guardar(Tarea nuevaTarea) {
        nuevaTarea.setCompletada(false);//la creo como pendiente por defecto
        return tareaRepository.save(nuevaTarea);
    }

    public void eliminar(Long id){
        tareaRepository.deleteById(id);
    }
}