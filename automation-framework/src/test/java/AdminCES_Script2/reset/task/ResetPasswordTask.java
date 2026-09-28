package AdminCES_Script2.reset.task;

import AdminCES_Script2.reset.pom.ResetPasswordPO;
import com.tatf.core.browser.IBrowser;

public class ResetPasswordTask {

    private final ResetPasswordPO resetPasswordPO;

    public ResetPasswordTask(IBrowser browser) {
        this.resetPasswordPO = new ResetPasswordPO(browser);
    }

    public boolean verificarTitulo(String titulo) {
        return this.resetPasswordPO.verificarTexto(titulo);
    }

    public void reiniciarContrasenia(String email, String contrasenia, String repContrasenia) {
        this.resetPasswordPO.ingresarEmail(email);
        this.resetPasswordPO.ingresarContraenia(contrasenia);
        this.resetPasswordPO.confirmarContrasenia(repContrasenia);
        this.resetPasswordPO.clickReiniciarContrasenia();
        this.resetPasswordPO.confirmarAlerta();
    }
}
