package AdminCES_ConTestParametrizados.login.task;

import AdminCES_ConTestParametrizados.login.pom.LoginPO;
import com.tatf.core.browser.IBrowser;

public class LoginTask {
    private final LoginPO loginPO;

    public LoginTask(IBrowser browser) {
        this.loginPO= new LoginPO(browser);
    }

    public void iniciarSesion(String email, String contrasenia) {
        this.loginPO.ingresarEmail(email);
        this.loginPO.ingresarContrasenia(contrasenia);
        this.loginPO.clickIngresar();
    }
    public boolean verificarTitulo(String titulo) {
        return this.loginPO.tituloVisible(titulo);
    }

}
