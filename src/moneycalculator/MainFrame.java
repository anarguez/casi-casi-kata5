package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MainFrame extends JFrame{
    
    private MoneyDisplay moneyDisplay;
    
    public MainFrame(){
        setTitle("Money Calculator");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setMenuBar(menuBar());
        setLayout(new BorderLayout());
        add(moneyDisplay());
        moneyDisplay.show(new Money(300, new Currency("USD", "Dolar", "$")));    
    }

    private MenuBar menuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.add(calculateMenu());
        return menuBar;
    }

    private Menu calculateMenu() {
        Menu menu = new Menu("Calculator");
        menu.add(calculateMenuItem());
        return menu;
    }

    private MenuItem calculateMenuItem() {
        MenuItem menuItem = new MenuItem("Calculate");
        menuItem.addActionListener(executeCalculate());
        return menuItem;
    }

    private ActionListener executeCalculate() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Excecute calculate....");
            }
        };
    }

    private JPanel moneyDisplay() {
        SwingMoneyDisplay result = new SwingMoneyDisplay();
        this.moneyDisplay = result;
        return result;
    }
    
    private JLabel label(String value) {
        return new JLabel(value);
    }
    
}
