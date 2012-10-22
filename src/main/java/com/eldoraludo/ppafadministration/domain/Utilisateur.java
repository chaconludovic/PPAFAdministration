/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.eldoraludo.ppafadministration.domain.Membreppaf;
import com.eldoraludo.ppafadministration.domain.PersistableHashBuilder;
import com.eldoraludo.ppafadministration.domain.Role;
import com.google.common.base.Objects;

@Entity
@Table(name = "UTILISATEUR")
@Cache(usage = NONSTRICT_READ_WRITE)
public class Utilisateur implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Utilisateur.class);

    // Raw attributes
    private Integer id; // pk
    private String username; // not null
    private String password; // not null
    private String email; // not null
    private String rue;
    private String ville;
    private String codepostal;
    private String infosuppl;
    private Boolean enabled; // not null
    private Integer version;

    // Technical attributes for query by example
    private Integer membreppafId;

    // Many to one
    private Membreppaf membreppaf; // (membreppafId)

    // Many to many
    private List<Role> roles = new ArrayList<Role>();

    // ---------------------------
    // Constructors
    // ---------------------------

    public Utilisateur() {
    }

    public Utilisateur(Integer primaryKey) {
        setId(primaryKey);
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [id] ------------------------

    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    // -- [username] ------------------------

    @Size(min = 4, max = 255)
    @NotEmpty
    @Column(name = "login", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // -- [password] ------------------------

    @Size(max = 255)
    @NotEmpty
    @Column(name = "`PASSWORD`", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // -- [email] ------------------------

    @Size(max = 255)
    @NotEmpty
    @Email
    @Column(nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // -- [rue] ------------------------

    @Size(max = 255)
    @Column(name = "RUE")
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    // -- [ville] ------------------------

    @Size(max = 255)
    @Column(name = "VILLE")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // -- [codepostal] ------------------------

    @Size(max = 255)
    @Column(name = "codePostal")
    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    // -- [infosuppl] ------------------------

    @Size(max = 2147483647)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "infoSuppl")
    @Lob
    public String getInfosuppl() {
        return infosuppl;
    }

    public void setInfosuppl(String infosuppl) {
        this.infosuppl = infosuppl;
    }

    // -- [membreppafId] ------------------------

    @Column(name = "membrePPAF_id", precision = 10, insertable = false, updatable = false)
    public Integer getMembreppafId() {
        return membreppafId;
    }

    private void setMembreppafId(Integer membreppafId) {
        this.membreppafId = membreppafId;
    }

    // -- [enabled] ------------------------

    @NotNull
    @Column(nullable = false, length = 1)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // -- [version] ------------------------

    @Column(name = "VERSION", precision = 10)
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    // --------------------------------------------------------------------
    // Many to One support
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Utilisateur.membreppafId ==> Membreppaf.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinColumn(name = "membrePPAF_id")
    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    public Membreppaf getMembreppaf() {
        return membreppaf;
    }

    /**
     * Set the membreppaf without adding this Utilisateur instance on the passed membreppaf
     * If you want to preserve referential integrity we recommend to use
     * instead the corresponding adder method provided by {@link Membreppaf}
     */
    public void setMembreppaf(Membreppaf membreppaf) {
        this.membreppaf = membreppaf;

        // We set the foreign key property so it can be used by our JPA search by Example facility.
        if (membreppaf != null) {
            setMembreppafId(membreppaf.getId());
        } else {
            setMembreppafId(null);
        }
    }

    // --------------------------------------------------------------------
    // Many to Many
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: utilisateur ==> roles
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Returns the roles list.
     */
    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinTable(name = "UTILISATEUR_ROLE", joinColumns = @JoinColumn(name = "UTILISATEUR_ID"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(cascade = PERSIST)
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Set the roles list.
     * <p>
     * It is recommended to use the helper method {@link #addRole(Role)} / {@link #removeRole(Role)}
     * if you want to preserve referential integrity at the object level.
     *
     * @param roles the list of Role
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Helper method to add the passed {@link Role} to the roles list.
     */
    public boolean addRole(Role role) {
        return getRoles().add(role);
    }

    /**
     * Helper method to remove the passed {@link Role} from the roles list.
     */
    public boolean removeRole(Role role) {
        return getRoles().remove(role);
    }

    /**
     * Helper method to determine if the passed {@link Role} is present in the roles list.
     */
    public boolean containsRole(Role role) {
        return getRoles() != null && getRoles().contains(role);
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    /**
     * equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Utilisateur && hashCode() == other.hashCode());
    }

    private PersistableHashBuilder persistableHashBuilder = new PersistableHashBuilder();

    @Override
    public int hashCode() {
        return persistableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Utilisateur instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("username", getUsername()) //
                .add("password", getPassword()) //
                .add("email", getEmail()) //
                .add("rue", getRue()) //
                .add("ville", getVille()) //
                .add("codepostal", getCodepostal()) //
                .add("infosuppl", getInfosuppl()) //
                .add("membreppafId", getMembreppafId()) //
                .add("enabled", getEnabled()) //
                .add("version", getVersion()) //
                .toString();
    }
}