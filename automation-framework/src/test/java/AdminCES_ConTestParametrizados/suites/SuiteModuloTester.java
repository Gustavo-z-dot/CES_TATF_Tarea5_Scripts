package AdminCES_ConTestParametrizados.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite de modulo Tester")
@SelectPackages("AdminCES_ConTestParametrizados.suites.pruebas.tester")
@IncludeTags("modulo-tester")
public class SuiteModuloTester {
}
