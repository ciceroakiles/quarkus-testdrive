package com.sample.controller;

import com.sample.entity.Entidade;
import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api/v1/entidade")
public class EntidadeController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entidade> entidades(@QueryParam("id") Long id) {
        if (id != null) {
            return Entidade.findById(id);
        } else {
            return Entidade.listAll();
        }
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criaEntidade(Entidade entidade) {
        entidade.id = null;
        entidade.persist();
        return Response.status(Status.CREATED).entity(entidade).build();
    }

}
