import java.util.ArrayList;

public class Nursery {

    public static double PLANT_PRICE = 5.0;
    public static int DISCOUNT_THRESHOLD = 3;

    public static double calculateTotalPrice(ArrayList<String> plantList, int quantity, boolean isDiscount) {
        double totalPrice = 0.0;

        for (String plant : plantList) {
            double plantPrice = getPlantPrice(plant);

            if (isDiscount && quantity >= DISCOUNT_THRESHOLD) {
                totalPrice += applyDiscount(plantPrice);
            } else {
                totalPrice += plantPrice * quantity;
            }
        }

        return totalPrice;
    }

    public static double getPlantPrice(String plant) {
        if (plant.equals("Rose")) {
            return PLANT_PRICE;
        } else if (plant.equals("Lily")) {
            return PLANT_PRICE * 1.2;
        } else {
            return PLANT_PRICE * 1.5;
        }
    }

    public static double applyDiscount(double price) {
        // Discount is 10%
        return price * 0.9;
    }

    public static void processOrder(ArrayList<String> plantList, int quantity, boolean isDiscount) {
        double totalPrice = calculateTotalPrice(plantList, quantity, isDiscount);

        System.out.println("Processing order. Total Price: " + totalPrice);
    }

    public static void main(String[] args) {
        ArrayList<String> plants = new ArrayList<>();
        plants.add("Rose");
        plants.add("Lily");
        plants.add("Tulip");

        int quantity = 5;
        boolean applyDiscount = true;

        processOrder(plants, quantity, applyDiscount);
    }
}
