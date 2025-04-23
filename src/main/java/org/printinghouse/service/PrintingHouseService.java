package org.printinghouse.service;

import org.printinghouse.model.Catalogue;
import org.printinghouse.model.Order;
import org.printinghouse.util.Constants;

import java.math.BigDecimal;
import java.util.List;

public class PrintingHouseService {
    public static BigDecimal calculateExpense(Catalogue catalogue, List<Order> orders) {
        BigDecimal expense = new BigDecimal("0.00");
        for (Order order : orders) {
            expense = expense.add(
                    catalogue.getPublicationById(
                    order.getPublicationId()).get().getPrintingCost()
                    .multiply(new BigDecimal(order.getCopies()))
            );
        }

        return expense;
    }

    public static BigDecimal calculateIncome(Catalogue catalogue, List<Order> orders) {
        BigDecimal income = new BigDecimal("0.00");
        for (Order order : orders) {
            income = income.add(
                    catalogue.getPublicationById(
                    order.getPublicationId()).get().getSalePrice()
                    .multiply(new BigDecimal(order.getCopies()))
            );
        }

        return income;
    }

    public static BigDecimal calculateProfit(Catalogue catalogue, List<Order> orders) {
        return calculateIncome(catalogue, orders).subtract(calculateExpense(catalogue, orders));
    }

    public static BigDecimal calculateNetProfit(Catalogue catalogue, List<Order> orders) {
        BigDecimal afterTaxMultiplier = new BigDecimal("1.0").subtract(Constants.BULGARIAN_TAX);
        return calculateProfit(catalogue, orders).multiply(afterTaxMultiplier);
    }
}
