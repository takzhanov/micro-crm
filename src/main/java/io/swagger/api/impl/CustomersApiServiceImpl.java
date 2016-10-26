package io.swagger.api.impl;

import domain.CustomerModel;
import domain.CustomerService;
import io.swagger.api.CustomersApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.Customer;
import io.swagger.model.NewCustomer;
import io.swagger.model.NewLink;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T08:46:32.976Z")
public class CustomersApiServiceImpl extends CustomersApiService {
    static CustomerService customerService = new CustomerService();

    public CustomersApiServiceImpl() {
        System.out.println("Construct CustomersApiServiceImpl");
    }

    @Override
    public Response addCustomer(NewCustomer customer, SecurityContext securityContext) throws NotFoundException {
        Long newCustomerId = customerService.add(customer.getName());
        return Response.created(URI.create("/customers" + newCustomerId)).build();
    }

    @Override
    public Response addLink(Long customerId, NewLink linkId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        CustomerModel linkModel = customerService.find(linkId.getId());
        if (model != null && linkModel != null) {
            model.getLinks().add(linkModel);
            return Response.created(URI.create("/customers/" + customerId + "/links/" + linkId.getId())).build();
        } else {
            return Response.serverError().build();
        }
    }

    @Override
    public Response deleteCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.delete(customerId);
        return Response.status(204).build();
    }

    @Override
    public Response deleteLink(Long customerId, Long linkId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null && linkId != null) {
            model.getLinks().removeIf(customerModel -> linkId.equals(customerModel.getId()));
            return Response.status(204).build();
        } else {
            return Response.serverError().build();
        }
    }

    @Override
    public Response findCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null) {
            return Response.ok().entity(new Customer().id(model.getId()).name(model.getName())).build();
        } else {
            return Response.noContent().contentLocation(URI.create("/customers")).build();
        }
    }

    @Override
    public Response findCustomers(SecurityContext securityContext) throws NotFoundException {
        Object[] result = customerService.find().stream().map(m -> {
            return new Customer().id(m.getId()).name(m.getName());
        }).toArray();
        return Response.ok().entity(result).build();
    }

    @Override
    public Response getLinks(Long customerId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null) {
            return Response.ok().entity(model.getLinks().stream().map(m -> {
                return new Customer().id(m.getId()).name(m.getName());
            })).build();
        } else {
            return Response.noContent().build();
        }
    }

    @Override
    public Response updateCustomer(Long customerId, NewCustomer updatedCustomer, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null) {
            model.name(updatedCustomer.getName());
            return Response.status(204).entity(model).build();
        } else {
            return Response.noContent().build();
        }
    }
}
