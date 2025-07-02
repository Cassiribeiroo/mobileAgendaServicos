package br.edu.utfpr.agendaservicos.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.edu.utfpr.agendaservicos.dao.AgendamentoDao;
import br.edu.utfpr.agendaservicos.dao.PagamentoDao;
import br.edu.utfpr.agendaservicos.dao.ServicoContratadoDao;
import br.edu.utfpr.agendaservicos.model.Agendamento;
import br.edu.utfpr.agendaservicos.model.Pagamento;
import br.edu.utfpr.agendaservicos.model.ServicoContratado;
import br.edu.utfpr.agendaservicos.model.ServicoTipo;
import br.edu.utfpr.agendaservicos.dao.ServicoTipoDao;

@Database(
        entities = {
                ServicoTipo.class,
                Agendamento.class,
                ServicoContratado.class,
                Pagamento.class
        }, version = 2
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase{

    // Defina aqui os DAOs que serão usados na aplicação
    public abstract ServicoTipoDao servicoTipoDao();
    public abstract AgendamentoDao agendamentoDao();
    public abstract ServicoContratadoDao servicoContratadoDao();
    public abstract PagamentoDao pagamentoDao();

}
