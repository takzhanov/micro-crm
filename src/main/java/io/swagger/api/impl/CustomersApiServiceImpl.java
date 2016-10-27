package io.swagger.api.impl;

import domain.CustomerModel;
import domain.CustomerService;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.CustomersApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.NewCustomer;
import io.swagger.model.NewLink;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-27T20:43:44.258Z")
public class CustomersApiServiceImpl extends CustomersApiService {
    private static CustomerService customerService = new CustomerService();

    @Override
    public Response addCustomer(NewCustomer customer, SecurityContext securityContext) throws NotFoundException {
        CustomerModel newCustomer = customerService.add(customer.getName());
        return Response.ok().entity(new ApiResponseMessage(newCustomer)).build();
    }
    @Override
    public Response addLink(Long customerId, NewLink linkId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        CustomerModel linkModel = customerService.find(linkId.getId());
        if (model != null && linkModel != null) {
            model.getLinks().add(linkModel);
//            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
            return Response.created(URI.create("/customers/" + customerId + "/links/" + linkId.getId())).build();
        } else {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.INFO, "Customers are not found")).build();

        }
    }
    @Override
    public Response deleteCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.delete(customerId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK,
                model != null ? "Deleted" : "Not exist")).build();
    }
    @Override
    public Response deleteLink(Long customerId, Long linkId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null && linkId != null) {
            boolean flag = model.getLinks().removeIf(customerModel -> linkId.equals(customerModel.getId()));
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK,
                    flag ? "Deleted" : "Not found")).build();
        } else {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not found")).build();
        }
    }
    @Override
    public Response findCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        ApiResponseMessage resp = new ApiResponseMessage(model);
        if (model != null) {
            resp.setMessage("Found");
        } else {
            resp.setMessage("Not Found");
        }
        return Response.ok().entity(resp).build();
    }
    @Override
    public Response findCustomers(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(new ApiResponseMessage(customerService.find())).build();
    }
    @Override
    public Response getLinks(Long customerId, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null) {
            return Response.ok().entity(new ApiResponseMessage(model.getLinks())).build();
        } else {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not found")).build();
        }
    }
    @Override
    public Response updateCustomer(Long customerId, NewCustomer updatedCustomer, SecurityContext securityContext) throws NotFoundException {
        CustomerModel model = customerService.find(customerId);
        if (model != null) {
            model.name(updatedCustomer.getName());
            return Response.ok().entity(new ApiResponseMessage(model)).build();
        } else {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Not exist!")).build();
        }
    }
}
