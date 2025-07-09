package de.tomsandt.salesync.domain.DTO;

public class ArticleDTO {

    private long id;
    private String type;
    private Long dealerId;
    private String name;
    private String description;

    // --- Getter & Setter ---

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

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(long dealerId) {
        this.dealerId = dealerId;
    }

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
