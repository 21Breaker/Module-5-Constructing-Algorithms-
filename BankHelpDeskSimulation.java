public class BankHelpDeskSimulation {
    public static void main(String[] args) {
        HelpDeskManager manager = new HelpDeskManager(3, 5);

        // Simulate adding people to the queues
        for (int i = 1; i <= 15; i++) {
            int result = manager.addPersonToQueue(i);
            if (result == -1) {
                System.out.println("All queues are full. Person " + i + " could not be added.");
            } else {
                System.out.println("Person " + i + " added to queue " + result);
            }
        }

        // Simulate removing people from the desks
        for (int i = 0; i < 3; i++) {
            int personId = manager.removePersonFromDesk(i);
            System.out.println("Person " + personId + " removed from desk " + i);
        }
    }
}
