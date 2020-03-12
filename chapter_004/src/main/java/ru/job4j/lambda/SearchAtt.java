package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> condition = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment att) {
                return att.getSize() > 100;
            }
        };
        return filterBy(list, condition);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> condition = att -> att.getName().contains("bug");
        return filterBy(list, condition);
    }

    public static List<Attachment> filterBy(List<Attachment> list, Predicate<Attachment> condition) {
        List<Attachment> result = new ArrayList<Attachment>();
        for (Attachment att : list) {
            if (condition.test(att)) {
                result.add(att);
            }
        }
        return result;
    }
}
