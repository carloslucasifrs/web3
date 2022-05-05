package br.edu.ifrs.riogrande.tads.carloslucas.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Getter @Setter @ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    Integer id;

    @Column(name ="role", nullable = false)
    @ToString.Include
    String role;

}
