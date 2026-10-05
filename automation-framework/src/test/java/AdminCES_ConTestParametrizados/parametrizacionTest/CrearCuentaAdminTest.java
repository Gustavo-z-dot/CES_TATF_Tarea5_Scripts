package AdminCES_ConTestParametrizados.parametrizacionTest;

import AdminCES_ConTestParametrizados.admin.data.AdminData;
import AdminCES_ConTestParametrizados.admin.task.RegistrarAdminTask;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearCuentaAdminTest {
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

    @ParameterizedTest(name = "Crear Admin #{index} {0} {1}")
    @CsvFileSource(resources = "/datos_alta.csv", useHeadersInDisplayName = true)
    public void testCrearCuentaAdmin(String nombre, String apellido, String correo, String pais, String contrasenia) {
        HomeTask homeTask = new HomeTask(browser);
        RegistrarAdminTask registrarAdminTask = new RegistrarAdminTask(browser);
        LoginTask loginTask = new LoginTask(browser);

        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_ERROR_SESION_INICIADA);
        homeTask.irAFormularioCrearAdmin();
        verify.verifyTrue(registrarAdminTask.verificarTexto(AdminData.TITULO_FORMULARIO), AdminData.MENSAJE_FORMULARIO_ERROR);
        registrarAdminTask.registrarAdministrador(
                nombre,
                apellido,
                correo,
                contrasenia,
                contrasenia,
                pais
        );
        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_REDIRECCION_ERROR);

        browser.interaction().navigateTo(HomeData.URL_HOME);

        homeTask.irALogin();
        verify.verifyTrue(loginTask.verificarTitulo(LoginData.TITULO),LoginData.MENSAJE_ERROR_LOGIN);
        loginTask.iniciarSesion(correo, contrasenia);
        verify.verifyTrue(homeTask.usuarioLogueado(),HomeData.MENSAJE_ERROR_USUARIO_NO_LOGUEADO);
    }

    @AfterEach
    public void afterEach() {
        BrowserFactory.quitBrowser();
    }
}
