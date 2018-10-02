package com.codecool.springbootdrinks.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long typeId;
    @Column (name = "type_name")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "type")
    @JsonManagedReference
    private List<Recipe> comments = new ArrayList<>();

    protected Type(){}

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public long getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Recipe> getComments() {
        return comments;
    }

    public void setComments(List<Recipe> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
