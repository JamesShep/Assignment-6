import java.io.IOException;
import java.util.List;


class RunnableApplication {

    public static void main(String[] args) throws IOException {
        CarService carService = new CarService();

        List<SalesData> salesData3 = carService.loadData("model3.csv");
        List<SalesData> salesDataS = carService.loadData("modelS.csv");
        List<SalesData> salesDataX = carService.loadData("modelX.csv");

        carService.showReport(salesData3, "Model 3");
        carService.showReport(salesDataS, "Model S");
        carService.showReport(salesDataX, "Model X");
    }
}