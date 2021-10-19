package ch.puzzle.ln.boundary;

import ch.puzzle.ln.entity.AliveNode;
import ch.puzzle.ln.entity.RektNode;
import io.netty.handler.codec.http.HttpResponseStatus;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.time.Instant;
import java.util.List;

@Path("/nodes")
public class NodeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rekt")
    public List<RektNode> list() {
        return RektNode.findAll().list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/rekt")
    public Response create(RektNode newNode) {
        List<RektNode> existing = RektNode.findByNodeId(newNode.getNodeId());

        if(!existing.isEmpty()) {
            return Response.status(HttpResponseStatus.CONFLICT.code()).build();
        }

        newNode.setRegistrationDate(Instant.now());
        if(newNode.getRektDate() == null) {
            newNode.setRektDate(newNode.getRegistrationDate());
        }
        newNode.persist();

        return Response.created(UriBuilder.fromResource(NodeResource.class).path("/rekt/"+newNode.id).build())
                .build();
    }

    @GET
    @Path("/alive")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AliveNode> listAlive() {
        return AliveNode.findAll().list();
    }

    @POST
    @Path("/alive")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createAlive(AliveNode newNode) {
        List<AliveNode> existing = AliveNode.findByNodeId(newNode.getNodeId());

        if(!existing.isEmpty()) {
            return Response.status(HttpResponseStatus.CONFLICT.code()).build();
        }

        newNode.setRegistrationDate(Instant.now());
        newNode.persist();

        return Response.created(UriBuilder.fromResource(NodeResource.class).path("/alive/"+newNode.id).build())
                .build();
    }
}