package AdminCES_Script2.test;

import AdminCES_Script2.home.data.HomeData;
import AdminCES_Script2.home.task.HomeTask;
import AdminCES_Script2.login.data.LoginData;
import AdminCES_Script2.login.task.AccessTask;
import AdminCES_Script2.login.task.LoginTask;
import AdminCES_Script2.tester.data.TesterData;
import AdminCES_Script2.tester.task.TablaTesterTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EliminarCuentaTesterTest {
    private IBrowser browser;
    private IVerify verify;

    @BeforeEach
    public void setUp() {
        browser = BrowserFactory.getBrowser(false);
        verify = IVerify.create();
        browser.interaction().navigateTo(HomeData.URL_HOME);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder("3)ea60e0be3ba12c6ecd%7297868%5c4");

        HomeTask homeTask = new HomeTask(browser);
        homeTask.irALogin();

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesion(LoginData.CORREO_LOGIN, LoginData.PASSWORD_LOGIN);

        browser.interaction().navigateTo(HomeData.URL_HOME);
    }

    @Test
    public void testEliminarUsuarioTester() {
        HomeTask homeTask = new HomeTask(browser);
        TablaTesterTask usersTask = new TablaTesterTask(browser);

        verify.verifyTrue(homeTask.usuarioLogueado(), HomeData.MENSAJE_ERROR_SESION_NO_INICIADA);

        homeTask.irATablaUsuarios();
        verify.verifyTrue(usersTask.existeUsuarioEnTabla(TesterData.CORREO_ELIMINAR),TesterData.MENSAJE_ERROR_ELIMINAR_TESTER);

        usersTask.eliminarTesterPorCorreo(TesterData.CORREO_ELIMINAR);

        verify.verifyFalse(usersTask.obtenerTextoDeTabla().contains(TesterData.CORREO_ELIMINAR),TesterData.MENSAJE_ERROR_TESTER_AUN_VISIBLE);
    }

    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
