package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> currentAccounts = users.get(user);
            if (!currentAccounts.contains(account)) {
                currentAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        Optional<User> findByPass = users.keySet().stream().
                filter(user -> user.getPassport().equals(passport)).
                findFirst();
        if (findByPass.isPresent()) {
            rsl = findByPass.get();
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            Optional<Account> find = users.get(user).stream().
                    filter(account -> account.getRequisite().equals(requisite)).
                    findFirst();
            if (find.isPresent()) {
                rsl = find.get();
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null) {
            rsl = src.transfer(dest, amount);
        }
        return rsl;
    }
}
