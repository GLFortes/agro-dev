package com.example.agro.repositories;

import com.example.agro.models.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {
    //Localizar grao por ID de empresa
    Iterable<Grao> findByEmpresaId(Long id);



    //Ordenar Grãos por ordem alfabética
    List<Grao> findByEmpresaIdOrderByNomeAsc(Long id);
}
