package AdminCES_Script2.tester.task;

import AdminCES_Script2.tester.pom.RegistrarTesterPO;
import com.tatf.core.browser.IBrowser;

public class RegistrarTesterTask {

    private final RegistrarTesterPO registrarTesterPO;

    public RegistrarTesterTask(IBrowser browser) {
        this.registrarTesterPO = new RegistrarTesterPO(browser);
    }

    public void registrarTester(String nombre, String apellido, String email, String pais, String contrasenia) {
        this.registrarTesterPO.ingresarNombre(nombre);
        this.registrarTesterPO.ingresarApellido(apellido);
        this.registrarTesterPO.ingresarEmail(email);
        this.registrarTesterPO.ingresarPais(pais);
        this.registrarTesterPO.ingresarContrasenia(contrasenia);
        this.registrarTesterPO.seleccionarTipoTester();
        this.registrarTesterPO.clickRegistrar();
        this.registrarTesterPO.confirmarAlerta();
    }

    public boolean verificarTitulo(String titulo) {
        return this.registrarTesterPO.tituloVisible(titulo);
    }
}
