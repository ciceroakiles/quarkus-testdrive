package com.sample.entity;

import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import javax.persistence.Id;

@Entity
public class Entidade extends PanacheEntity {
    /*
    // Pedaço de código anterior...
    //private Long id; (@Id) //public Long getId() { return id; } //public void setId(Long id) { this.id = id; }
    */

    public String nome;

    public static List<Entidade> findById(Long id) {
        return find("id", id).list();
    }

}
