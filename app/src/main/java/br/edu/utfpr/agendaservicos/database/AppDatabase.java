package br.edu.utfpr.agendaservicos.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.edu.utfpr.agendaservicos.model.ServicoTipo;
// Vamos adicionar mais entidades depois, como Agendamento, ServicoContratado, Pagamento

import br.edu.utfpr.agendaservicos.dao.ServicoTipoDao;

@Database(
        entities = {ServicoTipo.class}, // ← por enquanto só temos essa
        version = 1
)
public abstract class AppDatabase extends RoomDatabase{

    // Defina aqui os DAOs que serão usados na aplicação
    public abstract ServicoTipoDao servicoTipoDao();

    // Outros DAOs virão depois, como:
    // public abstract AgendamentoDao agendamentoDao();
    // public abstract PagamentoDao pagamentoDao();

}
