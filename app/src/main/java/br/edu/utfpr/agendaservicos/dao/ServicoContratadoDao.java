package br.edu.utfpr.agendaservicos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.utfpr.agendaservicos.model.ServicoContratado;

@Dao
public interface ServicoContratadoDao {
    @Insert
    void inserir(ServicoContratado servico);

    @Update
    void atualizar(ServicoContratado servico);

    @Delete
    void excluir(ServicoContratado servico);

    @Query("SELECT * FROM servico_contratado WHERE agendamentoId = :agendamentoId")
    List<ServicoContratado> listarPorAgendamento(long agendamentoId);

    @Query("SELECT * FROM servico_contratado WHERE id = :id")
    ServicoContratado buscarPorId(long id);

}
