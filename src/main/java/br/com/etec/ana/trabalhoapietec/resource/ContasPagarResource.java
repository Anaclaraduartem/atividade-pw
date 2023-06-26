package br.com.etec.ana.trabalhoapietec.resource;


import br.com.etec.ana.trabalhoapietec.model.ContasPagar;
import br.com.etec.ana.trabalhoapietec.projections.ResumoContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.ContasPagarRepository;
import br.com.etec.ana.trabalhoapietec.repository.filter.ContasFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contaspagar")

public class ContasPagarResource {


    @Autowired
    private ContasPagarRepository  contasPagarRepository;


     @GetMapping("/todos")
    public List<ContasPagar> listarTodasContasPagar(){
         return contasPagarRepository.findAll();
     }
@GetMapping()
    public Page<ResumoContasPagar> pesquisar(ContasFilter contasFilter, Pageable pageable){
         return contasPagarRepository.filtrar(contasFilter, pageable);
}
}
