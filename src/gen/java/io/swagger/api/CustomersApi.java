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
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the customers API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T08:46:32.976Z")
public class CustomersApi {
    private final CustomersApiService delegate = CustomersApiServiceFactory.getCustomersApi();

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new customer", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "default", response = Customer.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Customer.class)})
    public Response addCustomer(@ApiParam(value = "customer to add", required = true) NewCustomer customer
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.addCustomer(customer, securityContext);
    }

    @POST
    @Path("/{customerId}/links")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new link", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "system response", response = Customer.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Customer.class)})
    public Response addLink(@ApiParam(value = "ID of customer", required = true) @PathParam("customerId") Long customerId
            , @ApiParam(value = "customer ID for linking", required = true) NewLink linkId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.addLink(customerId, linkId, securityContext);
    }

    @DELETE
    @Path("/{customerId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "deletes a single customer by id", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "customer deleted", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteCustomer(@ApiParam(value = "ID of customer to delete", required = true) @PathParam("customerId") Long customerId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteCustomer(customerId, securityContext);
    }

    @DELETE
    @Path("/{customerId}/links/{linkId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes link", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "link deleted", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
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
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a customer by id", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "default", response = Customer.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Customer.class)})
    public Response findCustomer(@ApiParam(value = "ID of customer to fetch", required = true) @PathParam("customerId") Long customerId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.findCustomer(customerId, securityContext);
    }

    @GET

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns all customers", response = Customer.class, responseContainer = "List", tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "default", response = Customer.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Customer.class, responseContainer = "List")})
    public Response findCustomers(@Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.findCustomers(securityContext);
    }

    @GET
    @Path("/{customerId}/links")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns links to other customers", response = Customer.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "system response", response = Customer.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Customer.class)})
    public Response getLinks(@ApiParam(value = "ID of customer to fetch links", required = true) @PathParam("customerId") Long customerId
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getLinks(customerId, securityContext);
    }

    @PUT
    @Path("/{customerId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "updates a single customer", response = void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "customer updated", response = void.class),

            @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateCustomer(@ApiParam(value = "ID of customer for update", required = true) @PathParam("customerId") Long customerId
            , @ApiParam(value = "updated customer", required = true) NewCustomer updatedCustomer
            , @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateCustomer(customerId, updatedCustomer, securityContext);
    }
}
