/**
	@author Shahdous Zaman Khan Prohor 3746335
*/
public class WaterDriver {

    public static void main(String[] args) {
        if (args.length <= 0) {
        
            System.out.println("No file name provided.");
            return;
        }

        try {
        
            WaterCounter waterCounter = new WaterCounter(args[0]);
            
            System.out.println("Initial Map:");
            System.out.println(waterCounter);

            int waterArea = waterCounter.countWater();
            
            System.out.println("Water Area: " + waterArea + " pixels");
            
        } catch (Exception e) {
            System.out.println("Error while processing the following file: " + e.getMessage());
        }
    }
}
