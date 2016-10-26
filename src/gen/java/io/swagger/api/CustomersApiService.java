package io.swagger.api;

import io.swagger.model.NewCustomer;
import io.swagger.model.NewLink;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T08:46:32.976Z")
public abstract class CustomersApiService {
    public abstract Response addCustomer(NewCustomer customer, SecurityContext securityContext) throws NotFoundException;

    public abstract Response addLink(Long customerId, NewLink linkId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteLink(Long customerId, Long linkId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response findCustomer(Long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response findCustomers(SecurityContext securityContext) throws NotFoundException;

    public abstract Response getLinks(Long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateCustomer(Long customerId, NewCustomer updatedCustomer, SecurityContext securityContext) throws NotFoundException;
}
