package br.edu.utfpr.agendaservicos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

import br.edu.utfpr.agendaservicos.model.Agendamento;

@Dao
public interface AgendamentoDao {
    @Insert
    long inserir(Agendamento agendamento);

    @Update
    void atualizar(Agendamento agendamento);

    @Delete
    void deletar(Agendamento agendamento);

    @Query("SELECT * FROM agendamento ORDER BY dataHora ASC")
    List<Agendamento> listarTodos();

    @Query("SELECT * FROM agendamento WHERE dataHora BETWEEN :inicio AND :fim ORDER BY dataHora ASC")
    List<Agendamento> listarPorIntervalo(Date inicio, Date fim);

    @Query("SELECT * FROM agendamento WHERE id = :id")
    Agendamento buscarPorId(long id);
}
