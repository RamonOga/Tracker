package ru.job4j.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if(pred.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> pred = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                boolean rsl = false;
                if(attachment.getSize() > 100) {
                    rsl = true;
                }
                return rsl;
            }
        };
        return filter(list, pred);
    }

    public List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> pred = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                boolean rsl = false;
                if (attachment.getName().equals("bug")) {
                    rsl = true;
                }
                return rsl;
            }
        };
        return filter(list, pred);
    }
}