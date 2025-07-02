package br.edu.utfpr.agendaservicos.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

import br.edu.utfpr.agendaservicos.model.ServicoTipo;

@Dao
public interface ServicoTipoDao {

    @Insert
    void inserir(ServicoTipo servicoTipo);

    @Update
    void atualizar(ServicoTipo servicoTipo);

    @Delete
    void excluir(ServicoTipo servicoTipo);

    @Query("SELECT * FROM servicoTipo ORDER BY nome ASC")
    List<ServicoTipo> listarTodos();

    @Query("SELECT * FROM servicoTipo WHERE id = :id")
    ServicoTipo buscarPorId(int id);

}
