package com.todolist.repositorio;

import com.todolist.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Hereda los métodos automáticos para guardar, borrar y buscar
}
