import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CarService {

    public List<SalesData> loadData(String fileName) throws IOException {
        List<SalesData> salesData = new ArrayList<>();
        SalesData teslaData;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] data = line.split(",");
                String tempDate = data[0];
                YearMonth parsedDate = YearMonth
                        .parse(tempDate, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
                Integer sales = Integer.valueOf(data[1]);
                teslaData = new SalesData(parsedDate, sales);
                salesData.add(teslaData);
            }
            return salesData;
        }
    }

    public void showReport(List<SalesData> carSalesData, String modelType) {

        System.out.println(modelType + " Yearly Sales Report");
        System.out.println("------------------------------------------------------");

        Map<Integer, List<SalesData>> groupedDates = carSalesData.stream()
                .collect(Collectors.groupingBy(data -> data.getDate().getYear()));

        String totalSales = groupedDates.entrySet()
                .stream()
                .map(data -> data.getKey() + " -> " +
                        data.getValue()
                                .stream()
                                .collect(Collectors.summarizingInt(SalesData::getSales))
                                .getSum())
                .collect(Collectors.joining("\n"));


        // ** IntelliJ was suggesting to change the above code to the below. Seems to be easier **

                        /*data.getValue()
                            .stream()
                            .mapToInt(SalesData::getSales)
                            .sum())
                            .collect(Collectors.joining("\n"));*/

        System.out.println(totalSales);

        SalesData maxValue = getMax(carSalesData);
        SalesData minValue = getMin(carSalesData);
        System.out.println("");

        System.out.println("The best month for " + modelType + " was: " + maxValue);
        System.out.println("The worst month for " + modelType + " was: " + minValue);
        System.out.println("");

        // Below code has no relevance. Was my original go w/o streams.
        // Just included for me to look back on at later dates

        /*System.out.println(modelType + " Yearly Sales Report");
        System.out.println("------------------------------------------------------");
        int data2016 = oldNoStreamMethodForSales(2016, carSalesData);
        System.out.print("2016 -> ");
        System.out.println(data2016);
        int data2017 = oldNoStreamMethodForSales(2017, carSalesData);
        System.out.print("2017 -> ");
        System.out.println(data2017);
        int data2018 = oldNoStreamMethodForSales(2018, carSalesData);
        System.out.print("2018 -> ");
        System.out.println(data2018);
        int data2019 = oldNoStreamMethodForSales(2019, carSalesData);
        System.out.print("2019 -> ");
        System.out.println(data2019);
        System.out.println("");
        System.out.println("The best month for " + modelType + " was: " + maxValue);
        System.out.println("The worst month for " + modelType + " was: " + minValue);
        System.out.println("");*/
    }

    private SalesData getMax(List<SalesData> carSalesData) {
        return carSalesData.stream()
                .max(Comparator
                        .comparingInt(SalesData::getSales))
                .get(); // Trevor suggested to replace with .orElse
    }

    private SalesData getMin(List<SalesData> carSalesData) {
        return carSalesData.stream()
                .min(Comparator
                        .comparingInt(SalesData::getSales))
                .get();
    }

    // Added below for old reference -- No relevance -- doesn't include streams

    public int oldNoStreamMethodForSales(int passedYear, List<SalesData> carSalesData)
    {
        int yearlySales = 0;
        for (SalesData element: carSalesData)
        {
            if(element.getDate().getYear() == passedYear)
            {
                yearlySales = yearlySales + element.getSales();
            }
        }
        return yearlySales;
    }
}