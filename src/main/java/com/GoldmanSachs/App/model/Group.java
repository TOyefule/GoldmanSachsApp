package com.GoldmanSachs.App.model;

import com.sun.jdi.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import reactor.util.annotation.NonNull;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity


@Table(name = "user_group")
public class Group {


    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;
}