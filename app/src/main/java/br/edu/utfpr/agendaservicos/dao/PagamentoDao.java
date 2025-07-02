package br.edu.utfpr.agendaservicos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.edu.utfpr.agendaservicos.model.Pagamento;

@Dao
public interface PagamentoDao {
    @Insert
    void inserir(Pagamento pagamento);

    @Delete
    void deletar(Pagamento pagamento);

    @Query("SELECT * FROM pagamento WHERE agendamentoId = :agendamentoId")
    List<Pagamento> listarPorAgendamento(long agendamentoId);

    @Query("SELECT * FROM pagamento WHERE id = :id")
    Pagamento buscarPorId(long id);
}
