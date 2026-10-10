package AdminCES_ConTestParametrizados.suites;


import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Suite de Regresión")
@SelectPackages("AdminCES_ConTestParametrizados.suites.pruebas")
@IncludeTags("regresion")
@ExcludeTags("debug")
public class SuiteRegresion {
}
