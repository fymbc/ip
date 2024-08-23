import java.util.Scanner;

public class Friday {
    public static void main(String[] args) {
        String logo = """
                ___________        .__     .___               \s
                \\_   _____/_______ |__|  __| _/_____    ___.__.
                 |    __)  \\_  __ \\|  | / __ | \\__  \\  <   |  |
                 |     \\    |  | \\/|  |/ /_/ |  / __ \\_ \\___  |
                 \\___  /    |__|   |__|\\____ | (____  / / ____|
                     \\/                     \\/      \\/  \\/    \s
                """;

        System.out.println("Loading........\n" + logo);
        printLine();

        TaskList master = new TaskList(100);

        System.out.println("""
                Hello! I'm Friday!
                What would you like to do?
                """);

        boolean bye = false;
        while(!bye) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Your input > ");
            String input = getInput(sc);
            String[] parsed = input.split(" ", 2);
            printLine();
            switch (parsed[0]) {
                case "Bye":
                case "bye":
                    bye = true;
                    break;
                case "Quit":
                case "quit":
                case "Exit":
                case "exit":
                    System.out.println("Friday > Type \"bye\" or \"Bye\" to exit");
                    printLine();
                    break;
                case "List":
                case "list":
                    System.out.println("Friday > Here's everything!\n" + master);
                    break;
                case "Remove":
                case "remove":
                    try {
                        int index = Integer.parseInt(parsed[1]);
                        master.removeTask(index-1);
                        break;
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Friday > Input the task number to remove the task\n");
                        break;
                    }
                case "Add":
                case "add":
                    master.addTask(new Task(parsed[1]));
                    printLine();
                    break;
                case "mark":
                case "unmark":
                    try {
                        int index = Integer.parseInt(parsed[1]);
                        master.doneTask(parsed[0], index-1);
                        printLine();
                        break;
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Friday > Input the task number to mark/unmark the task\n");
                        break;
                    }
                default:
                    System.out.println("Friday > Try add/remove <task>\n");
                    printLine();
                    break;
            }
        }
        terminate();
    }

    public static void printLine() {
        System.out.println("----------------------------------------------");
    }

    public static void terminate() {
        System.out.println("Friday > Bye! See you soon!");
        printLine();
    }

    public static String getInput(Scanner sc) {
        return sc.nextLine();
    }
}