package com.example.agro.repositories;

import com.example.agro.models.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    //localizar fazenda por ID de empresa
    @Query("select f from Fazenda f where f.empresa.id = ?1")
    Iterable<Fazenda> findByEmpresaId(Long id);

    //Contar fazenda por ID de empresa
    @Query("select count(f) from Fazenda f where f.empresa.id = ?1")
    int countByEmpresaId(Long id);

    @Query("select f from Fazenda f where f.empresa.id = ?1 order by f.quilos desc")
    List<Fazenda> findByEmpresaIdOrderByQuilosDesc(Long id);
}
