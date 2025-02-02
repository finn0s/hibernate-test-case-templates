package org.hibernate.bugs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Kitten")
public class Kitten {

    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    public Kitten(final String name) {
        this.name = name;
    }

    public Kitten() {
    }
}
