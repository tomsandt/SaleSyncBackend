package de.tomsandt.salesync.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id", referencedColumnName = "id")
    @JsonIgnore
    private Dealer dealer;
    private String name;
    private String description;

    // --- Getter/Setter ---

    @JsonGetter("dealerId")
    public Long getCustomerId() {
        return dealer != null ? dealer.getId() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Dealer getDealer() { return dealer; }

    public void setDealer(Dealer dealer) { this.dealer = dealer; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
