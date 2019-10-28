package cassianoalves.tdddojo.legacy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FactorDaoFactory.class)
public class SomeComponentTest {

    @Mock
    private FactorDao factorDao;

    @InjectMocks
    private SomeComponent someComponent;

    @Test
    public void testMultiplyByFactorOfCode() {
        PowerMockito.mockStatic(FactorDaoFactory.class);

        Mockito.when(FactorDaoFactory.getInstance()).thenReturn(factorDao);
        Mockito.when(factorDao.getFactor(123)).thenReturn(10);
        int result = someComponent.multiplyByFactorOfCode(123, 20);

        assertEquals(200, result);
    }

}