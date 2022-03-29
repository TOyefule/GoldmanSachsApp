package com.GoldmanSachs.App.model;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;


@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;


    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... strings) {
        Stream.of("Botswana", "Nigeria", "Liberia", "Jamaica", "Turks & Caicos",
                "Florida Keys", "Brazil", "Haiti", "Virgin Islands").forEach(name-> repository.save(new Group(name))
        );

        Group DBoogie = repository.findByName("Brazil");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        DBoogie.setEvents(Collections.singleton(e));
        repository.save(DBoogie);

        repository.findAll().forEach(System.out::println);
    }


    }