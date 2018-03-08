package sk.akademiasovy.tipos.server.resources;

import sk.akademiasovy.tipos.server.Ticket_count;
import sk.akademiasovy.tipos.server.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/draw/{id}")
public class Draws {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketCount(@PathParam("id")  int id){
            MySQL mySQL = new MySQL();
            System.out.println(id);
            Ticket_count ticketcount = mySQL.getTicketCount(id);
            if(ticketcount !=null){
                    String result="{\"bet1 \":"+ ticketcount.bet1+", ";
                    result+="\"bet2 \":"+ ticketcount.bet2+", ";
                    result+="\"bet3 \":"+ ticketcount.bet3+", ";
                    result+="\"bet4 \":"+ ticketcount.bet4+", ";
                    result+="\"bet5 \":"+ ticketcount.bet5+"} ";
                    return Response.ok(result).build();
        }
            return  Response.status(Response.Status.NOT_FOUND).build();
    }
}
