package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUI {

    public void init(Input input, Store tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        int index = 0;
        System.out.println("Menu:");
        for (UserAction action : actions) {
            System.out.println(index + ". " + action.name());
            index++;
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction());
            actions.add(new ShowAllItemsAction());
            actions.add(new EditItemAction());
            actions.add(new DeleteAction());
            actions.add(new FindByIDAction());
            actions.add(new FindByNameAction());
            actions.add(new ExitAction());
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
