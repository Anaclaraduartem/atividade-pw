package br.com.etec.ana.trabalhoapietec.repository.Contas;

import br.com.etec.ana.trabalhoapietec.model.ContasPagar;
import br.com.etec.ana.trabalhoapietec.projections.ResumoContasPagar;
import br.com.etec.ana.trabalhoapietec.repository.filter.ContasFilter;
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

public class ContasRepositoryImpl implements ContasRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ResumoContasPagar> filtrar(ContasFilter contasFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoContasPagar> criteria = builder.createQuery(ResumoContasPagar.class);
        Root<ContasPagar> root = criteria.from(ContasPagar.class);

        criteria.select(builder.construct(ResumoContasPagar.class
                , root.get("id")
                , root.get("data")
                , root.get("datavencimento")
                , root.get("valor")
                , root.get("cliente").get("nome")


        ));
        Predicate[] predicates = criarRestricoes(contasFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        TypedQuery<ResumoContasPagar> query = manager.createQuery(criteria);
        adicionarRestricoesdePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(contasFilter));
    }

    private Long total(ContasFilter contasFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContasPagar> root = criteria.from(ContasPagar.class);

        Predicate[] predicates = criarRestricoes(contasFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesdePaginacao(TypedQuery<ResumoContasPagar> query, Pageable pageable) {
        int pageAtual = pageable.getPageNumber();
        int totalRegistroPage = pageable.getPageSize();
        int primeiroRegistroPage = pageAtual * totalRegistroPage;


        query.setFirstResult(primeiroRegistroPage);
        query.setMaxResults(totalRegistroPage);

    }

    private Predicate[] criarRestricoes(ContasFilter contasFilter, CriteriaBuilder builder, Root<ContasPagar> root) {
        List<Predicate> predicates = new ArrayList<>();


        if (contasFilter.getData() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("data"),
                    contasFilter.getData()));
        }
        if (contasFilter.getDatavencimento() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("datavencimento"),
                    contasFilter.getDatavencimento()));
        }
         if (!StringUtils.isEmpty(contasFilter.getNome())){
             predicates.add(builder.like(builder.lower(root.get("cliente").get("nome")),
                    "%" + contasFilter.getNome().toLowerCase() + "%"));
         }
        return predicates.toArray((new Predicate[predicates.size()]));
    }
}