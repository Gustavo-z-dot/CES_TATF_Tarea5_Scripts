package AdminCES_Script2.test;

import AdminCES_Script2.admin.data.AdminData;
import AdminCES_Script2.admin.task.RegistrarAdminTask;
import AdminCES_Script2.home.data.HomeData;
import AdminCES_Script2.home.task.HomeTask;
import AdminCES_Script2.login.data.LoginData;
import AdminCES_Script2.login.task.AccessTask;
import AdminCES_Script2.login.task.LoginTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdminTest {
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
    public void testCrearCuentaAdmin() {
        HomeTask homeTask = new HomeTask(browser);
        RegistrarAdminTask registrarAdminTask = new RegistrarAdminTask(browser);
        LoginTask loginTask = new LoginTask(browser);

        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_ERROR_SESION_INICIADA);
        homeTask.irAFormularioCrearAdmin();
        verify.verifyTrue(registrarAdminTask.verificarTexto(AdminData.TITULO_FORMULARIO), AdminData.MENSAJE_FORMULARIO_ERROR);
        registrarAdminTask.registrarAdministrador(
                AdminData.NOMBRE,
                AdminData.APELLIDO,
                AdminData.CORREO,
                AdminData.CONTRASENIA,
                AdminData.CONTRASENIA,
                AdminData.PAIS_NACIMIENTO
        );
        verify.verifyTrue(homeTask.usuarioSinSesion(), HomeData.MENSAJE_REDIRECCION_ERROR);

        browser.interaction().navigateTo(HomeData.URL_HOME);

        homeTask.irALogin();
        verify.verifyTrue(loginTask.verificarTitulo(LoginData.TITULO),LoginData.MENSAJE_ERROR_LOGIN);
        loginTask.iniciarSesion(AdminData.CORREO, AdminData.CONTRASENIA);
        verify.verifyTrue(homeTask.usuarioLogueado(),HomeData.MENSAJE_ERROR_USUARIO_NO_LOGUEADO);
    }

    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
