package AdminCES_Script2.home.task;

import AdminCES_Script2.home.pom.HomePO;
import com.tatf.core.browser.IBrowser;

public class HomeTask {
    private final HomePO homePO;

    public HomeTask(IBrowser browser) {
        this.homePO = new HomePO(browser);
    }

    public boolean usuarioLogueado() {
        return this.homePO.usuarioLogueado();
    }

    public boolean usuarioSinSesion() {
        return this.homePO.usuarioNoLogueado();
    }

    public void irAFormularioCrearAdmin() {
        this.homePO.clickIrACrearAdmin();
    }

    public void irAFormularioCrearTester() {
        this.homePO.clickIrACrearTester();
    }

    public void irATablaUsuarios() {
        this.homePO.clickIrAVerUsuarios();
    }

    public void irAReiniciarContrasenia() {
        this.homePO.clickIrAReiniciarContrasenia();
    }

    public void irALogin() {
        this.homePO.clickIrALogin();
    }

}
