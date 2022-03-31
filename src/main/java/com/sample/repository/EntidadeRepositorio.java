package com.sample.repository;

import com.sample.entity.Entidade;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EntidadeRepositorio implements PanacheRepository<Entidade> {
    
    public Entidade findById(Long id) {
        return find("id", id).firstResult();
    }
}
