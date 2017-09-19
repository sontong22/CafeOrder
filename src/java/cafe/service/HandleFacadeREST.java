
package cafe.service;

import cafe.Handle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("handle")
public class HandleFacadeREST extends AbstractFacade<Handle> {

    @PersistenceContext(unitName = "RESTCafePU")
    private EntityManager em;

    public HandleFacadeREST() {
        super(Handle.class);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Handle find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Produces({"application/json"})
    public List<Handle> findAll(@QueryParam("ordernumber") String ordernumber) {
        return em.createNamedQuery("Handle.findByOrdernumber", Handle.class).setParameter("ordernumber", new Integer(ordernumber)).getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
