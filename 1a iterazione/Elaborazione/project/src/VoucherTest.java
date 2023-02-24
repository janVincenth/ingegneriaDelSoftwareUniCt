import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class VoucherTest {
    static Voucher voucherTest;

    @BeforeAll
    static void setup() {
        voucherTest = new Voucher(123F);
    }

    @Test
    void VoucherTest() {
        LocalDate dataScadenzaTest = LocalDate.now().plusDays(180);

        assertEquals(dataScadenzaTest,voucherTest.getDataScadenzaVoucher());
    }
}