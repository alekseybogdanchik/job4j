package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select >= 0 && select <= 6) {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } else {
                System.out.println("-- Enter a number between 0 and " + actions.length + " --");
            }
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllItemsAction(),
                new EditItemAction(),
                new DeleteAction(),
                new FindByIDAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
