package br.ufsm.politecnico.csi.redes.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mensagem {

    private String tipoMensagem;
    private String usuario;
    private String status;
    private String texto;

    public  Mensagem(String usuario, String text) {
        this.usuario = usuario;
        this.texto = text;
    }

    public  Mensagem(String tipoMensagem, String usuario, String status) {
        this.tipoMensagem = tipoMensagem;
        this.usuario = usuario;
        this.status = status;
    }
}