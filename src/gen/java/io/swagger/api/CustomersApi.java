package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.CustomersApiServiceFactory;
import io.swagger.model.Customer;
import io.swagger.model.NewCustomer;
import io.swagger.model.NewLink;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/customers")


@io.swagger.annotations.Api(description = "the customers API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-27T23:29:24.415Z")
public class CustomersApi {
 private final CustomersApiService delegate = CustomersApiServiceFactory.getCustomersApi();

 @POST

 @Consumes({"application/json"})
 @Produces({"application/json"})
 @io.swagger.annotations.ApiOperation(value = "Создать нового клиента", notes = "Creates a new customer", response = Customer.class, tags = {})
 @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 200, message = "created Customer", response = Customer.class)})
 public Response addCustomer(@ApiParam(value = "customer to add", required = true) NewCustomer body
         , @Context SecurityContext securityContext)
         throws NotFoundException {
  return delegate.addCustomer(body, securityContext);
    }
    @POST
    @Path("/{customerId}/links")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Создать новую связь клиентов", notes = "Creates a new link", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "new linked Customer", response = Customer.class)})
    public Response addLink(@ApiParam(value = "ID of customer", required = true) @PathParam("customerId") Long customerId
            , @ApiParam(value = "customer ID for linking", required = true) NewLink body
            , @Context SecurityContext securityContext)
            throws NotFoundException {
     return delegate.addLink(customerId, body, securityContext);
    }
    @DELETE
    @Path("/{customerId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Удалить клиента", notes = "deletes a single customer by id", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "customer deleted", response = void.class)})
    public Response deleteCustomer(@ApiParam(value = "ID of customer to delete", required = true) @PathParam("customerId") Long customerId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
     return delegate.deleteCustomer(customerId, securityContext);
    }
    @DELETE
    @Path("/{customerId}/links/{linkId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Удалить связь клиентов", notes = "Deletes link", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "link deleted", response = void.class)})
    public Response deleteLink(@ApiParam(value = "ID of customer", required = true) @PathParam("customerId") Long customerId
            , @ApiParam(value = "ID of linked customer to delete", required = true) @PathParam("linkId") Long linkId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
     return delegate.deleteLink(customerId, linkId, securityContext);
    }
    @GET
    @Path("/{customerId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Получить информацию по клиенту", notes = "Returns a customer by id", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "requested Customer", response = Customer.class)})
    public Response findCustomer(@ApiParam(value = "ID of customer to fetch", required = true) @PathParam("customerId") Long customerId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
     return delegate.findCustomer(customerId, securityContext);
    }
    @GET

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Получить всех клиентов", notes = "Returns all customers", response = Customer.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "array of customers", response = Customer.class, responseContainer = "List")})
    public Response findCustomers(@Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.findCustomers(securityContext);
    }
    @GET
    @Path("/{customerId}/links")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Получить все связи клиента", notes = "Returns links to other customers", response = Customer.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "linked Customers", response = Customer.class, responseContainer = "List")})
    public Response getLinks(@ApiParam(value = "ID of customer to fetch links", required = true) @PathParam("customerId") Long customerId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
     return delegate.getLinks(customerId, securityContext);
    }
    @PUT
    @Path("/{customerId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Изменить имя клиента", notes = "updates a single customer", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "updated Customer", response = Customer.class)})
    public Response updateCustomer(@ApiParam(value = "ID of customer for update", required = true) @PathParam("customerId") Long customerId
            , @ApiParam(value = "updated customer", required = true) NewCustomer body
            , @Context SecurityContext securityContext)
            throws NotFoundException {
     return delegate.updateCustomer(customerId, body, securityContext);
    }
}
