package br.com.etec.ana.trabalhoapietec.repository;

import br.com.etec.ana.trabalhoapietec.model.ContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.Contas.ContasPagarRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasPagarRepository  extends JpaRepository<ContasPagar, Integer> , ContasPagarRepositoryQuery {

}
