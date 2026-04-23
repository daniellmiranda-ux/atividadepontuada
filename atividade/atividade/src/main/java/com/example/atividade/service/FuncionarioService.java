import com.example.atividade.model.FuncionarioModel;
import com.example.atividade.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService{

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioModel salvar(FuncionarioModel f){
        if(repository.findByEmail(f.getEmail()).isPresent()){
            throw new RuntimeException("Funcionário já cadastrado.");
        }
        return repository.save(f);
    }

    public List<FuncionarioModel> listar(){
        return repository.findAll();
    }

    public FuncionarioModel atualizar(Long id, FuncionarioModel f){
        if(!repository.existsById(id)){
            throw new RuntimeException("Funcionário não encontrado.");
        }
        f.setId(id);
        return repository.save(f);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Funcionário não encontrado.");
        }
        repository.deleteById(id);
    }
}
