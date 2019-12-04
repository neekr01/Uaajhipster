package com.mycompany.myapp.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * A Quote.
 */
@Document(collection = "quote")
public class Quote implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("symbol")
    private String symbol;

    @NotNull
    @Field("price")
    private BigDecimal price;

    @NotNull
    @Field("last_trade")
    private ZonedDateTime lastTrade;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public Quote symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Quote price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getLastTrade() {
        return lastTrade;
    }

    public Quote lastTrade(ZonedDateTime lastTrade) {
        this.lastTrade = lastTrade;
        return this;
    }

    public void setLastTrade(ZonedDateTime lastTrade) {
        this.lastTrade = lastTrade;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quote)) {
            return false;
        }
        return id != null && id.equals(((Quote) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Quote{" +
            "id=" + getId() +
            ", symbol='" + getSymbol() + "'" +
            ", price=" + getPrice() +
            ", lastTrade='" + getLastTrade() + "'" +
            "}";
    }
}
