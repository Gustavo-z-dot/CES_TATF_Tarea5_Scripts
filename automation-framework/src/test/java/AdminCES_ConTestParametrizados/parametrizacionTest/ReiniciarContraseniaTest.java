package AdminCES_ConTestParametrizados.parametrizacionTest;

import AdminCES_ConTestParametrizados.home.data.HomeData;
import AdminCES_ConTestParametrizados.home.task.HomeTask;
import AdminCES_ConTestParametrizados.login.data.LoginData;
import AdminCES_ConTestParametrizados.login.task.AccessTask;
import AdminCES_ConTestParametrizados.login.task.LoginTask;
import AdminCES_ConTestParametrizados.reset.data.ResetData;
import AdminCES_ConTestParametrizados.reset.task.ResetPasswordTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ReiniciarContraseniaTest {
    private IBrowser browser;
    private IVerify verify;

    @BeforeEach
    public void beforeEach() {
        browser = BrowserFactory.getBrowser();
        verify = IVerify.create();
        browser.interaction().navigateTo(HomeData.URL_HOME);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(LoginData.HASH);
    }

    @ParameterizedTest(name = "Reiniciar Contraseña #{index} {0}")
    @CsvSource({
            "leonardoperez@gmail.com, 1234",
            "yaniscorrea@gmail.com, 123"
    })
    public void testReiniciarContrasenia(String correo, String nuevaContrasenia) {
        ResetPasswordTask resetPasswordTask = new ResetPasswordTask(browser);
        HomeTask homeTask = new HomeTask(browser);
        LoginTask loginTask = new LoginTask(browser);

        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_ERROR_SESION_INICIADA);

        homeTask.irAReiniciarContrasenia();
        verify.verifyTrue(resetPasswordTask.verificarTitulo(ResetData.TITULO_FORMULARIO),ResetData.MENSAJE_ERROR_FORMULARIO);
        resetPasswordTask.reiniciarContrasenia(
                correo,
                nuevaContrasenia,
                nuevaContrasenia
        );
        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_REDIRECCION_ERROR);

        browser.interaction().navigateTo(HomeData.URL_HOME);

        homeTask.irALogin();
        verify.verifyTrue(loginTask.verificarTitulo(LoginData.TITULO),LoginData.MENSAJE_ERROR_LOGIN);
        loginTask.iniciarSesion(correo, nuevaContrasenia);
        verify.verifyTrue(homeTask.usuarioLogueado(),HomeData.MENSAJE_ERROR_USUARIO_NO_LOGUEADO);
    }

    @AfterEach
    public void afterEach() {
        BrowserFactory.quitBrowser();
    }
}
