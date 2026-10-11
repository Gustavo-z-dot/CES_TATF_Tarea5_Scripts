package AdminCES_ConTestParametrizados.suites.pruebas.tester;

import AdminCES_ConTestParametrizados.base.BaseTest;
import AdminCES_ConTestParametrizados.home.data.HomeData;
import AdminCES_ConTestParametrizados.home.task.HomeTask;
import AdminCES_ConTestParametrizados.login.data.LoginData;
import AdminCES_ConTestParametrizados.login.task.AccessTask;
import AdminCES_ConTestParametrizados.login.task.LoginTask;
import AdminCES_ConTestParametrizados.tester.data.TesterData;
import AdminCES_ConTestParametrizados.tester.task.RegistrarTesterTask;
import AdminCES_ConTestParametrizados.tester.task.TablaTesterTask;
import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearCuentaTesterTest extends BaseTest {

    @BeforeEach
    public void beforeEach() {
        loginComoAdmin();
    }
    @Tag("modulo-tester")
    @Tag("alta-usuario")
    @Tag("regresion")
    @Tag("humo")
    @ParameterizedTest(name = "Crear Tester #{index} {0} {1}")
    @CsvFileSource(resources = "/datos_alta.csv", useHeadersInDisplayName = true)
    public void testCrearUsuarioTester(String nombre, String apellido, String correo, String pais, String contrasenia) {
        HomeTask homeTask = new HomeTask(browser);
        RegistrarTesterTask registrarTesterTask = new RegistrarTesterTask(browser);
        TablaTesterTask usersTask = new TablaTesterTask(browser);

        verify.verifyTrue(homeTask.usuarioLogueado(), HomeData.MENSAJE_ERROR_SESION_NO_INICIADA);
        homeTask.irAFormularioCrearTester();
        verify.verifyTrue(registrarTesterTask.verificarTitulo(TesterData.TITULO_FORMULARIO), TesterData.MENSAJE_ERROR_FORMULARIO);
        registrarTesterTask.registrarTester(
                nombre,
                apellido,
                correo,
                pais,
                contrasenia
        );

        browser.interaction().navigateTo(HomeData.URL_HOME);
        homeTask.irATablaUsuarios();
        verify.verifyTrue( usersTask.existeUsuarioEnTabla(correo), TesterData.MENSAJE_ERROR_TABLA);
    }

}
