package br.com.etec.ana.trabalhoapietec.repository.Contas;

import br.com.etec.ana.trabalhoapietec.projections.ResumoContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.filter.ContasFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasRepositoryQuery {

    public Page<ResumoContasPagar> filtrar(ContasFilter contasFilter, Pageable pageable);
}
