package domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//должен быть Синглтон по смыслу, для эмуляции инстанцируется один раз в статическое поле АПИ сервиса
public class CustomerService {
    private long nextId = 0;
    private Map<Long, CustomerModel> storage = new HashMap<>();

    public long add(String name) {
        CustomerModel model = new CustomerModel(nextId).name(name);
        storage.put(model.getId(), model);
        return nextId++;
    }

    public Collection<CustomerModel> find() {
        return storage.values();
    }

    public CustomerModel find(Long customerId) {
        return storage.get(customerId);
    }

    public CustomerModel delete(Long customerId) {
        return storage.remove(customerId);
    }
}
