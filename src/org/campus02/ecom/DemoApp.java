package org.campus02.ecom;

import java.util.ArrayList;

public class DemoApp {
    public static void main(String[] args) throws DataFileException {

        try {
            ArrayList<BasketData> list = BasketDataLoader.load("data/buyings.json");
            System.out.println(list.size());
            for (BasketData bd: list) {
                System.out.println(bd);
            }

        } catch (DataFileException e) {
            throw new DataFileException("Data File Exception", e);
        }
    }
}
