// src/main/java/br/com/controledegastos/repository/LancamentoRepository.java
package br.com.controledegastos.repository;

import br.com.controledegastos.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}