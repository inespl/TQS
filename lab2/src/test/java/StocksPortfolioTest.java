import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    IStockMarket stockMarket2;
    @InjectMocks
    StocksPortfolio portfolio2;

    @Test
    void testGetTotalValue(){
        // 1.Prepare a mock to substitute the remote service (@Mock annotation)
        IStockMarket stockMarket = mock(IStockMarket.class);

        // 2.Create an instance of the subject under test (SuT) and use the mock to set the (remote) service instance.
        StocksPortfolio portfolio = new StocksPortfolio(stockMarket);

        // 3.Load the mock with the proper expectations (when...thenReturn)
        when(stockMarket.getPrice("EBAY")).thenReturn(4.0);
        when(stockMarket.getPrice("MSFT")).thenReturn(1.5);

        // 4.Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock("EBAY", 2));
        portfolio.addStock(new Stock("MSFT", 4));
        double result = portfolio.getTotalValue();

        // 5.Verify the result (assert) and the use of the mock (verify
        assertEquals(14.0, result);
        verify(stockMarket, times(2)).getPrice(anyString());
    }

    @Test
    void testGetTotalValue2(){
        // 1.Prepare a mock to substitute the remote service (@Mock annotation)

        // 2.Create an instance of the subject under test (SuT) and use the mock to set the (remote) service instance.

        // 3.Load the mock with the proper expectations (when...thenReturn)
        when(stockMarket2.getPrice("EBAY")).thenReturn(4.0);
        when(stockMarket2.getPrice("MSFT")).thenReturn(1.5);

        // 4.Execute the test (use the service in the SuT)
        portfolio2.addStock(new Stock("EBAY", 2));
        portfolio2.addStock(new Stock("MSFT", 4));
        double result = portfolio2.getTotalValue();

        // 5.Verify the result (assert) and the use of the mock (verify
        assertEquals(14.0, result);
        // assertThat(portfolio2.getTotalValue(), is(14));
        verify(stockMarket2, times(2)).getPrice(anyString());
    }
}
