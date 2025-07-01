package br.edu.utfpr.agendaservicos.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import br.edu.utfpr.agendaservicos.R;
import br.edu.utfpr.agendaservicos.database.AppDatabase;
import br.edu.utfpr.agendaservicos.model.ServicoTipo;
import br.edu.utfpr.agendaservicos.dao.ServicoTipoDao;

public class ServicoTipoActivity extends AppCompatActivity{

    private EditText editTextNome, editTextUnidade, editTextValor;
    private Button buttonSalvar;
    private ListView listViewServicos;

    private AppDatabase db;
    private ServicoTipoDao servicoTipoDao;
    private ArrayAdapter<String> adapter;
    private List<ServicoTipo> listaServicos;
    private int editandoId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_tipo);

        // Liga os componentes do layout
        editTextNome = findViewById(R.id.editTextNome);
        editTextUnidade = findViewById(R.id.editTextUnidade);
        editTextValor = findViewById(R.id.editTextValor);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(v -> finish());
        listViewServicos = findViewById(R.id.listViewServicos);

        // Inicializa o banco de dados e o DAO
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                "servicos-db").allowMainThreadQueries().build();

        servicoTipoDao = db.servicoTipoDao();

        // Carrega e exibe a lista
        atualizarLista();

        // Clique curto para editar
        listViewServicos.setOnItemClickListener((parent, view, position, id) -> {
            ServicoTipo servico = listaServicos.get(position);
            editTextNome.setText(servico.getNome());
            editTextUnidade.setText(servico.getUnidade());
            editTextValor.setText(String.valueOf(servico.getValor()));
            editandoId = servico.getId();
        });

        // Clique longo para excluir
        listViewServicos.setOnItemLongClickListener((parent, view, position, id) -> {
            ServicoTipo servico = listaServicos.get(position);

            new android.app.AlertDialog.Builder(this)
                    .setTitle("Confirmar exclusão")
                    .setMessage("Deseja realmente excluir o serviço \"" + servico.getNome() + "\"?")
                    .setPositiveButton("Sim", (dialog, which) -> {
                        servicoTipoDao.excluir(servico);
                        Toast.makeText(this, "Serviço \"" + servico.getNome() + "\" excluído", Toast.LENGTH_SHORT).show();
                        atualizarLista();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();

            return true;
        });


        // Ação do botão Salvar
        buttonSalvar.setOnClickListener(v -> salvarServico());
    }

    private void salvarServico() {
        String nome = editTextNome.getText().toString().trim();
        String unidade = editTextUnidade.getText().toString().trim();
        String valorStr = editTextValor.getText().toString().trim();

        if (nome.isEmpty() || unidade.isEmpty() || valorStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor;
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        ServicoTipo servico = new ServicoTipo(nome, unidade, valor);

        if (editandoId == -1) {
            // Novo serviço
            servicoTipoDao.inserir(servico);
            Toast.makeText(this, "Serviço salvo com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            // Atualização
            servico.setId(editandoId);
            servicoTipoDao.atualizar(servico);
            Toast.makeText(this, "Serviço atualizado com sucesso", Toast.LENGTH_SHORT).show();
            editandoId = -1; // Resetar após edição
        }

        // Limpa os campos
        editTextNome.setText("");
        editTextUnidade.setText("");
        editTextValor.setText("");

        // Atualiza a lista
        atualizarLista();
    }

    private void atualizarLista() {
        listaServicos = servicoTipoDao.listarTodos();

        List<String> listaFormatada = new java.util.ArrayList<>();
        for (ServicoTipo s : listaServicos) {
            String linha = s.getNome() + " (" + s.getUnidade() + ") - R$ " + s.getValor();
            listaFormatada.add(linha);
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listaFormatada);

        listViewServicos.setAdapter(adapter);
    }
}
