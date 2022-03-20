package com.example.agro.repositories;

import com.example.agro.models.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {
    //Localizar grao por empresa
    Iterable<Grao> findByEmpresaId(Long id);

    //ordenar por quantidade de grãos
    @Query(value = "SELECT grao_nome, fazenda_quantidade FROM grao INNER JOIN fazenda ON grao.fazenda_id = fazenda.id WHERE fazenda.empresa_id = ?1 ORDER BY fazenda_quantidade DESC", nativeQuery = true)
    List<Object[]> findByEmpresaIdOrderByFazendaQuantidade(Long id);
    List<Grao> findByEmpresaIdOrderByNomeAsc(Long id);
}
