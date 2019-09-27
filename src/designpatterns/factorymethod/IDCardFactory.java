package designpatterns.factorymethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDCardFactory extends Factory {

    private List<Product> owners = new ArrayList<>();

    private Map<Integer, String> numberToName = new HashMap<>();


    @Override
    protected Product createProduct(String name) {
        return new IDCard(name);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(product);
        numberToName.put(product.getSerial(), product.getOwner());
    }

    public List<Product> getOwners() {
        return owners;
    }

    @Override
    public String toString() {
        return "IDCardFactory{" +
                "owners=" + owners +
                ", numberToName=" + numberToName +
                '}';
    }
}
