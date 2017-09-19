
package cafe.service;

import cafe.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("product")
public class ProductFacadeREST extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "RESTCafePU")
    private EntityManager em;

    public ProductFacadeREST() {
        super(Product.class);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Product find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Product> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
