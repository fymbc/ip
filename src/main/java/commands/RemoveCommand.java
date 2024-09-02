package commands;
import storage.Storage;
import storage.TaskList;
import ui.UI;

public class RemoveCommand implements Command {
    private final String desc;

    public RemoveCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean execute(Storage storage, TaskList master, UI ui) {
        try {
            int index = Integer.parseInt(this.desc);

            master.removeTask(index - 1);
            storage.saveList(master.getParent());
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Friday > Input the task number (1 - " + master.getSize() + ") to remove the task");
        }
        UI.printLine();
        return false;
    }
}
