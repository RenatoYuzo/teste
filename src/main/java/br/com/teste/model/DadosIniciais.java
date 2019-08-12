package br.com.teste.model;

public class DadosIniciais {

    private String login;
    private String senha;
    private boolean salvarSenha;
    private String versao;
    private String site;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isSalvarSenha() {
        return salvarSenha;
    }

    public void setSalvarSenha(boolean salvarSenha) {
        this.salvarSenha = salvarSenha;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "DadosIniciais{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", salvarSenha=" + salvarSenha +
                ", versao='" + versao + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}

