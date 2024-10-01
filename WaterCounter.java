import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
	@author Shahdous Zaman Khan Prohor 3746335
*/
public class WaterCounter{

    private char[][] map;
    private int r;
    private int c;
    
    /**
    Constructs a WaterCounter by reading from a file
    @param fileName the name of the title containing a map
    @throws RuntimeException if the file is not found
    */
    public WaterCounter(String fileName) {
    
        try (Scanner scan = new Scanner(new File(fileName))) {
        
       		this.r = scan.nextInt();
        	this.c = scan.nextInt();
        
        	scan.nextLine();

        	this.map = new char[r][c];
        
        	for(int i = 0; i < r; i++) {
        
            	String line = scan.nextLine();
            	for(int j = 0; j < c; j++) {
            
                	map[i][j] = line.charAt(j);
            	}
        	}
        } catch (FileNotFoundException e) {
       		System.err.println("File not found: " + fileName);
            throw new RuntimeException(e);
        }	
    }

	/**
	Calculates the area of water
	@return the area of the water body
	*/
    public int countWater() {
    
    	for (int i = 0; i < r; i++) {
    	
    		for (int j = 0; j < c; j++) {
    		
    			if (map[i][j] == 'W') {
    			
    				return countWater(i, j);
    			}
    		}
    	}
        return 0;
    }

	/**
	Counts the area of a body of water recursively
	@param row the row index of the starting pixel
    @param col the column index of the starting pixel
    @return the area of the water body connected to the starting pixel
	*/
    private int countWater(int row, int col) {
    
        if (row < 0 || col < 0 || row >= r || col >= c || map[row][col] != 'W') {
        
            return 0;
        } 
        map[row][col] = 'X';  
        return 1 + countWater(row + 1, col) + countWater(row - 1, col) +
                   countWater(row, col + 1) + countWater(row, col - 1);
    }

    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < r; i++) {
        
            for (int j = 0; j < c; j++) {
            
                sb.append(map[i][j]);
            }      
            sb.append("\n");
        }
        return sb.toString();
    }
}