package com.TaskFlow.TaskFlow.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.TaskFlow.TaskFlow.Model.Estado;
import com.TaskFlow.TaskFlow.Model.Prioridad;
import com.TaskFlow.TaskFlow.Model.Tarea;

@Repository
public class TareaRepository {
    private List<Tarea> lista = new ArrayList<>();

    public TareaRepository(){
        lista.add(new Tarea(1L, "Preparar informe", "Informe mensual",Estado.PENDIENTE, Prioridad.ALTA, "Valentina",LocalDate.now(), LocalDate.of(2026, 4, 20)));

        lista.add(new Tarea(2L, "Revisar codigo", "Backend",Estado.EN_PROGRESO, Prioridad.MEDIA, "Nicol",LocalDate.now(), LocalDate.of(2026, 4, 18)));

        lista.add(new Tarea(3L, "Inventario", "Produccion",Estado.COMPLETADA, Prioridad.URGENTE, "Tomas",LocalDate.now(), LocalDate.of(2026, 4, 15)));
      
    }
    public List<Tarea> findAll() {
        return lista;
    }
    public Optional<Tarea> findById(Long id) {
        return lista.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public void save(Tarea tarea) {
        lista.add(tarea);
    }

    public boolean delete(Long id) {

    Optional<Tarea> tareaOpt = lista.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst();

    if (tareaOpt.isPresent()) {
        lista.remove(tareaOpt.get());
        return true;
    }

    return false;
    }
    public Tarea update(Tarea tarea) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(tarea.getId())) {
                lista.set(i, tarea);
                return tarea;
            }
        }
        return null;
    }

}
