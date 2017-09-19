
package cafe.service;

import cafe.Invoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Stateless
@Path("invoice")
public class InvoiceFacadeREST extends AbstractFacade<Invoice> {

    @PersistenceContext(unitName = "RESTCafePU")
    private EntityManager em;

    public InvoiceFacadeREST() {
        super(Invoice.class);
    }

   
    @POST
    @Consumes({"application/json"})
    public String createInvoice(Invoice entity) {
        super.create(entity);
        em.flush();
        return entity.getIdorder().toString();
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Invoice entity) {
        super.edit(entity);
    }
    
    @GET
    @Produces({"text/plain"})
    public String checkCustomerDetails(@QueryParam("idorder") String idorder) {
        Invoice o = null;
        try {
            o = em.createNamedQuery("Invoice.findByIdorder", Invoice.class).setParameter("idorder", idorder).getSingleResult();
        } catch (Exception ex) {
            return "";
        }
        return o.getCustomer()+ "," + o.getPhone();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
