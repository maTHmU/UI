package framework.inputtabbedpane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import framework.mycomponents.MyButton;
import framework.mycomponents.MyToolBar;

import javax.swing.SwingConstants;

import common.FilePaths;
import common.SystemOperations;

public class GreekToolBar extends MyToolBar implements ActionListener {

	private static final long serialVersionUID = -5081625597661885696L;

	public GreekToolBar() {
		super(SwingConstants.HORIZONTAL);
		setName("Greek");

		addButton("Alpha");
		addButton("Beta");
		addButton("Gamma");
		addButton("Delta");
		addButton("Epsilon");
		addButton("Zeta");
		addButton("Eta");
		addButton("Theta");
		addButton("Iota");
		addButton("Kappa");
		addButton("Lambda");
		addButton("Mu");
		addButton("Nu");
		addButton("Xi");
		addButton("Omicron");
		addButton("Pi");
		addButton("Rho");
		addButton("Sigma");
		addButton("Tau");
		addButton("Upsilon");
		addButton("Phi");
		addButton("Chi");
		addButton("Psi");
		addButton("Omega");

		addButton("CapitalAlpha");
		addButton("CapitalBeta");
		addButton("CapitalGamma");
		addButton("CapitalDelta");
		addButton("CapitalEpsilon");
		addButton("CapitalZeta");
		addButton("CapitalEta");
		addButton("CapitalTheta");
		addButton("CapitalIota");
		addButton("CapitalKappa");
		addButton("CapitalLambda");
		addButton("CapitalMu");
		addButton("CapitalNu");
		addButton("CapitalXi");
		addButton("CapitalOmicron");
		addButton("CapitalPi");
		addButton("CapitalRho");
		addButton("CapitalSigma");
		addButton("CapitalTau");
		addButton("CapitalUpsilon");
		addButton("CapitalPhi");
		addButton("CapitalChi");
		addButton("CapitalPsi");
		addButton("CapitalOmega");
	}

	private void addButton(String buttonName) {
		MyButton newButton = new MyButton(
				SystemOperations.getImageIcon(FilePaths.INPUTTOOLBAR_GREEK_ICONS_PATH + buttonName + ".png"));
		newButton.setName(buttonName);
		newButton.setActionCommand(buttonName);
		newButton.addActionListener(this);
		add(newButton);
		buttons.add(newButton);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
