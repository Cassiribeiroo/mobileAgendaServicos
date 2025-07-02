package br.edu.utfpr.agendaservicos.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "servico_contratado")
public class ServicoContratado {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int agendamentoId; // chave estrangeira
    public int servicoTipoId; // chave estrangeira
    public double quantidade;
    public double valorCalculado;
    public boolean executado; // se o serviço foi feito
    public boolean recebido;  // se o serviço foi pago

}
