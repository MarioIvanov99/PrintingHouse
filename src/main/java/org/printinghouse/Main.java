package org.printinghouse;

import org.printinghouse.model.Catalogue;
import org.printinghouse.model.Order;
import org.printinghouse.service.PrintingHouseService;
import org.printinghouse.util.Constants;
import org.printinghouse.util.JsonLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Catalogue catalogue = null;
        List<Order> orders = null;

        try {
            catalogue = new Catalogue(JsonLoader.loadPublications(Constants.PUBLICATIONS_FILE_PATH));
            orders = JsonLoader.loadOrders(Constants.ORDERS_FILE_PATH);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total expenses: " + PrintingHouseService.calculateExpense(catalogue, orders));
        System.out.println("Total income: " + PrintingHouseService.calculateIncome(catalogue, orders));
        System.out.println("Profit: " + PrintingHouseService.calculateProfit(catalogue, orders));
        System.out.println("Profit after tax: " + PrintingHouseService.calculateNetProfit(catalogue, orders));
    }
}