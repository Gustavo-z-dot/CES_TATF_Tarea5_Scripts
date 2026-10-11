package AdminCES_ConTestParametrizados.base;

import AdminCES_ConTestParametrizados.home.data.HomeData;
import AdminCES_ConTestParametrizados.home.task.HomeTask;
import AdminCES_ConTestParametrizados.login.data.LoginData;
import AdminCES_ConTestParametrizados.login.task.AccessTask;
import AdminCES_ConTestParametrizados.login.task.LoginTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected IBrowser browser;
    protected IVerify verify;

    @BeforeEach
    public void setUp() {
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        browser.interaction().navigateTo(HomeData.URL_HOME);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(LoginData.HASH);

    }

    public void loginComoAdmin() {
        HomeTask homeTask = new HomeTask(browser);
        homeTask.irALogin();

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesion(LoginData.CORREO_LOGIN, LoginData.PASSWORD_LOGIN);
        browser.interaction().navigateTo(HomeData.URL_HOME);
    }


    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
