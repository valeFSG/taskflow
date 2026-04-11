package com.TaskFlow.TaskFlow.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskFlow.TaskFlow.Model.Tarea;
import com.TaskFlow.TaskFlow.Repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository repository;

    public List<Tarea> listarTodos(){
        return repository.findAll();
    }
    public Optional<Tarea> buscarPorId(Long id){
        return repository.findById(id);
    }

    public boolean guardar(Tarea nuevo){
        if (nuevo.getTitulo() == null || nuevo.getTitulo().isBlank())
            return false;
        if (nuevo.getFechaLimite() == null)
            return false;
        boolean existe = repository.findAll().stream().anyMatch(t -> t.getId().equals(nuevo.getId()));

        if (existe)
            return false;
        nuevo.setFechaCreacion(LocalDate.now());

        repository.save(nuevo);
        return true;
    }

    public boolean actualizar(Tarea tarea){
        Optional<Tarea> existente = repository.findById(tarea.getId());
        if (existente.isEmpty())
            return false;

        repository.update(tarea);
        return true;
    }

    public boolean eliminar(Long id){
        return repository.delete(id);
    }

    public List<Tarea> buscarPorEstado(String estado){
        return repository.findAll().stream().filter(t -> t.getEstado().name().equalsIgnoreCase(estado)).collect(Collectors.toList());
    }
}
