package org.hibernate.bugs;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Cat")
public class Cat extends Animal {

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Cat_Kitten",
            joinColumns = {@JoinColumn(name = "catId")},
            inverseJoinColumns = {@JoinColumn(name = "kittenId")}
    )
    public List<Kitten> kittens = new ArrayList<>();

    public Cat(final int age, final List<Kitten> kittens) {
        this.age = age;
        this.kittens = kittens;
    }

    public Cat() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public List<Kitten> getKittens() {
        return kittens;
    }

    public void setKittens(final List<Kitten> kittens) {
        this.kittens = kittens;
    }
}
