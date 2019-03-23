import java.util.InputMismatchException;
import java.util.Scanner;

public class StockValues {
    
    
    public static long[] bubbleSort(long[] array){
        boolean flag = true;
        long temp;  
        while(flag){        
           flag = false; 
           for(int i=0; i<array.length-1; i++){     
                if(array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true; 
                }      
            }  
        }    
        return array;
    }
  
    
    public static int input(){
        int n = 0;
        Scanner stock = new Scanner(System.in);
        System.out.println("How many number 'n' of stock values are available?");
        System.out.print("n = ");
        
        while(stock.hasNextInt()){
            n = stock.nextInt();     
                if(n<=0){
                    System.out.println("Number of available stock values must be greater than 0!");
                    System.out.print("n = ");
                } else if (n>0 && n<100000){
                    break;
                } else {
                    System.out.println("Number of available stock values must be less than 100000 (one hundred thousand)!");
                    System.out.print("n = "); 
                }                   
        }
        return n;      
    }
    
 
    public static long[] stock (int n){       
        Scanner stock = new Scanner (System.in);
        long stockValues[] = null;
        int counter = 1;   
        if (n>0 && n<100000){
            stockValues = new long [n];
            boolean flag = true;
            long maxValue = (long) Math.pow(2, 31);     
            for(int i=0; i<n; i++){   
                while (flag){
                    System.out.println("Enter " + counter + " of " + n + " stock value: ");
                    System.out.print("v" + counter + " = ");
                    String validator = stock.next();
                    if (validator.length()<=11) {     
                        if (validator.matches("[0-9]+") || validator.matches("-\\d+")){
                            long valid = Long.parseLong(validator);
                            stockValues[i] = valid;
                            if (stockValues[i] <= 0){
                                System.out.println("Stock value cannot be less or equal to zero!");
                            } else if (stockValues[i] < maxValue){
                                counter++;
                                break;
                            } 
                        } else {
                            System.out.println("String in not a a valid integer!");
                        }        
                    } else {
                    System.out.println("The number is out of range, try value form 1 to 100000 (one hundred thousand)!");
                    }         
                }     
            }   
            stock.close();
            return stockValues;
        }
        return stockValues;
}
    

    public static void main(String[] args) {     
        int n = input();
        long [] stockValues = stock(n);
        if (n>0 && n<100000){  
            long maxValue = 0;
            long [] p = new long[n];
            for (int i=0; i<stockValues.length; i++){
                if(stockValues[i] > maxValue){
                    maxValue = stockValues[i];
                }     
                p[i] = maxValue - stockValues[i];
                p[i] = p[i] * (-1);
                }
            // With The Bubble sort we can sort loses from the highest to the lowest and vice versa!
            bubbleSort(p);     
            System.out.println("The maximal loss p is " + p[0]);
        } else{
            System.out.println("That is not a valid integer or it's out of range!");
            System.out.println("Try integer from 1 to 100000 (one hundred thousand).");
            System.out.println("----------------------------");
            StockValues.main(args);
        }      
    }  
}
