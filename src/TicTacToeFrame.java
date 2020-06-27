import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class TicTacToeFrame extends JFrame {
    private char whoseTurn='X';
    private Cell[][] cells=new Cell[3][3];
    JLabel status=new JLabel("X's Turn To Play");
    TicTacToeFrame(){
        JPanel panel=new JPanel(new GridLayout(3,3,1,1));
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                cells[i][j]=new Cell();
                panel.add( cells[i][j] );
            }
        }
        panel.setBorder( new LineBorder(Color.red,1) );
        status.setBorder( new LineBorder(Color.yellow,1) );
        this.add(panel,BorderLayout.CENTER);
        this.add(status,BorderLayout.NORTH);
    }
    public boolean isFull(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(cells[i][j].getToken()==' ')
                    return false;
            }
        }
        return true;
    }
    public boolean isWon(char token){
        for(int i=0; i<3; i++){
            if(cells[i][0].getToken()==token && cells[i][1].getToken()==token && cells[i][2].getToken()==token)
                return true;
        }
        for(int i=0; i<3; i++){
            if(cells[0][i].getToken()==token && cells[1][i].getToken()==token && cells[2][i].getToken()==token)
                return true;
        }
        if(cells[0][0].getToken()==token && cells[1][1].getToken()==token && cells[2][2].getToken()==token)
            return true;
        if(cells[0][2].getToken()==token && cells[1][1].getToken()==token && cells[2][0].getToken()==token)
            return true;
        return false;
    }
    public class Cell extends JPanel {
        private char token=' ';
        private boolean gameover=false;
        Cell(){
            this.setBorder(new LineBorder(Color.BLACK,1));
            this.addMouseListener(new MouseListener());
        }
        public char getToken(){
            return token;
        }
        public void setToken(char c){
            token=c;
            this.repaint();
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if(token=='X'){
                g.drawLine(10, 10, getWidth()-10, getHeight()-10);
                g.drawLine(getWidth()-10, 10, 10, getHeight()-10);
            }
            else if(token=='O'){
                g.drawOval(10, 10, getWidth()-20, getHeight()-20);
            }
        }
        private class MouseListener extends MouseAdapter{
            @Override
            public void mouseClicked(MouseEvent e){
                if(gameover==true) return;
                if(token==' ' && whoseTurn!=' '){
                    setToken(whoseTurn);
                }
                if(isWon(whoseTurn)==true){
                    status.setText(whoseTurn+" WON. . .");
                    whoseTurn=' ';
                    gameover=true;
                    return;
                }
                if(isFull()==true){
                    status.setText("TIE! TIE! TIE!");
                    whoseTurn=' ';
                    gameover=true;
                    return;
                }
                whoseTurn = whoseTurn=='X'? 'O':'X';
                status.setText(whoseTurn+"'s turn");
            }
        }
    }
}
