package AdminCES_Script2.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static IBrowser browser;
    protected static String url;
    protected static String hash;

    @BeforeAll
    static public void configuration() {
        browser = BrowserFactory.getBrowser(false);
        url = "http://cestore.ces.com.uy/adminces/";
        hash = "3)ea60e0be3ba12c6ecd%7297868%5c4";
    }

    @AfterAll
    static public void close() {
        BrowserFactory.quitBrowser();
    }
}

