package br.edu.utfpr.agendaservicos.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "agendamento")
public class Agendamento {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nomeCliente;
    public String endereco;
    public String telefone;
    public long dataHora; // armazenado como timestamp
}
