/*
 * sample.java
 *
 * Created on __DATE__, __TIME__
 */

package org.fromText;

/**
 *
 * @author  __USER__
 */
public class sample extends javax.swing.JFrame {

	/** Creates new form sample */
	public sample() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		textField1 = new java.awt.TextField();
		jLabel2 = new javax.swing.JLabel();
		textField2 = new java.awt.TextField();
		button2 = new java.awt.Button();
		jLabel3 = new javax.swing.JLabel();
		textField3 = new java.awt.TextField();
		jLabel4 = new javax.swing.JLabel();
		button3 = new java.awt.Button();
		button4 = new java.awt.Button();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("\u8d26\u53f7");

		textField1.setName("username");
		textField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField1ActionPerformed(evt);
			}
		});

		jLabel2.setText("\u5bc6\u7801");

		textField2.setName("password");
		textField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField2ActionPerformed(evt);
			}
		});

		button2.setActionCommand("button");
		button2.setLabel("\u6dfb\u52a0");
		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button2ActionPerformed(evt);
			}
		});

		jLabel3.setText("\u65e5\u671f");

		textField3.setName("dateFrom");
		textField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField3ActionPerformed(evt);
			}
		});

		jLabel4.setForeground(new java.awt.Color(10, 10, 10));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("\u8d26\u53f7\u7ba1\u7406\u7cfb\u7edf");

		button3.setActionCommand("button");
		button3.setLabel("\u9000\u51fa");
		button3.setName("null");
		button3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button3ActionPerformed(evt);
			}
		});

		button4.setActionCommand("button");
		button4.setLabel("\u9000\u51fa");
		button4.setName("null");
		button4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(67, 67, 67)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jLabel4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														173,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						jLabel1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel2,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel3,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																								.addGroup(
																										layout.createSequentialGroup()
																												.addComponent(
																														button3,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														53,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(
																														javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														button2,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														53,
																														javax.swing.GroupLayout.PREFERRED_SIZE))
																								.addComponent(
																										textField3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										126,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						textField2,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						126,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						textField1,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						126,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		button4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		28,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(126, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addComponent(jLabel4)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.CENTER)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		26,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		26,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		26,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		textField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		textField2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(14, 14,
																		14)
																.addComponent(
																		textField3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(10, 10, 10)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.CENTER)
												.addComponent(
														button3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														button2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														button4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(110, 110, 110)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void button4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void button3ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void textField3ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new sample().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private java.awt.Button button2;
	private java.awt.Button button3;
	private java.awt.Button button4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private java.awt.TextField textField1;
	private java.awt.TextField textField2;
	private java.awt.TextField textField3;
	// End of variables declaration//GEN-END:variables

}