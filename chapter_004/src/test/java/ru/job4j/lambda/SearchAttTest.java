package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchAttTest {
    @Test
    public void filterBySize() {
        Attachment first = new Attachment("image 1", 70);
        Attachment second = new Attachment("image 2", 134);
        Attachment third = new Attachment("bug", 14);
        List<Attachment> attachments = Arrays.asList(first, second, third);
        List<Attachment> expected = Arrays.asList(second);
        assertThat(SearchAtt.filterSize(attachments), is(expected));
    }
    @Test
    public void filterByName() {
        Attachment first = new Attachment("image 1", 70);
        Attachment second = new Attachment("image 2", 134);
        Attachment third = new Attachment("bug", 14);
        List<Attachment> attachments = Arrays.asList(first, second, third);
        List<Attachment> expected = Arrays.asList(third);
        assertThat(SearchAtt.filterName(attachments), is(expected));
    }
}


