/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Entity.e.vm.java
 */
package com.eldoraludo.ppafadministration.domain;

import static javax.persistence.CascadeType.ALL;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.NotEmpty;
import com.eldoraludo.ppafadministration.domain.Itemlieudestockage;
import com.eldoraludo.ppafadministration.domain.Membreppaf;
import com.google.common.base.Objects;

@Entity
@Table(name = "LIEUDESTOCKAGE")
@Cache(usage = NONSTRICT_READ_WRITE)
public class Lieudestockage implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Lieudestockage.class);

    // Raw attributes
    private Integer id; // pk
    private String nom; // not null
    private String rue;
    private String ville;
    private String codepostal;
    private String infosuppl;
    private String note;

    // Technical attributes for query by example
    private Integer membreppafresponsableId; // not null

    // Many to one
    private Membreppaf membreppafresponsable; // not null (membreppafresponsableId)

    // One to many
    private List<Itemlieudestockage> itemlieudestockages = new ArrayList<Itemlieudestockage>();

    // ---------------------------
    // Constructors
    // ---------------------------

    public Lieudestockage() {
    }

    public Lieudestockage(Integer primaryKey) {
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

    // -- [nom] ------------------------

    @Size(max = 255)
    @NotEmpty
    @Column(nullable = false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // -- [membreppafresponsableId] ------------------------

    @Column(name = "MEMBREPPAFRESPONSABLE_ID", nullable = false, precision = 10, insertable = false, updatable = false)
    public Integer getMembreppafresponsableId() {
        return membreppafresponsableId;
    }

    private void setMembreppafresponsableId(Integer membreppafresponsableId) {
        this.membreppafresponsableId = membreppafresponsableId;
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

    // -- [note] ------------------------

    @Size(max = 2147483647)
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "NOTE")
    @Lob
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // --------------------------------------------------------------------
    // Many to One support
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Lieudestockage.membreppafresponsableId ==> Membreppaf.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinColumn(name = "MEMBREPPAFRESPONSABLE_ID", nullable = false)
    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    public Membreppaf getMembreppafresponsable() {
        return membreppafresponsable;
    }

    /**
     * Set the membreppafresponsable without adding this Lieudestockage instance on the passed membreppafresponsable
     * If you want to preserve referential integrity we recommend to use
     * instead the corresponding adder method provided by {@link Membreppaf}
     */
    public void setMembreppafresponsable(Membreppaf membreppafresponsable) {
        this.membreppafresponsable = membreppafresponsable;

        // We set the foreign key property so it can be used by our JPA search by Example facility.
        if (membreppafresponsable != null) {
            setMembreppafresponsableId(membreppafresponsable.getId());
        } else {
            setMembreppafresponsableId(null);
        }
    }

    // --------------------------------------------------------------------
    // One to Many support
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // one to many: lieudestockage ==> itemlieudestockages
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Cache(usage = NONSTRICT_READ_WRITE)
    @OneToMany(mappedBy = "lieudestockage", orphanRemoval = true, cascade = ALL)
    public List<Itemlieudestockage> getItemlieudestockages() {
        return itemlieudestockages;
    }

    /**
     * Set the {@link Itemlieudestockage} list.
     * It is recommended to use the helper method {@link #addItemlieudestockage(Itemlieudestockage)} / {@link #removeItemlieudestockage(Itemlieudestockage)}
     * if you want to preserve referential integrity at the object level.
     *
     * @param itemlieudestockages the list to set
     */
    public void setItemlieudestockages(List<Itemlieudestockage> itemlieudestockages) {
        this.itemlieudestockages = itemlieudestockages;
    }

    /**
     * Helper method to add the passed {@link Itemlieudestockage} to the itemlieudestockages list
     * and set this lieudestockage on the passed itemlieudestockage to preserve referential
     * integrity at the object level.
     *
     * @param itemlieudestockage the to add
     * @return true if the itemlieudestockage could be added to the itemlieudestockages list, false otherwise
     */
    public boolean addItemlieudestockage(Itemlieudestockage itemlieudestockage) {
        if (getItemlieudestockages().add(itemlieudestockage)) {
            itemlieudestockage.setLieudestockage((Lieudestockage) this);
            return true;
        }
        return false;
    }

    /**
     * Helper method to determine if the passed {@link Itemlieudestockage} is already present in the itemlieudestockages list.
     *
     * @param itemlieudestockage the instance to look up.
     * @return true if the itemlieudestockages list contains the passed itemlieudestockage, false otherwise.
     */
    public boolean containsItemlieudestockage(Itemlieudestockage itemlieudestockage) {
        return getItemlieudestockages() != null && getItemlieudestockages().contains(itemlieudestockage);
    }

    /**
     * Helper method to remove the passed {@link Itemlieudestockage} from the itemlieudestockages list and unset
     * this lieudestockage from the passed itemlieudestockage to preserve referential integrity at the object level.
     *
     * @param itemlieudestockage the instance to remove
     * @return true if the itemlieudestockage could be removed from the itemlieudestockages list, false otherwise
     */
    public boolean removeItemlieudestockage(Itemlieudestockage itemlieudestockage) {
        if (getItemlieudestockages().remove(itemlieudestockage)) {
            itemlieudestockage.setLieudestockage(null);
            return true;
        }
        return false;
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
        return this == other || (other instanceof Lieudestockage && hashCode() == other.hashCode());
    }

    private volatile int previousHashCode = 0;

    @Override
    public int hashCode() {
        int hashCode = Objects.hashCode(getNom());
        if (previousHashCode != 0 && previousHashCode != hashCode) {
            log.warn("DEVELOPER: hashCode has changed!." //
                    + "If you encounter this message you should take the time to carefuly review equals/hashCode for: " //
                    + getClass().getCanonicalName());
        }

        previousHashCode = hashCode;
        return hashCode;
    }

    /**
     * Construct a readable string representation for this Lieudestockage instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("nom", getNom()) //
                .add("membreppafresponsableId", getMembreppafresponsableId()) //
                .add("rue", getRue()) //
                .add("ville", getVille()) //
                .add("codepostal", getCodepostal()) //
                .add("infosuppl", getInfosuppl()) //
                .add("note", getNote()) //
                .toString();
    }
}