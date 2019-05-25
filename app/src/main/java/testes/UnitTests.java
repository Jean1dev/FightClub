package testes;

import android.content.Context;

import com.voador.guardeiro.flightclub.infrastructure.repositories.UsuarioRepository;
import com.voador.guardeiro.flightclub.models.Usuario;

import java.util.List;


public class UnitTests {

    private Context _context;

    public UnitTests(Context _context) {
        this._context = _context;
    }

    public boolean test_insert_usuario(){
        UsuarioRepository dao = new UsuarioRepository(_context);
        Usuario model =  new Usuario();
        model.setSobrenome("teste");
        model.setNome("oe");
        if(dao.insert(model) >= 1){
            return true;
        }
        return false;
    }

    public boolean test_getall_usuario(){
        UsuarioRepository dao = new UsuarioRepository(_context);
        final List<Usuario> all = dao.getAll();
        if(all != null){
            return true;
        }
        return false;
    }
}
