package com.starting.Chapter2_JPA;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_detail")
@NamedQuery(name = "Task2.findById", query="SELECT t FROM Task2 t WHERE t.id = :id")
@NamedQuery(name = "Task2.findByName", query="SELECT t FROM Task2 t WHERE t.name = :name")

public class Task2 implements Serializable {

    @Id
    private Long id;
    private String name;
    private LocalDate assignedOn;
    private LocalDateTime createdOn;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    public Task2()
    {

    }
    public Task2(Long id, String name)
    {
        this.id = id;
        this.name= name;
        this.createdOn = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAssignedon()
    {
        return assignedOn;
    }
    public void setAssignedOn(LocalDate assignedOn)
    {
        this.assignedOn = assignedOn;
    }


    public LocalDateTime getCreatedOn()
    {
        return createdOn;
    }
    public void setCreatedOn(LocalDateTime createdOn)
    {
        this.createdOn = createdOn;
    }

    @Override
    public String toString()
    {
        return "Task2{" + "id=" + id + ", name=" + name + ", assignedOn=" + assignedOn + ", createdOn=" + createdOn + '}';
    }
}
