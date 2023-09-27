package org.campus02.ecom;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class BasketDataLoader {

    public static ArrayList<BasketData> load(String path) throws DataFileException {

        ArrayList<BasketData> list = new ArrayList<>();


        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line;

            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
               // String[] columns = line.split(",");
               // BasketData bd = new BasketData(columns[0], columns[1], Double.parseDouble(columns[2]), columns[3]);
                BasketData bd = new Gson().fromJson(line, BasketData.class);
                list.add(bd);
            }



        } catch (FileNotFoundException e) {
            throw new DataFileException("IO Exception", e);
        } catch (IOException e) {
            throw new DataFileException("IO Exception", e);
        }

        return list;
    }
}
