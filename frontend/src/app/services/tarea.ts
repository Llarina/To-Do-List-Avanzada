import { Service } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Definimos la estructura de la Tarea en Angular (es el espejo de tu Entity de Java)
export interface Tarea {
  id?: number;
  titulo: string;
  completada: boolean;
  prioridad: string;
  categoria: string;
}

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  // La URL exacta de tu controlador de Spring Boot
  private apiUrl = 'http://localhost:8080/api/tareas';

  constructor(private http: HttpClient) {}

  // Petición GET para traer la lista de tareas del backend
  getTareas(): Observable<Tarea[]> {
    return this.http.get<Tarea[]>(this.apiUrl);
  }

  // Petición POST para guardar una tarea nueva
  crearTarea(tarea: Tarea): Observable<Tarea> {
    return this.http.post<Tarea>(this.apiUrl, tarea);
  }

  // Petición DELETE para borrar una tarea por su ID
  eliminarTarea(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}