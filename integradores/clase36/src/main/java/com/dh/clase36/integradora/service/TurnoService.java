package com.dh.clase36.integradora.service;

import com.dh.clase36.integradora.entities.Turno;
import com.dh.clase36.integradora.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    TurnoRepository repository;

    public Turno guardar(Turno turno){
        return repository.save(turno);
    }

    public List<Turno> listarTurnos(){
        return repository.findAll();
    }

    public void eliminar(Long id){
        Optional<Turno> turnoBuscado= buscar(id);
        if (turnoBuscado.isPresent())
            repository.deleteById(id);
    }

    public Optional<Turno> buscar(Long id){
        return repository.findById(id);
    }

    public Turno actualizar(Turno turno) {
        if(buscar(turno.getId()).isPresent())
            return repository.save(turno);
        else
            return null;
    }


}
