package br.com.etec.ana.trabalhoapietec.repository.Cliente;

import br.com.etec.ana.trabalhoapietec.model.Cliente;
import br.com.etec.ana.trabalhoapietec.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
