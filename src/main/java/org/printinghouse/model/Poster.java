package org.printinghouse.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.printinghouse.util.Constants;

@Getter
@Setter
@NoArgsConstructor
public class Poster extends Publication {
    public Poster(String title, LocalDate publishingDate, PaperSize paperSize, BigDecimal salePrice) {
        super(title, publishingDate, paperSize, salePrice);
    }

    @Override
    public BigDecimal getPrintingCost() {
        return getPageCost().add(Constants.POSTER_PRICE);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", publishingDate=" + getPublishingDate() +
                ", paperSize=" + getPaperSize() +
                ", salePrice=" + getSalePrice() +
                ", printingCost=" + getPrintingCost() +
                '}';
    }
}
