package AdminCES_Script2.test;

import AdminCES_Script2.admin.data.AdminData;
import AdminCES_Script2.home.data.HomeData;
import AdminCES_Script2.home.task.HomeTask;
import AdminCES_Script2.login.data.LoginData;
import AdminCES_Script2.login.task.AccessTask;
import AdminCES_Script2.login.task.LoginTask;
import AdminCES_Script2.reset.data.ResetData;
import AdminCES_Script2.reset.task.ResetPasswordTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReiniciarContraseniaTest {
    private IBrowser browser;
    private IVerify verify;

    @BeforeEach
    public void setUp() {
        browser = BrowserFactory.getBrowser(false);
        verify = IVerify.create();
        browser.interaction().navigateTo(HomeData.URL_HOME);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder("3)ea60e0be3ba12c6ecd%7297868%5c4");
    }

    @Test
    public void testReiniciarContrasenia() {
        HomeTask homeTask = new HomeTask(browser);
        ResetPasswordTask resetPasswordTask = new ResetPasswordTask(browser);
        LoginTask loginTask = new LoginTask(browser);

        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_ERROR_SESION_INICIADA);

        homeTask.irAReiniciarContrasenia();
        verify.verifyTrue(resetPasswordTask.verificarTitulo(ResetData.TITULO_FORMULARIO),ResetData.MENSAJE_ERROR_FORMULARIO);
        resetPasswordTask.reiniciarContrasenia(
                ResetData.CORREO,
                ResetData.CONTRASENIA,
                ResetData.CONTRASENIA
        );

        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_REDIRECCION_ERROR);
    }

    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
