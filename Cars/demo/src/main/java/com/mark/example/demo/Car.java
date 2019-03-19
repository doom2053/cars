package com.mark.example.demo;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car {
    @Id @GeneratedValue
 private  int  id;
    private @NonNull String name;
    private @NonNull String color;
    private String vin;
}
