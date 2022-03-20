package com.example.agro.repositories;

import com.example.agro.models.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {
    //Localizar grao por empresa
    Iterable<Grao> findByEmpresaId(Long id);

}
