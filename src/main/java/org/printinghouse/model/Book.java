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
public class Book extends Publication {
    private CoverType coverType;
    private int numberOfPages;

    public Book(String title, LocalDate publishingDate, int numberOfPages, PaperSize paperSize, CoverType coverType, BigDecimal salePrice) {
        super(title, publishingDate, paperSize, salePrice);
        this.numberOfPages = numberOfPages;
        this.coverType = coverType;
    }

    @Override
    public BigDecimal getPrintingCost() {
        BigDecimal coverPrice = coverType == CoverType.SOFT_COVER ? Constants.SOFT_COVER_PRICE : Constants.HARD_COVER_PRICE;
        return  getPageCost().multiply(new BigDecimal(numberOfPages)).add(coverPrice).add(Constants.BOOK_PRICE);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", publishingDate=" + getPublishingDate() +
                ", numberOfPages=" + numberOfPages +
                ", paperSize=" + getPaperSize() +
                ", coverType=" + coverType +
                ", salePrice=" + getSalePrice() +
                ", printingCost=" + getPrintingCost() +
                '}';
    }
}