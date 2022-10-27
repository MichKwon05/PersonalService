package mx.edu.utez.personalservice.controller.personal;

import com.sun.research.ws.wadl.Param;
import mx.edu.utez.personalservice.model.BeanPersonal;
import mx.edu.utez.personalservice.model.DaoPersonal;
import mx.edu.utez.personalservice.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/personal")//acceso al recurso de la clase
public class PersonalService {

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanPersonal> getAll(){
        return new DaoPersonal().findAll();
    }

    @GET //MetodoHTTP ->obtener
    //"/api/personal/2
    @Path("/{id}") //La forma de identificar un recurso(Clase, Metodo
    @Produces(MediaType.APPLICATION_JSON)
    //Convierte la respuesta -> Json("{}")
    public Response<BeanPersonal> getById(@PathParam("id")Long id){
        return new DaoPersonal().findById(id);
    }

    @POST //Insercción
    @Path(("/"))
    @Consumes(MediaType.APPLICATION_JSON) //Consume Json
    @Produces(MediaType.APPLICATION_JSON) //Retorna Json

    public Response<BeanPersonal> save(BeanPersonal personal){
        return  new DaoPersonal().save(personal);
    }

}
