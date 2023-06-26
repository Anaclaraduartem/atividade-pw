package br.com.etec.ana.trabalhoapietec.repository;


import br.com.etec.ana.trabalhoapietec.model.Cliente;
import br.com.etec.ana.trabalhoapietec.repository.Cliente.ClienteRepositoryQuery;
import br.com.etec.ana.trabalhoapietec.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer>, ClienteRepositoryQuery {

}
