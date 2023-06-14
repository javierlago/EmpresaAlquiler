package CreacionFicheros;

import EmpresaColeccion.Empresa;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ListadoEmpresas {
    @Expose
    private List<Empresa> ListadoEmpresas = new ArrayList<>();

    public ListadoEmpresas(){super();}

    public void setListadoEmpresas(List<Empresa> listadoEmpresas) {
        ListadoEmpresas = listadoEmpresas;
    }

    public void add(Empresa empresa){ListadoEmpresas.add(empresa);}

    public List<Empresa> getList(){return ListadoEmpresas;}

}
