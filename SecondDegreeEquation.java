/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package seconddegreeequation;

import java.util.Scanner;

/**
 *
 * @author Paula
 */
public class SecondDegreeEquation {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);

        System.out.println("Indica el valor del coeficiente de segundo grado:");
        int firstCoefficient = read.nextInt();        
        if (firstCoefficient == 0) {
            System.out.println("El valor del coeficiente de segundo grado no puede ser 0.");
            return;
        }

        System.out.println("Indica el valor del coeficiente de primer grado:");
        int secondCoefficient = read.nextInt();

        System.out.println("Indica el valor del término independiente:");
        int independentTerm = read.nextInt();
            
        /** Discriminant: D = b2 - 4ac */
        double discriminant = Discriminant(firstCoefficient, secondCoefficient, independentTerm);
        
        if (discriminant >= 0) {           
            
            /** one solution: two results with the same value*/
            if (discriminant == 0) {
                
                double solution = SolutionWhenDiscrimantIsZero(firstCoefficient, secondCoefficient, independentTerm);
                
                System.out.println("La ecuación tiene una sola solución doble. La solución es " + solution + ".");
                        
            /**two solutions*/
            } else {
                
                double[] solutions = SolutionWhenDiscriminantIsGreaterThanZero(firstCoefficient, secondCoefficient, independentTerm);              
                
                System.out.println("La ecuación tiene dos soluciones. Las soluciones de la ecuación son "+ solutions[0] + " y " + solutions[1] + ".");
            }

        /**no solutions, D < 0*/
        } else {
            
            System.out.println("La ecuación no tiene solución real.");
        }
    }
    
    public static double Discriminant(int firstCoefficient, int secondCoefficient, int independentTerm)
    {
        return Math.pow(secondCoefficient, 2) - (4 * firstCoefficient * independentTerm );
    }
    
    public static double SolutionWhenDiscrimantIsZero(int firstCoefficient, int secondCoefficient, int independentTerm)
    {
        return (-secondCoefficient + Math.sqrt((Math.pow(secondCoefficient, 2)) - (4 * firstCoefficient * independentTerm ))) /(2 * firstCoefficient);
    }
    
    public static double[] SolutionWhenDiscriminantIsGreaterThanZero(int firstCoefficient, int secondCoefficient, int independentTerm)
    {      
        double[] solutions = new double[2];
                
        solutions[0] = (-secondCoefficient + Math.sqrt((Math.pow(secondCoefficient, 2)) - (4 * firstCoefficient * independentTerm ))) /(2 * firstCoefficient);

        solutions[1] = ((-secondCoefficient) - Math.sqrt((Math.pow(secondCoefficient, 2)) - (4 * firstCoefficient * independentTerm ))) /(2 * firstCoefficient);
    
        return solutions;
    }
}
