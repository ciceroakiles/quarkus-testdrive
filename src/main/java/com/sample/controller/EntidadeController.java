package com.sample.controller;

import com.sample.entity.Entidade;
import com.sample.repository.EntidadeRepositorio;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/api/v1/entidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntidadeController {

    @Inject
    EntidadeRepositorio entidadeRepositorio;

    public EntidadeController(EntidadeRepositorio entidadeRepositorio) {
        this.entidadeRepositorio = entidadeRepositorio;
    }

    @POST
    @Transactional
    public Response criaEntidade(Entidade entidade) {
        //entidade.id = null; //entidade.persist();
        entidadeRepositorio.persist(entidade);
        return Response.status(Status.CREATED).entity(entidade).build();
    }

    @GET
    public List<Entidade> listAll() {
        return entidadeRepositorio.listAll();
    }

    @GET
    @Path("/{id}")
    public Entidade findById(@PathParam("id") Long id) {
        return entidadeRepositorio.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") Long id) {
        entidadeRepositorio.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void updateById(Entidade entidade, @PathParam("id") Long id) {
        Entidade temp = entidadeRepositorio.findById(id);
        if (temp != null) {
            temp.setNome(entidade.getNome());
            entidadeRepositorio.persist(temp);
        }
    }
}
