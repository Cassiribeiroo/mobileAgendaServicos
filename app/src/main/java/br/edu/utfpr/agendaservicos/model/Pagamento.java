package br.edu.utfpr.agendaservicos.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "pagamento")
public class Pagamento {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int agendamentoId; // chave estrangeira
    public double valorRecebido;
    public Date dataPagamento;
}
