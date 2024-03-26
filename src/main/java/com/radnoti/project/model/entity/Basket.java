package com.radnoti.project.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "basket")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Basket {

    @Id     //egyedülálló azonosító
    @Basic(optional = false)       //mező értéke nem lehet null
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //azonosító mező értékét az adatbázis generálja.
    @Column(name = "id")    //az adott mező milyen oszlopnévvel rendelkezik az adatbázisban
    private Integer id;

    @JoinColumn(name = "user", referencedColumnName = "id") //Itt a user tábla id azonosítójával kapcsoljuk össze
    private Integer user_id;

    @JoinColumn(name = "art", referencedColumnName = "id")
    private Integer art_id;
}
