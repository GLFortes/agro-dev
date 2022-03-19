package com.example.agro.repositories;

import com.example.agro.models.Fazenda;
import com.example.agro.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Iterable<Funcionario> findByEmpresa(Long id);
}
