package domain;

import java.util.ArrayList;

public class CustomerModel {
    private Long id;
    private String name;
    private ArrayList<CustomerModel> links = new ArrayList<>();

    public CustomerModel(Long id) {
        this.id = id;
    }

    public CustomerModel name(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerModel customerModel = (CustomerModel) o;

        return id.equals(customerModel.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getName() {
        return name;
    }

    public ArrayList<CustomerModel> getLinks() {
        return links;
    }
}
