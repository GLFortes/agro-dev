package com.example.agro.repositories;

import com.example.agro.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    //localizar por ID de empresa
    @Query(value = "SELECT f FROM Funcionario f WHERE f.empresa.id = ?1")
    Iterable<Funcionario> findByEmpresa(Long id);

    //contar por ID de empresa
    @Query(value = "SELECT COUNT(f) FROM Funcionario f WHERE f.empresa.id = ?1")
    int countByEmpresa(Long id);
}
