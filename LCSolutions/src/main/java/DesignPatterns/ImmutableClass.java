package DesignPatterns;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

    private final int id;

    private final String name;

    private final List<Integer> li;

    public ImmutableClass(int id, String name){
        this.id = id;
        this.name = name;
        li = new ArrayList<>();
        li.add(124);
    }

    public int getId(){return id;}

    public String getName(){return name;}

    public List<Integer> getList(){
        return new ArrayList<>(li);
        //return li;
    }
}

class ImmutableClassMain{

    public static void main(String[] args) {
        ImmutableClass im = new ImmutableClass(1, "abc");
        List<Integer> list = im.getList();
        System.out.println(list);
        list.add(234);
        List<Integer> list2 = im.getList(); // if we return just the instance of list then we can modify it here and
        // once returned it will return the modification as well. So that's why we need to return a new object
        System.out.println(list2);

        System.out.println(im.getId());
        //im.id = 10; // if fields are not private and final then, this is possible and we can update the fields as well
        System.out.println(im.getId());
    }
}
