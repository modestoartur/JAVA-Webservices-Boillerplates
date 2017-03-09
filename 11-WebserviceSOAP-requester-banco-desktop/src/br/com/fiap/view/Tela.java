package br.com.fiap.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.JogoBOStub;
import br.com.fiap.bo.JogoBOStub.Buscar;
import br.com.fiap.bo.JogoBOStub.BuscarResponse;
import br.com.fiap.bo.JogoBOStub.Cadastrar;
import br.com.fiap.bo.JogoBOStub.Jogo;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtPreco;
	private Text txtProdutora;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(435, 266);
		shell.setText("SWT Application");
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(22, 21, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(22, 42, 137, 21);
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(22, 69, 55, 15);
		lblPreo.setText("Pre\u00E7o");
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(22, 90, 137, 21);
		
		Label lblProdutora = new Label(shell, SWT.NONE);
		lblProdutora.setBounds(22, 117, 55, 15);
		lblProdutora.setText("Produtora");
		
		txtProdutora = new Text(shell, SWT.BORDER);
		txtProdutora.setBounds(22, 138, 137, 21);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Recuperar as informações inseridas na tela
				String nome = txtNome.getText();
				String produtora = txtProdutora.getText();
				float preco = Float.parseFloat(txtPreco.getText());
				try{
					//Instanciar o stub
					JogoBOStub stub = new JogoBOStub();
					//Instanciar o Jogo
					Jogo jogo = new Jogo();
					jogo.setNome(nome);
					jogo.setPreco(preco);
					jogo.setProdutora(produtora);
					//Instanciar o Cadastrar
					Cadastrar params = new Cadastrar();
					//Setar o jogo no cadastrar
					params.setJogo(jogo);
					//Chamar o webservice
					stub.cadastrar(params);
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(22, 176, 137, 25);
		btnCadastrar.setText("Cadastrar");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(220, 42, 76, 21);
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(223, 21, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//Instanciar o Stub
					JogoBOStub stub = new JogoBOStub();
					//Recuperar o código para a pesquisa
					int codigo = Integer.parseInt(txtCodigo.getText());
					//Instanciar o Buscar e passar o código
					Buscar params = new Buscar();
					params.setId(codigo);
					//Chamar o webservice
					BuscarResponse resp = stub.buscar(params);
					//Recuperar o resultado da busca
					Jogo jogo = resp.get_return();
					//Exibir o resultado
					txtNome.setText(jogo.getNome());
					txtPreco.setText(jogo.getPreco()+"");
					txtProdutora.setText(jogo.getProdutora());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(302, 40, 75, 25);
		btnBuscar.setText("Buscar");

	}
}
