package com.example.dataJpa.config.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;

import com.example.dataJpa.config.service.AuditDataService;

public class OdysseyAuditServiceUtilsLayout extends JFrame implements ActionListener, ItemListener {
	public OdysseyAuditServiceUtilsLayout() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		// super("UltiPro-Services");
		JFrame mainFrameExport = new JFrame();
		setLocationMainFrameExport(mainFrameExport);

		JFrame mainFrame = new JFrame();
		JMenuBar menubar = new JMenuBar();
		setLocationMainFrame(mainFrame, menubar, mainFrameExport);
		initUI();
	}

	private void setLocationMainFrameExport(JFrame mainFrameExport) {
		JRadioButton localDb, devDb, uatDb, rtDb, prdDb;
		ButtonGroup dbGroup = new ButtonGroup();
		localDb = new JRadioButton("Local");
		devDb = new JRadioButton("DEV");
		uatDb = new JRadioButton("UAT");
		rtDb = new JRadioButton("RT");
		prdDb = new JRadioButton("PRD");
		localDb.setBounds(100, 100, 80, 20);
		devDb.setBounds(180, 100, 80, 20);
		uatDb.setBounds(260, 100, 80, 20);
		rtDb.setBounds(340, 100, 80, 20);
		prdDb.setBounds(420, 100, 80, 20);
		dbGroup.add(localDb);
		dbGroup.add(devDb);
		dbGroup.add(uatDb);
		dbGroup.add(rtDb);
		dbGroup.add(prdDb);
		localDb.setSelected(true);
		localDb.setActionCommand("Local");
		devDb.setActionCommand("DEV");
		uatDb.setActionCommand("UAT");
		rtDb.setActionCommand("RT");
		prdDb.setActionCommand("PRD");
		localDb.addActionListener(this);
		devDb.addActionListener(this);
		uatDb.addActionListener(this);
		rtDb.addActionListener(this);
		prdDb.addActionListener(this);
		mainFrameExport.add(localDb);
		mainFrameExport.add(devDb);
		mainFrameExport.add(uatDb);
		mainFrameExport.add(rtDb);
		mainFrameExport.add(prdDb);

		dbHost = new JTextField("127.0.0.1");
		dbHostLabel = new JLabel("DB Host");
		dbPort = new JTextField("3306");
		dbPortLabel = new JLabel("Port");
		dbUserName = new JTextField("percona");
		dbUserNameLabel = new JLabel("username");
		dbPassword = new JPasswordField("percona");
		dbPasswordLabel = new JLabel("password");
		databaseSchema = new JTextField("percona");
		databaseSchemaLabel = new JLabel("Schema");

		dbHost.setBounds(100, 150, 400, 25);
		dbHostLabel.setBounds(0, 150, 200, 25);
		dbPort.setBounds(100, 200, 50, 25);
		dbPortLabel.setBounds(0, 200, 250, 25);
		dbUserName.setBounds(100, 250, 200, 25);
		dbUserNameLabel.setBounds(0, 250, 200, 25);
		dbPassword.setBounds(100, 300, 300, 25);
		dbPasswordLabel.setBounds(0, 300, 200, 25);
		databaseSchema.setBounds(100, 350, 300, 25);
		databaseSchemaLabel.setBounds(0, 350, 200, 25);

		mainFrameExport.add(dbHost);
		mainFrameExport.add(dbHostLabel);
		mainFrameExport.add(dbPort);
		mainFrameExport.add(dbPortLabel);
		mainFrameExport.add(dbUserName);
		mainFrameExport.add(dbUserNameLabel);
		mainFrameExport.add(dbPassword);
		mainFrameExport.add(dbPasswordLabel);
		mainFrameExport.add(databaseSchema);
		mainFrameExport.add(databaseSchemaLabel);

		fileExport = new JButton("export");
		fileExport.setBounds(130, 450, 120, 25);
		fileExport.setActionCommand("export");
		fileExport.addActionListener(this);
		mainFrameExport.add(fileExport);

		formatXlsx = new JRadioButton("xlsx");
		formatCsv = new JRadioButton("csv");
		formatGroup = new ButtonGroup();

		formatXlsx.setBounds(100, 50, 80, 20);
		formatCsv.setBounds(180, 50, 80, 20);
		formatXlsx.setSelected(true);
		formatGroup.add(formatXlsx);
		formatGroup.add(formatCsv);
		formatXlsx.setActionCommand("xlsx");
		formatCsv.setActionCommand("csv");
		formatXlsx.addActionListener(this);
		formatCsv.addActionListener(this);

		mainFrameExport.add(formatXlsx);
		mainFrameExport.add(formatCsv);

		exportProgressBar = new JProgressBar(1, 100);
		exportProgressBar.setValue(0);
		exportProgressBar.setStringPainted(true);
		exportProgressBar.setBounds(300, 450, 200, 25);

		exportProgressBarWait = new JProgressBar();
		exportProgressBarWait.setValue(0);
		exportProgressBarWait.setStringPainted(true);
		exportProgressBarWait.setBounds(100, 400, 300, 15);
		// exportProgressBarWait.setVisible(false);

		mainFrameExport.add(exportProgressBar);
		mainFrameExport.add(exportProgressBarWait);

		filePathInfo = new JLabel();
		filePathInfo.setSize(150, 100);
		filePathInfo.setBounds(5, -70, 600, 220);

		mainFrameExport.add(filePathInfo);

		addActionListenerFileExport(fileExport, mainFrameExport);
		setVisibleMainFrameExport(mainFrameExport);
	}

	private void addActionListenerFileExport(JButton fileExport, JFrame mainFrameExport) {
		fileExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fileDialogS = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("EXCEL", "xls", "xlsx");
				fileDialogS.setFileFilter(filter);
				exportProgressBarWait.setVisible(true);
				try {
					String FILENAME = null;
					int returnVal = fileDialogS.showSaveDialog(mainFrameExport);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						java.io.File file = fileDialogS.getSelectedFile();
						filePathInfo.setText("Save Location :" + file.getAbsolutePath());
						FILENAME = file.getAbsolutePath();
						if (formatGroup.getSelection().getActionCommand().equals("xlsx")) {

							AuditDataService auditDataService = new AuditDataService();
							auditDataService.getData(dbHost.getText().trim(), dbPort.getText().trim(),
									dbUserName.getText().trim(), dbPassword.getText().trim(),
									databaseSchema.getText().trim(), FILENAME.concat(".xlsx"));

						} else if (formatGroup.getSelection().getActionCommand().equals("csv")) {
							System.out.println("In progress");
						}
						mainFrameExport.setVisible(false);

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	private void setVisibleMainFrameExport(JFrame mainFrameExport) {
		mainFrameExport.setSize(630, 530);
		mainFrameExport.setLayout(null);
		mainFrameExport.setResizable(false);
		mainFrameExport.setLocationRelativeTo(null);

	}

	private void setLocationMainFrame(JFrame mainFrame, JMenuBar menubar, JFrame mainFrameExport)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		JMenu fileMenu = new JMenu("File");
		JMenu fileMenuH = new JMenu("Help");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem export = new JMenuItem("Export");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem about = new JMenuItem("About");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setToolTipText("Exit application");

		fileMenu.addSeparator();
		fileMenu.add(export);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		fileMenu.addSeparator();

		fileMenuH.addSeparator();
		fileMenuH.add(about);

		menubar.add(fileMenu);
		menubar.add(fileMenuH);
		setJMenuBar(menubar);

		addActionListenerSave(export, mainFrameExport);
		addActionListenerExit(exit);

		mainFrame.setSize(630, 530);
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		setVisibleMainFrame();

	}

	private void addActionListenerSave(JMenuItem saveMi, JFrame mainFrameExport) {
		saveMi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrameExport.setVisible(true);
			}
		});

	}

	private void addActionListenerExit(JMenuItem exitMi) {
		exitMi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

	}

	private void setVisibleMainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080, 768);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

	}

	private JTextArea logger;
	private JButton buttonClear = new JButton("Clear");
	private PrintStream standardOut;
	private JLabel headerLabel;

	JTextField dbHost;
	JLabel dbHostLabel;
	JTextField dbPort;
	JLabel dbPortLabel;
	JTextField dbUserName;
	JLabel dbUserNameLabel;
	JTextField dbPassword;
	JLabel dbPasswordLabel;
	JTextField databaseSchema;
	JLabel databaseSchemaLabel;
	JButton fileExport;
	JRadioButton formatXlsx, formatCsv;
	ButtonGroup formatGroup = new ButtonGroup();
	JProgressBar exportProgressBar, exportProgressBarWait;
	JLabel filePathInfo;

	private void initUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, ParseException {
		logger = new JTextArea(250, 150);
		logger.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(logger));
		standardOut = System.out;
		System.setOut(printStream);
		System.setErr(printStream);
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 1;
		constraints.gridx = 2;
		constraints.gridx = 2;
		add(buttonClear, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		add(new JScrollPane(logger), constraints);
		addActionListener(buttonClear);
		//////////////////////// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//////////////////////// setSize(1080, 768);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = sdf.parse("31/05/2021");
		Date currentDate = sdf.parse(sdf.format(new Date()));
		int i = date1.compareTo(currentDate);
		if (i != -1) {
			printLog();
		} else {
			headerLabel.setText("Licence expired");
			System.out.println("Licence expired");
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			JOptionPane.showMessageDialog(frame, "Licence expired !!!");
			System.exit(0);
		}

	}

	private void addActionListener(JButton buttonClear) {
		buttonClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				// clears the text area
				try {
					logger.getDocument().remove(0, logger.getDocument().getLength());
					standardOut.println("Text area cleared");
				} catch (BadLocationException ex) {
					ex.printStackTrace();
				}
			}
		});

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Local")) {
			JOptionPane.showMessageDialog(this, " Environment specifications updated->DEV.");
			dbHost.setText("127.0.0.1");
			dbPort.setText("3306");
			dbUserName.setText("Gram");
			dbPassword.setText("Gram@2020");
			databaseSchema.setText("graphqls");

		}
		if (e.getActionCommand().equals("DEV")) {
			dbHost.setText("pntva3101.fr.chp.accenture.com");
			dbPort.setText("1416");
			dbUserName.setText("SYSTEM.ADMIN.SVRCONN");
			dbPassword.setText("SGBUS");
			JOptionPane.showMessageDialog(this, " Environment specifications have been updated [UAT]");
		}
		if (e.getActionCommand().equals("UAT")) {
			dbHost.setText("10.105.79.5");
			dbPort.setText("1446");
			dbUserName.setText("TRE6_SGBUS");
			dbPassword.setText("TRE6_SGBUS");
			JOptionPane.showMessageDialog(this, " Environment specifications have been updated [RT]");
		}
		if (e.getActionCommand().equals("RT")) {
			dbHost.setText("mqapp-prd-local.bfsukdc.com");
			dbPort.setText("53301");
			dbUserName.setText("DEALSCHL");
			dbPassword.setText("DEALS");
			JOptionPane.showMessageDialog(this, " Environment specifications have been updated [NHBR]");
		}
		if (e.getActionCommand().equals("PRD")) {
			dbHost.setText("mqapp-prd-local.bfsukdc.com");
			dbPort.setText("53301");
			dbUserName.setText("DEALSCHL");
			dbPassword.setText("DEALS");
			JOptionPane.showMessageDialog(this, " Environment specifications have been updated [WWK]");
		}
		/*
		 * if(e.getActionCommand().equals("JMSYES")) {
		 * mainFrameJMSHeader.setVisible(true); mainFrameJMSHeader.add(useCaseList);
		 * mainFrameJMSHeader.add(jSecBusAppId); mainFrameJMSHeader.add(jSecBusAppIdL);
		 * mainFrameJMSHeader.add(jSecBusMessageId);
		 * mainFrameJMSHeader.add(jSecBusMessageIdL);
		 * mainFrameJMSHeader.add(jSecBusMsgType);
		 * mainFrameJMSHeader.add(jSecBusMsgTypeL);
		 * mainFrameJMSHeader.add(jSecBusInterface);
		 * mainFrameJMSHeader.add(jSecBusInterfaceL);
		 * mainFrameJMSHeader.add(jSecBusContentSchema);
		 * mainFrameJMSHeader.add(jSecBusContentSchemaL);
		 * mainFrameJMSHeader.add(jSecBusContentType);
		 * mainFrameJMSHeader.add(jSecBusContentTypeL);
		 * mainFrameJMSHeader.add(jSecBusContentEncoding);
		 * mainFrameJMSHeader.add(jSecBusContentEncodingL);
		 * mainFrameJMSHeader.add(jSecBusFunctionalId);
		 * mainFrameJMSHeader.add(jSecBusFunctionalIdL);
		 * mainFrameJMSHeader.add(jJMSCorrelationID);
		 * mainFrameJMSHeader.add(jJMSCorrelationIDL); mainFrameJMSHeader.add(jJMSType);
		 * mainFrameJMSHeader.add(jJMSTypeL); mainFrameJMSHeader.add(jSecBusTargetApp);
		 * mainFrameJMSHeader.add(jSecBusTargetAppL); }
		 * if(e.getActionCommand().equals("JMSNO")) {
		 * mainFrameJMSHeader.setVisible(false); }
		 * 
		 */
	}

	private void printLog() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("\t\t\t " + (new Date()) + "\n");
					try {
						Thread.sleep(60000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

}
