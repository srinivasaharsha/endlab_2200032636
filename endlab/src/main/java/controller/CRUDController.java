package controller;

import model.CRUD;
import service.CRUDService;

import java.util.List;
import java.util.Scanner;

public class CRUDController {
    public static void main(String[] args) {
        CRUDService service = new CRUDService();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n1. Add Record");
                System.out.println("2. Update Record");
                System.out.println("3. Delete Record");
                System.out.println("4. Read All Records");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Add
                        CRUD newCrud = new CRUD();
                        System.out.print("Enter Name: ");
                        newCrud.setName(scanner.next());
                        System.out.print("Enter Department: ");
                        newCrud.setDepartment(scanner.next());
                        System.out.println(service.add(newCrud));
                        break;

                    case 2: // Update
                        CRUD updateCrud = new CRUD();
                        System.out.print("Enter ID to update: ");
                        updateCrud.setId(scanner.nextInt());
                        System.out.print("Enter New Name: ");
                        updateCrud.setName(scanner.next());
                        System.out.print("Enter New Department: ");
                        updateCrud.setDepartment(scanner.next());
                        System.out.println(service.update(updateCrud));
                        break;

                    case 3: // Delete
                        System.out.print("Enter ID to delete: ");
                        int deleteId = scanner.nextInt();
                        System.out.println(service.delete(deleteId));
                        break;

                    case 4: // Read
                        List<CRUD> crudList = service.read();
                        System.out.println("\n--- CRUD Records ---");
                        for (CRUD crud : crudList) {
                            System.out.println("ID: " + crud.getId() + ", Name: " + crud.getName() + ", Department: " + crud.getDepartment());
                        }
                        break;

                    case 5: // Exit
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
