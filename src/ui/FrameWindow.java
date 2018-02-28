package ui;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import phone.Cellphone;
import phone.Inventory;

public class FrameWindow implements ActionListener
{

	private JFrame frame;
	private JPanel buttonPane, fieldsPanel, labelsPanel, NorthPanel, listPanel;
	private JLabel productIdLabel, nameLabel, modelLabel, serialnumberLabel, priceLabel;
	private JTextField fldProductId, fldName, fldModel, fldSerialnumber, fldPrice;
	private JButton btnKnapp1, btnKnapp2, btnKnapp3, btnKnapp4;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private JLabel labelInfo;
	private JScrollPane scroll;

	// Statisk TreeMap




	public FrameWindow() {
	}

	TreeMap<String, String> hm = new TreeMap<String, String>();
	Inventory cellphoneCatalog = new Inventory();
	JTextArea display = new JTextArea ( 20, 30 );

	/**
	 * @wbp.parser.entryPoint
	 */
	public void runUI() {
		this.frame = new JFrame("Mobil register");

		//frame = new JFrame("Mobil register");
		frame.setLocation(700, 400);
		frame.setSize(772, 500);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{87, 340, 234, 0};
		gridBagLayout.rowHeights = new int[]{71, 286, 33, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		NorthPanel = new JPanel();
		labelsPanel = new JPanel();
		fieldsPanel = new JPanel();

		NorthPanel.setBorder(null);
		GridBagConstraints gbc_NorthPanel = new GridBagConstraints();
		gbc_NorthPanel.insets = new Insets(0, 0, 5, 5);
		gbc_NorthPanel.gridx = 1;
		gbc_NorthPanel.gridy = 0;
		frame.getContentPane().add(NorthPanel, gbc_NorthPanel);
		NorthPanel.setLayout(new BoxLayout(NorthPanel, BoxLayout.X_AXIS));


		labelInfo = new JLabel("<html> Skapa/Skriv över: Skriv in information för att skapa ny mobil. <br/> Skriv in mobilens namn och tryck radera för att radera. <br/> Skriv in mobilens product ID och tryck på Hitta för att se om mobilen finns. </html> ");
		labelInfo.setAlignmentY(0.3f);
		labelInfo.setVerticalAlignment(SwingConstants.TOP);
		labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		labelsPanel.setBorder(null);
		NorthPanel.add(labelInfo);

		productIdLabel = new JLabel("Product Id:");
		productIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel = new JLabel("Namn:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modelLabel = new JLabel("Model:");
		modelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		serialnumberLabel = new JLabel("Serienummer:");
		serialnumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel = new JLabel("Pris:");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);


		GridLayout gl_labelsPanel = new GridLayout(5,1);
		gl_labelsPanel.setVgap(45);
		labelsPanel.setLayout(gl_labelsPanel);
		labelsPanel.add(productIdLabel);
		labelsPanel.add(nameLabel);
		labelsPanel.add(modelLabel);
		labelsPanel.add(serialnumberLabel);
		labelsPanel.add(priceLabel);
		GridBagConstraints gbc_labelsPanel = new GridBagConstraints();
		gbc_labelsPanel.gridheight = 3;
		gbc_labelsPanel.fill = GridBagConstraints.VERTICAL;
		gbc_labelsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_labelsPanel.gridx = 0;
		gbc_labelsPanel.gridy = 1;
		frame.getContentPane().add(labelsPanel, gbc_labelsPanel);


		fieldsPanel.setBorder(null);
		fldProductId = new JTextField(1);
		fldProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fldName = new JTextField(1);
		fldName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fldModel = new JTextField(1);
		fldModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fldSerialnumber= new JTextField(1);
		fldSerialnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fldPrice = new JTextField(1);
		fldPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fieldsPanel.setLayout(new GridLayout(5, 10, 0, 45));
		fieldsPanel.add(fldProductId);
		horizontalStrut = Box.createHorizontalStrut(20);
		fieldsPanel.add(horizontalStrut);
		fieldsPanel.add(fldName);
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		fieldsPanel.add(horizontalStrut_1);
		fieldsPanel.add(fldModel);
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		fieldsPanel.add(horizontalStrut_2);
		fieldsPanel.add(fldSerialnumber);
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		fieldsPanel.add(horizontalStrut_3);
		fieldsPanel.add(fldPrice);
		GridBagConstraints gbc_fieldsPanel = new GridBagConstraints();
		gbc_fieldsPanel.gridheight = 3;
		gbc_fieldsPanel.fill = GridBagConstraints.BOTH;
		gbc_fieldsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_fieldsPanel.gridx = 1;
		gbc_fieldsPanel.gridy = 1;
		frame.getContentPane().add(fieldsPanel, gbc_fieldsPanel);
		horizontalStrut_4 = Box.createHorizontalStrut(20);
		fieldsPanel.add(horizontalStrut_4);

		// ActionCommands och ActionListeners för text fält

		String fieldProductId = null;
		String fieldName = null;
		String fieldModel = null;
		String fieldSerialnumber= null;
		String fieldPrice = null;

		fldProductId.setActionCommand(fieldProductId);
		fldName.setActionCommand(fieldName);
		fldModel.setActionCommand(fieldModel);
		fldSerialnumber.setActionCommand(fieldSerialnumber);
		fldPrice.setActionCommand(fieldPrice);

		buttonPane = new JPanel();
		btnKnapp1 = new JButton("Skapa/Skriv över");
		btnKnapp2 = new JButton("Radera");
		btnKnapp3 = new JButton("Hitta");
		btnKnapp4 = new JButton("Lista");

		buttonPane.setLayout(new FlowLayout());
		buttonPane.add(btnKnapp1);
		buttonPane.add(btnKnapp2);
		buttonPane.add(btnKnapp3);
		buttonPane.add(btnKnapp4);

		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPane.anchor = GridBagConstraints.NORTH;
		gbc_buttonPane.gridx = 1;
		gbc_buttonPane.gridy = 5;
		frame.getContentPane().add(buttonPane, gbc_buttonPane);
		JPanel middlePanel = new JPanel ();
		middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display lista" ) );
		display.setFont(new Font("Monospaced", Font.PLAIN, 13));
		display.setEditable ( false );
		JScrollPane scroll = new JScrollPane ( display );
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		middlePanel.add ( scroll );
		GridBagConstraints gbc_middlePanel1 = new GridBagConstraints();
		gbc_middlePanel1.gridy = 1;
		frame.getContentPane().add ( middlePanel, gbc_middlePanel1 );
		frame.pack ();
		frame.setLocationRelativeTo ( null );
		frame.setVisible ( true );



		// Action listeners för knappar

		btnKnapp1.addActionListener(this);
		btnKnapp2.addActionListener(this);
		btnKnapp3.addActionListener(this);
		btnKnapp4.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	// Hantera events
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Skapa/Skriv över")) {
			display.setText("");
			if (!fldProductId.getText().equals("") && !fldName.getText().equals("") && !fldModel.getText().equals("") && !fldSerialnumber.getText().equals("") && !fldPrice.getText().equals("")) {
				Cellphone newphone = new Cellphone(fldProductId.getText(), fldName.getText(), fldModel.getText(), fldSerialnumber.getText(),Integer.parseInt(fldPrice.getText()));
				cellphoneCatalog.addCellphone(newphone);
				display.setText("Inlaggt");
			}
			else {
				labelInfo.setText("Fyll i alla fält");
			}
		}

		if (e.getActionCommand().equals("Radera")) {
			// Radera
			display.setText("");

			if (Inventory.getCellphoneMap().containsKey(fldProductId.getText())){
				display.setText("Raderat");
				Inventory.getCellphoneMap().remove(fldProductId.getText());
			}
			else {
				display.setText("Inget hittades med det productId: \n  <br/> " + fldProductId.getText() + " \n ");
			}
		}


		if (e.getActionCommand().equals("Hitta")) {

			if (Inventory.getCellphoneMap().containsKey(fldProductId.getText())) {
				display.setText("");
				System.out.println("Hittade:");
				//System.out.println(Inventory.getCellphoneMap().get(productId.getText()));
				String listOutput = Inventory.getCellphoneMap().get(fldProductId.getText()).toString() + " \n ";
				display.setText(listOutput);
			}
			else {
				System.out.println("Ingen med Product Id: " + fldProductId.getText() + " hittades. :( ");
			}
		}



		if (e.getActionCommand().equals("Lista")) {
			display.setText("");
			PrintingUI ui = new PrintingUI();
			//ui.printCellphoneCatalog(Inventory.getCellphoneMap());
			//System.out.println(Inventory.getCellphoneMap().get(productId.getText()));
			for (Cellphone nextCellphone : Inventory.getCellphoneMap().values() ) {
				String listOutput = nextCellphone.toString() + " \n ";
				display.append(listOutput);


			}
		}
	}















}