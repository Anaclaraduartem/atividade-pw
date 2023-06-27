package br.com.etec.ana.trabalhoapietec.repository.Contas;

import br.com.etec.ana.trabalhoapietec.model.ContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.filter.ContasPagarFilter;
import br.com.etec.ana.trabalhoapietec.repository.projections.ResumoContasPagar;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContasPagarRepositoryImpl implements ContasPagarRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ResumoContasPagar> filtrar(ContasPagarFilter contasFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoContasPagar> criteria = builder.createQuery(ResumoContasPagar.class);
        Root<ContasPagar> root = criteria.from(ContasPagar.class);

        criteria.select(builder.construct(ResumoContasPagar.class,
                root.get("id"),
                root.get("data"),
                root.get("datavencimento"),
                root.get("valor"),
                root.get("cliente").get("nomecliente")));

        Predicate[] predicates = criarrestricoes(contasFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        TypedQuery<ResumoContasPagar> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contasFilter));
    }

    private Long total(ContasPagarFilter contasPagarFilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasPagar> root = criteria.from(ContasPagar.class);

        Predicate[] predicates = criarrestricoes(contasPagarFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPágina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPágina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Predicate[] criarrestricoes(ContasPagarFilter contasPagarFilter, CriteriaBuilder builder, Root<ContasPagar> root){
        List<Predicate> predicates = new ArrayList<>();

        if(contasPagarFilter.getData() != null){

            predicates.add(builder.greaterThanOrEqualTo(root.get("data"),
                    contasPagarFilter.getData()));

        }
        if(contasPagarFilter.getData() != null){

            predicates.add(builder.lessThanOrEqualTo(root.get("data"),
                    contasPagarFilter.getData()));

        }

        if(contasPagarFilter.getData() != null){

            predicates.add(builder.greaterThanOrEqualTo(root.get("datavencimento"),
                    contasPagarFilter.getDatavencimento()));

        }
        if(contasPagarFilter.getData() != null) {

            predicates.add(builder.lessThanOrEqualTo(root.get("datavencimento"),
                    contasPagarFilter.getDatavencimento()));
        }
        if (contasPagarFilter.getValor() != null){
            predicates.add(builder.equal(root.get("valor"),
                    contasPagarFilter.getValor()));
        }
        if (!StringUtils.isEmpty(contasPagarFilter.getNomecliente())){
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomecliente")),
                    "%" + contasPagarFilter.getNomecliente() + "%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }


}