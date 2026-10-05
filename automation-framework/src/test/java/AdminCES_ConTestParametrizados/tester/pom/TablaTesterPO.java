package AdminCES_ConTestParametrizados.tester.pom;

import com.tatf.core.browser.IBrowser;

public class TablaTesterPO {

    private final IBrowser browser;

    private final String tablaUsuarios = "bodyTable";
    private final String btnConfirmarAlerta = "button.swal2-confirm";

    public TablaTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public boolean testerVisible(String correo) {
        return this.browser.find().id(correo).isDisplayed();
    }

    public String obtenerContenidoTabla() {
        return this.browser.find().id(this.tablaUsuarios).getText();
    }

    public void clickEliminarTester(String correo) {
        this.browser.find().id(correo).click();
    }

    public void confirmarEliminacion() {
        this.browser.find().css(this.btnConfirmarAlerta).click();
    }

}
