package ua.teamdev.drozdov.vadim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        StateMachineCalculator stateMachineCalculator = new StateMachineCalculator();

        System.out.println("Press q to exit");
        System.out.println("Enter math expression =>");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        try {
            while (!(line = bufferedReader.readLine()).equals("q")) {
                try {
                    System.out.println("Result is: " + stateMachineCalculator.evaluate(line.replaceAll(",", ", ")));
                } catch (EvaluationException exception) {
                    System.out.println(exception.getMessage());

                    System.out.println("at position " + exception.getErrorIndex());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
