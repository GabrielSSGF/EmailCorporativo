package com.principal;
import java.util.Scanner;

public class Email {
    private String primeiroNome;
    private String ultimoNome;
    private String senha;
    private String departamento;
    private String email;
    private int capacidadeCaixaEmail = 500;
    private int senhaTamanhoPadrao = 10;
    private String emailAlternativo;
    private String sufixoCompanhia = "companhialunar.com";

    // Construtor pra receber o primeiro e último nome

    public Email (String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;

        // Chama o método perguntando sobre o departamento - retorna o departamento
        this.departamento = ajustaDepartamento();

        // Chama o método que retorna uma senha aleatória
        this.senha = senhaAleatória(senhaTamanhoPadrao);
        System.out.println("\nSua senha é: " + this.senha);

        // Combinar elementos para gerar email
        email = primeiroNome.toLowerCase() + "." + ultimoNome.toLowerCase() + "@" + departamento + "." + sufixoCompanhia;

    }

    // Pergunta qual departamento
    private String ajustaDepartamento() {
        System.out.println("Funcionário novo: " + primeiroNome + ".\n\n CÓDIGO DOS DEPARTAMENTOS\n1 Para vendas\n2 Para desenvolvimento\n3 Para contabilidade\n0 Para outros");
        Scanner em = new Scanner(System.in);
        int depEscolha = em.nextInt();
        if (depEscolha == 1) { return "vendas"; }
        else if (depEscolha == 2) { return "dev"; }
        else if (depEscolha == 3) { return "contb"; }
        else { return "area"; }
    }

    // Gera senha aleatória
    private String senhaAleatória(int tamanho) {
        String ajusteSenha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char senha[] = new char[tamanho];
        for (int i = 0; i<tamanho; i++) {
            int aleatorio = (int) (Math.random() * ajusteSenha.length());
            senha[i] = ajusteSenha.charAt(aleatorio);
        }
        return new String (senha);
    }

    // Ajusta capacidade da caixa de email

    public void ajustaCapacidadeCaixaEmail(int capacidade) {
        this.capacidadeCaixaEmail = capacidade;
    }

    // Ajusta o email alternativo

    public void ajustaEmailAlternativo(String emailAlt) {
        this.emailAlternativo = emailAlt;
    }

    // Muda senha

    public void mudaSenha(String senha) {
        this.senha = senha;
    }

    public int recebeCaixaEmailCapacidade() { return capacidadeCaixaEmail; }
    public String recebeEmailAlternativo() { return emailAlternativo; }
    public String recebeSenha() { return senha; }

    public String mostraInfo() {
        return "NOME EXIBIDO: " + primeiroNome + " " + ultimoNome +
                "\nEMAIL DA COMPANHIA: " + email +
                "\nCAPACIDADE DA CAIXA DE EMAIL: " + capacidadeCaixaEmail + "mb";
    }

}