package DesignPatterns.Factory;

import java.util.HashMap;
import java.util.Map;

enum LaptopType{
    LENOVO,
    HP,
    DELL
}

interface Laptop {

    LaptopType getLaptopType();
    Laptop makeLaptop();
}

class HPLaptop implements Laptop {

    public HPLaptop(){
        FactoryPattern.map.put(LaptopType.HP, new HPLaptop());
    }

    @Override
    public LaptopType getLaptopType() {
        return LaptopType.HP;
    }

    @Override
    public Laptop makeLaptop() {
        return new HPLaptop();
    }
}

class DellLaptop implements Laptop {

    public DellLaptop(){
        FactoryPattern.map.put(LaptopType.DELL, new DellLaptop());
    }

    @Override
    public LaptopType getLaptopType() {
        return LaptopType.DELL;
    }

    @Override
    public Laptop makeLaptop() {
        return new HPLaptop();
    }
}

class LenovoLaptop implements Laptop {

    @Override
    public LaptopType getLaptopType() {
        return LaptopType.LENOVO;
    }

    @Override
    public Laptop makeLaptop() {
        System.out.println("creating Lenovo laptop");
        return new LenovoLaptop();
    }
}

public class FactoryPattern {
    public static final Map<LaptopType, Laptop> map = new HashMap<>();

    public static final void create(LaptopType laptopType){
        map.get(laptopType).makeLaptop();
    }

    public static void main(String[] args) {
        FactoryPattern.map.put(LaptopType.LENOVO, new LenovoLaptop());
        FactoryPattern.create(LaptopType.LENOVO);
    }

}


