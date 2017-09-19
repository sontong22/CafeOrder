
package cafe.service;

import cafe.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("item")
public class ItemFacadeREST extends AbstractFacade<Item> {

    @PersistenceContext(unitName = "RESTCafePU")
    private EntityManager em;

    public ItemFacadeREST() {
        super(Item.class);
    }

    @POST
    @Consumes({"application/json"})
    public String createItem(Item entity) {
        super.create(entity);
        em.flush();
        return entity.getIditem().toString();
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }    
    
    @GET
    @Produces({"application/json"})
    public List<Item> findItem(@QueryParam("ordernumber") String idorder) {
        return em.createNamedQuery("Item.findByOrdernumber", Item.class).setParameter("ordernumber", new Integer(idorder)).getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
