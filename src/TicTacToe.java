import javax.swing.JFrame;
public class TicTacToe {
    public static void main(String[] args) {
        JFrame tictactoe=new TicTacToeFrame();
        tictactoe.setTitle("WELCOME GOOD PEOPLE !");
        tictactoe.setSize(600,600);
        tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tictactoe.setLocationRelativeTo(null);
        tictactoe.setVisible(true);
    }
}