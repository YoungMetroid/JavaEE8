package com.starting.Chapter2_JPA;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.validation.ConstraintViolationException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CrudTest {

    @Inject
    private EntityManager em;

    public void doCRUD() {
        System.out.println("======== Single Task CRUD =============");
        save(100L, "Work on next big thing");
        read(100L);
        update(100L);
        remove(100L);
        read(100L);

        System.out.println("======== Task Read Options =============");
        save(201L, "Fix Bug A");
        save(202L, "Fix Bug B");

        readAll();
        readStream();
    }

    private void readStream() {
        TypedQuery<Task2> query = em.createQuery("SELECT t from Task2 t",
                Task2.class);
        List<String> names = query.getResultStream().map(Task2::getName)
                .collect(Collectors.toList());
        System.out.println("names found " + names);
    }

    private void readAll() {
        TypedQuery<Task2> query = em.createQuery("SELECT t FROM Task2 t", Task2.class);
        List<Task2> tasks = query.getResultList();
        System.out.println("tasks found " + tasks.size());
    }

    private void save(Long id, String name) {
        System.out.println("--------------------- save --------------------");
        em.getTransaction().begin();
        Task2 theTask = new Task2(id, name);
        em.persist(theTask);
        em.getTransaction().commit();
        System.out.println("saved task " + theTask);
    }

    private void read(Long id) {
        System.out.println("--------------------- read --------------------");
        TypedQuery<Task2> query = em.createNamedQuery("Task2.findById", Task2.class);
        query.setParameter("id", id);

        //With TypedQuery you don't need a cast to Task type below
        try {
            Task2 task = query.getSingleResult();
            System.out.println("task found " + task);
        } catch (NoResultException nre) {
            System.out.println("task not found ");
        }

    }

    private void update(Long id) {
        System.out.println("--------------------- update --------------------");
        em.getTransaction().begin();
        Task2 theTask = em.find(Task2.class, id);
        theTask.setAssignedOn(LocalDate.now().plusDays(5));
        em.getTransaction().commit();

        Task2 theUpdatedTask = em.find(Task2.class, 100L);
        System.out.println("theUpdatedTask assignedon " + theUpdatedTask.getAssignedon());
    }

    private void remove(Long id) {
        System.out.println("--------------------- remove --------------------");
        em.getTransaction().begin();
        Task2 theTask = em.find(Task2.class, id);
        em.remove(theTask); // theTask is a reference to Task object
        em.getTransaction().commit();
        System.out.println("removed task");
    }

    private void trySaveInvalid() {
        Task2 theTask = new Task2();
        theTask.setName("A longer name than allowed");
        try {
            em.persist(theTask);
        } catch (ConstraintViolationException violation) {
            violation.getConstraintViolations().forEach(
                    v -> System.out.println("violation " + v)
            );
        }
    }

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer
                .newInstance().initialize()) {
            CrudTest appInstance = container
                    .select(CrudTest.class)
                    .get();
            appInstance.doCRUD();
        }
    }
}
