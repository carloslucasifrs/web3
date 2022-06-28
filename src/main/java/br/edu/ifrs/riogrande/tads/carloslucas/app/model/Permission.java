package br.edu.ifrs.riogrande.tads.carloslucas.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    Integer id;

    @Column(name = "permission", length = 30, nullable = false, unique = true)
    @ToString.Include
    String permission;

    @Column(name = "model", length = 30, nullable = false)
    @ToString.Include
    String model;


    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setPermissions(List<Role> roles) {
        this.roles = roles;
    }
    // @ManyToMany(fetch = FetchType.LAZY)
    // @JoinTable(name = "roles_has_permissions", joinColumns = {
    // @JoinColumn(name = "permissions_id", nullable = false) }, inverseJoinColumns
    // = {
    // @JoinColumn(name = "roles_id", nullable = false) })
    // List<Role> roles;

}
