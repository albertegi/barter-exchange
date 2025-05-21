package com.alvirg.barterexchange.Shared.Domain;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected BaseEntity() {
    }

    protected BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
