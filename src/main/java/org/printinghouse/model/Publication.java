package org.printinghouse.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.printinghouse.util.Constants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Book.class, name = "Book"),
    @JsonSubTypes.Type(value = Newspaper.class, name = "Newspaper"),
    @JsonSubTypes.Type(value = Poster.class, name = "Poster")
})
public abstract class Publication {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id = idCounter.getAndIncrement();;
    private String title;
    private LocalDate publishingDate;
    private PaperSize paperSize;
    private BigDecimal salePrice;

    public Publication(String title, LocalDate publishingDate, PaperSize paperSize, BigDecimal salePrice) {
        this.title = title;
        this.publishingDate = publishingDate;
        this.paperSize = paperSize;
        this.salePrice = salePrice;
    }

    public BigDecimal getPageCost() {
        return switch (paperSize) {
            case A1 -> Constants.A1_PRICE;
            case A2 -> Constants.A2_PRICE;
            case A3 -> Constants.A3_PRICE;
            case A4 -> Constants.A4_PRICE;
            case A5 -> Constants.A5_PRICE;
        };
    }

    public abstract BigDecimal getPrintingCost();
}
