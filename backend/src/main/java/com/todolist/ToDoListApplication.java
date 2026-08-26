package com.todolist;

import com.todolist.modelo.Tarea;
import com.todolist.servicio.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
    }

    // Este bloque guarda las tareas automáticas usando tu servicio
    @Bean
    CommandLineRunner initDatabase(TareaService service) {
        return args -> {
            Tarea t1 = new Tarea();
            t1.setTitulo("Aprender a diseñar con clases de Tailwind");
            t1.setPrioridad("Alta");
            t1.setCategoria("Estudios");

            Tarea t2 = new Tarea();
            t2.setTitulo("Configurar los servicios HTTP en Angular");
            t2.setPrioridad("Media");
            t2.setCategoria("Trabajo");

            service.guardar(t1);
            service.guardar(t2);

            System.out.println(">> ¡Servidor vivo y tareas de prueba insertadas con éxito! <<");
        };
    }
}