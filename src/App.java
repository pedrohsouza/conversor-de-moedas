import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            System.out.println("Não foi possível alterar a L&F");
        }

        JFrame f = new JFrame();

        int continuar = 0;

        double valor = 0;
        boolean valorEhValido;
        double valorConvertido;

        String selecao;
        String[] opcoes = {
                "De Reais a Dólares",
                "De Reais a Euros",
                "De Reais a Libras",
                "De Reais a Yenes",
                "De Reais a Won Coreano",
                "De Dólares a Reais",
                "De Euros a Reais",
                "De Libras a Reais",
                "De Yenes a Reais",
                "De Won coreano a Reais"
        };

        while (continuar == 0) {

            do {
                try {
                    valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Insira um Valor"));
                    valorEhValido = true;
                } catch (Exception _) {
                    JOptionPane.showMessageDialog(f, "Valor inválido");
                    valorEhValido = false;
                }

                if (valor < 0) {
                    JOptionPane.showMessageDialog(f, "Valor inválido");
                    valorEhValido = false;
                }

            } while (!valorEhValido);

            selecao = (String) JOptionPane.showInputDialog(
                    f,
                    "Escolha a moeda para a qual você deseja converter o seu dinheiro",
                    "Moedas",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            double fatorCoversao = 4.97;

            if (selecao == opcoes[0] || selecao == opcoes[5]) {
                fatorCoversao = 4.97;
            } else if (selecao == opcoes[1] || selecao == opcoes[6]) {
                fatorCoversao = 5.36;
            } else if (selecao == opcoes[2] || selecao == opcoes[7]) {
                fatorCoversao = 6.27;
            } else if (selecao == opcoes[3] || selecao == opcoes[8]) {
                fatorCoversao = 0.033;
            } else if (selecao == opcoes[4] || selecao == opcoes[9]) {
                fatorCoversao = 0.0037;
            }

            if (selecao == opcoes[0] || selecao == opcoes[1] || selecao == opcoes[2] || selecao == opcoes[3]
                    || selecao == opcoes[4]) {
                valorConvertido = valor / fatorCoversao;
            } else {
                valorConvertido = valor * fatorCoversao;
            }

            JOptionPane.showMessageDialog(f, "O valor convertido é de R$" + valorConvertido);

            continuar = JOptionPane.showConfirmDialog(f, "Deseja continuar?");

            if (continuar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(f, "Programa finalizado");
            } else if (continuar == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(f, "Programa concluído");
            }
        }

        f.dispose();
    }
}
