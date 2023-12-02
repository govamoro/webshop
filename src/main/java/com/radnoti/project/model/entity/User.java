package com.radnoti.project.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    //@Size(max = 255)
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne
    private Role roleName;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "registered_at")
    private ZonedDateTime registeredAt;
    @Column(name = "deleted")
    private Boolean isDeleted;
    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;


}