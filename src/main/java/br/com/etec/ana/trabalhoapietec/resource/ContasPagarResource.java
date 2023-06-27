package br.com.etec.ana.trabalhoapietec.resource;

import br.com.etec.ana.trabalhoapietec.model.ContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.ContasPagarRepository;
import br.com.etec.ana.trabalhoapietec.repository.filter.ContasPagarFilter;
import br.com.etec.ana.trabalhoapietec.repository.projections.ResumoContasPagar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contaspagar")
public class ContasPagarResource {

@Autowired
    private ContasPagarRepository contasPagarRepository;

    @GetMapping("/todos")
    public List<ContasPagar> listartodascontas(){
        return contasPagarRepository.findAll();
    }

    @GetMapping()
    public Page<ResumoContasPagar> pesquisar(ContasPagarFilter contasPagarFilter, Pageable pageable){
        return contasPagarRepository.filtrar(contasPagarFilter, pageable);
    }

}
