package io.swagger.api.impl;

import domain.CustomerService;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.CustomersApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.Customer;
import io.swagger.model.NewCustomer;
import io.swagger.model.NewLink;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T08:46:32.976Z")
public class CustomersApiServiceImpl extends CustomersApiService {
    static CustomerService customerService = new CustomerService();

    public CustomersApiServiceImpl() {
        System.out.println("Construct CustomersApiServiceImpl");
    }

    @Override
    public Response addCustomer(NewCustomer customer, SecurityContext securityContext) throws NotFoundException {
        customerService.addCustomer(customer.getName());
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response addLink(Long customerId, NewLink linkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response deleteCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response deleteLink(Long customerId, Long linkId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response findCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response findCustomers(SecurityContext securityContext) throws NotFoundException {
        Object[] result = customerService.findCustomers().stream().map(m -> {
            return new Customer().id(m.getId()).name(m.getName());
        }).toArray();
        return Response.ok().entity(result).build();
    }

    @Override
    public Response getLinks(Long customerId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response updateCustomer(Long customerId, NewCustomer updatedCustomer, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
