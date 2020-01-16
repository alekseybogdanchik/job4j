package sort;

import org.junit.Test;
import ru.job4j.sort.Machine;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when100by32() {
        Machine machine = new Machine();
        int[] expected = {10, 10, 10, 10, 10, 10, 5, 2, 1};
        int[] rsl = machine.change(100, 32);
        assertThat(rsl, is(expected));
    }
}
