package AdminCES_Script2.tester.task;

import AdminCES_Script2.tester.pom.TablaTesterPO;
import com.tatf.core.browser.IBrowser;

public class TablaTesterTask {

    private final TablaTesterPO usersPO;


    public TablaTesterTask(IBrowser browser) {
        this.usersPO = new TablaTesterPO(browser);
    }

    public void eliminarTesterPorCorreo(String correo) {
        this.usersPO.clickEliminarTester(correo);
        this.usersPO.confirmarEliminacion();
    }

    public boolean existeUsuarioEnTabla(String correo) {
        return this.usersPO.testerVisible(correo);
    }

    public String obtenerTextoDeTabla() {
        return this.usersPO.obtenerContenidoTabla();
    }
}
