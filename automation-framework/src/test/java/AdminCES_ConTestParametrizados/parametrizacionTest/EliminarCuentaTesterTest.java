package AdminCES_ConTestParametrizados.parametrizacionTest;

import AdminCES_ConTestParametrizados.home.data.HomeData;
import AdminCES_ConTestParametrizados.home.task.HomeTask;
import AdminCES_ConTestParametrizados.login.data.LoginData;
import AdminCES_ConTestParametrizados.login.task.AccessTask;
import AdminCES_ConTestParametrizados.login.task.LoginTask;
import AdminCES_ConTestParametrizados.tester.data.TesterData;
import AdminCES_ConTestParametrizados.tester.task.TablaTesterTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EliminarCuentaTesterTest {
    private IBrowser browser;
    private IVerify verify;

    @BeforeEach
    public void beforeEach() {
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        browser.interaction().navigateTo(HomeData.URL_HOME);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(LoginData.HASH);

        HomeTask homeTask = new HomeTask(browser);
        homeTask.irALogin();

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesion(LoginData.CORREO_LOGIN, LoginData.PASSWORD_LOGIN);

        browser.interaction().navigateTo(HomeData.URL_HOME);
    }

    @ParameterizedTest(name="Eliminar Tester #{index} {0}")
    @ValueSource(strings = {"nahuel@gmail.com", "mariana@gmail.com", "dardo@gmail.com"})
    public void testEliminarUsuarioTester(String correo) {
        HomeTask homeTask = new HomeTask(browser);
        TablaTesterTask usersTask = new TablaTesterTask(browser);

        verify.verifyTrue(homeTask.usuarioLogueado(), HomeData.MENSAJE_ERROR_SESION_NO_INICIADA);

        homeTask.irATablaUsuarios();
        verify.verifyTrue(usersTask.existeUsuarioEnTabla(correo), TesterData.MENSAJE_ERROR_ELIMINAR_TESTER);
        usersTask.eliminarTesterPorCorreo(correo);

        verify.verifyFalse(usersTask.obtenerTextoDeTabla().contains(correo), TesterData.MENSAJE_ERROR_TESTER_AUN_VISIBLE);    }

    @AfterEach
    public void afterEach() {
        BrowserFactory.quitBrowser();
    }
}
