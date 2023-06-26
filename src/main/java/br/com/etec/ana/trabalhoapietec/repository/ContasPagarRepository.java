package br.com.etec.ana.trabalhoapietec.repository;


import br.com.etec.ana.trabalhoapietec.model.ContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.Contas.ContasRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarRepository extends JpaRepository <ContasPagar,Integer>, ContasRepositoryQuery {
}
