package br.com.etec.ana.trabalhoapietec.repository.Contas;

import br.com.etec.ana.trabalhoapietec.repository.projections.ResumoContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.filter.ContasPagarFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasPagarRepositoryQuery {

    public Page<ResumoContasPagar> filtrar(ContasPagarFilter contasFilter, Pageable pageable);
}
