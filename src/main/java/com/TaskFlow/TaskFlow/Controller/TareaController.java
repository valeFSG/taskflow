package com.TaskFlow.TaskFlow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.TaskFlow.TaskFlow.Model.Tarea;
import com.TaskFlow.TaskFlow.Service.TareaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService service;

    @GetMapping
    public ResponseEntity<List<Tarea>> getAll(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        Optional<Tarea> tarea = service.buscarPorId(id);

        if (tarea.isPresent())
            return ResponseEntity.ok(tarea.get());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarea no encontrada");
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Tarea tarea, BindingResult result){

        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        if (service.guardar(tarea))
            return new ResponseEntity<>("Tarea creada correctamente", HttpStatus.CREATED);

        return new ResponseEntity<>("Error: datos invalidos o tarea duplicada", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                   @Valid @RequestBody Tarea tarea,
                                   BindingResult result){

        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        tarea.setId(id);

        if (service.actualizar(tarea))
            return ResponseEntity.ok("Tarea actualizada correctamente");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarea no encontrada o fecha invalida");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

    if (service.eliminar(id))
        return ResponseEntity.noContent().build();

    return ResponseEntity.notFound().build();
}

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Tarea>> getByEstado(@PathVariable String estado){
        return ResponseEntity.ok(service.buscarPorEstado(estado));
    }

    @PutMapping("/completar/{id}")
    public ResponseEntity<String> completar(@PathVariable Long id){

        if (service.completarTarea(id))
            return ResponseEntity.ok("Tarea completada correctamente");

        return ResponseEntity.badRequest().body("No se pudo completar la tarea");
    }
}