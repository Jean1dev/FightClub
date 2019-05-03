package testes;

import android.content.Context;

import java.util.List;

import database.model.Persistence.UsuarioPersistence;
import database.model.Usuario;


public class UnitTests {

    private Context _context;

    public UnitTests(Context _context) {
        this._context = _context;
    }

    public boolean test_insert_usuario(){
        UsuarioPersistence dao = new UsuarioPersistence(_context);
        Usuario model =  new Usuario();
        model.setSobrenome("teste");
        model.setNome("oe");
        if(dao.insert(model) >= 1){
            return true;
        }
        return false;
    }

    public boolean test_getall_usuario(){
        UsuarioPersistence dao = new UsuarioPersistence(_context);
        final List<Usuario> all = dao.getAll();
        if(all != null){
            return true;
        }
        return false;
    }
}
