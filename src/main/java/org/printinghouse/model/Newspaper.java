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
public class Newspaper extends Publication {
    private int numberOfPages;

    public Newspaper(String title, LocalDate publishingDate, int sheets, PaperSize paperSize, BigDecimal salePrice) {
        super(title, publishingDate, paperSize, salePrice);
        this.numberOfPages = sheets;
    }

    @Override
    public BigDecimal getPrintingCost() {
        return getPageCost().multiply(new BigDecimal(numberOfPages/2)).add(Constants.NEWSPAPER_PRICE);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", publishingDate=" + getPublishingDate() +
                ", numberOfPages=" + numberOfPages +
                ", paperSize=" + getPaperSize() +
                ", salePrice=" + getSalePrice() +
                ", printingCost=" + getPrintingCost() +
                '}';
    }
}