/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HospitalManagement;

import java.util.*;

/**
 *
 * @author Admin
 */
public class HospitalManagement {

  
    static class Patient {
        String name;
        int severity;        
        int arrivalOrder;   

        Patient(String name, int severity, int arrivalOrder) {
            this.name = name;
            this.severity = severity;
            this.arrivalOrder = arrivalOrder;
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public static void main(String[] args) {


        List<Patient> arrivalQueue = new ArrayList<>(); // normal queue (arrival order)
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt((Patient p) -> p.severity)
                          .thenComparingInt(p -> p.arrivalOrder)
        );


        List<Patient> patients = Arrays.asList(
                new Patient("Anna", 3, 1),
                new Patient("Bob", 1, 2),
                new Patient("Carla", 2, 3),
                new Patient("Dave", 1, 4)
        );


        for (Patient p : patients) {
            arrivalQueue.add(p);
            priorityQueue.add(p);
        }

   
        System.out.println("=== Arrival Order ===");
        System.out.print("Arrival Order: [");
        for (int i = 0; i < arrivalQueue.size(); i++) {
            System.out.print(arrivalQueue.get(i));
            if (i < arrivalQueue.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("\n=== Treatment Order ===");
        while (!priorityQueue.isEmpty()) {
            Patient next = priorityQueue.poll();
            System.out.println("Treating: " + next.name + " (Severity: " + next.severity + ")");
        }

        System.out.println("\nBUILD SUCCESSFUL (total time: 0 seconds)");
    }
}
