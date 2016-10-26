package domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//должен быть Синглтон по смыслу, для эмуляции инстанцируется один раз в статическое поле АПИ сервиса
public class CustomerService {
    private long nextId = 0;
    private Map<Long, CustomerModel> storage = new HashMap<>();

    public void addCustomer(String name) {
        CustomerModel model = new CustomerModel(nextId++).name(name);
        storage.put(model.getId(), model);
    }

    public Collection<CustomerModel> findCustomers() {
        return storage.values();
    }
}
