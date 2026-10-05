package AdminCES_ConTestParametrizados.admin.task;

import AdminCES_ConTestParametrizados.admin.pom.RegistrarAdminPO;
import com.tatf.core.browser.IBrowser;

public class RegistrarAdminTask {

    private final RegistrarAdminPO registrarAdminPO;

    public RegistrarAdminTask(IBrowser browser) {
        this.registrarAdminPO=new RegistrarAdminPO(browser);
    }

    public boolean verificarTexto(String texto){
        return this.registrarAdminPO.verificarTexto(texto);
    }

    public void registrarAdministrador(String nombre, String apellido, String email, String contrasenia, String repContrasenia, String pais) {
        this.registrarAdminPO.ingresarNombre(nombre);
        this.registrarAdminPO.ingresarApellido(apellido);
        this.registrarAdminPO.ingresarEmail(email);
        this.registrarAdminPO.ingresarPassword(contrasenia);
        this.registrarAdminPO.ingresarRepeatPassword(repContrasenia);
        this.registrarAdminPO.ingresarPais(pais);
        this.registrarAdminPO.clickRegistrar();
        this.registrarAdminPO.confirmarAlerta();
    }
}
