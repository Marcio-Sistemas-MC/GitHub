/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import UTIL.Alerta;
import banco.dao.CidadeJpaController;
import banco.dao.ClientesJpaController;
import banco.dao.EstadoJpaController;
import banco.novo.Cidade;
import banco.novo.Clientes;
import banco.novo.Estado;
import gerapedidos.principalController;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class CadastroClientesController implements Initializable {

    @FXML
    private TextField tfcodCliente;
    @FXML
    private TextField tfNomeCliente;
    @FXML
    private DatePicker dtAdimissao;
    @FXML
    private ComboBox<String> cbTipo;
    @FXML
    private Tab abaPessoaFisica;
    @FXML
    private TextField tfCPF;
    @FXML
    private TextField tfRG;
    @FXML
    private ComboBox<String> cbEstadoCivil;
    @FXML
    private TextField tfApelido;
    @FXML
    private TextField tfNaturalidade;
    @FXML
    private TextField tfConjuge;
    @FXML
    private TextField tfMae;
    @FXML
    private TextField tfPai;
    @FXML
    private TextField tfLocalTrabalho;
    @FXML
    private TextField tfTelTrabalho;
    @FXML
    private TextField TfRenda;
    @FXML
    private TextField tfProfissao;
    @FXML
    private DatePicker dtAdimissaoTrabalho;
    @FXML
    private Tab abaPessoaJuridica;
    @FXML
    private TextField tfRazaoSocial;
    @FXML
    private TextField tfCNPJ;
    @FXML
    private TextField tfInscEstadual;
    @FXML
    private Tab abaEndComercial;
    @FXML
    private TextField tfRuaComercial;
    @FXML
    private TextField tfNumComercial;
    @FXML
    private TextField tfCompComercial;
    @FXML
    private TextField tfBairroComercial;
    @FXML
    private ComboBox<String> cbUFComercial;
    @FXML
    private ComboBox<String> cbCidadeComercial;
    @FXML
    private TextField tfCEPComercial;
    @FXML
    private Tab abaEndDomicilio;
    @FXML
    private TextField tfRuaDomicilio;
    @FXML
    private TextField tfNumDomicilio;
    @FXML
    private TextField tfCompComercial1;
    @FXML
    private TextField tfBairroDomicilio;
    @FXML
    private ComboBox<String> cbUFDomicilio;
    @FXML
    private ComboBox<String> cbDomicilio;
    @FXML
    private TextField tfCEPDomicilio;
    @FXML
    private Tab abaContatos;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfFax;
    @FXML
    private TextField tfCelular;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfContato;
    @FXML
    private Tab abaObservacao;
    @FXML
    private TextArea taObservacao;
    @FXML
    private Tab abaOutras;
    @FXML
    private ComboBox<String> cbContribuinte;
    @FXML
    private Label lbAtivo;
    @FXML
    private Label lbUsuInclusao;
    @FXML
    private Label lbDtInclusao;
    @FXML
    private Label lbUsuAlteracao;
    @FXML
    private Label lbDtAlteracao;
    @FXML
    private Button btnPrimeiro;
    @FXML
    private Button btnAnterior;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnUltimo;
    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnInativar;
    @FXML
    private ImageView imgAtivaDesativa;
    @FXML
    private Button btnSair;
    @FXML
    private Tab abaClientes;
    @FXML
    private ComboBox<String> cbCampos; //Código, Nome, Tipo, CPF, CNPJ, Telefone, Ativo
    @FXML
    private TextField tfConsulta;
    @FXML
    private Button btnConsultar;
    @FXML
    private TableView<Clientes> tabelaClientes;
    @FXML
    private TableColumn<Clientes, String> colCodigo;
    @FXML
    private TableColumn<Clientes, String> colNome;
    @FXML
    private TableColumn<Clientes, String> colTipo;
    @FXML
    private TableColumn<Clientes, String> colCPF;
    @FXML
    private TableColumn<Clientes, String> colCNPJ;
    @FXML
    private TableColumn<Clientes, String> colTelefone;
    @FXML
    private TableColumn<Clientes, String> colAtivo;
    @FXML
    private Tab abaDados;
    @FXML
    private TabPane painelPrincipal;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("geraPedidosPU");
    private List<Cidade> cidades = new ArrayList<>();
    private List<Estado> estados = new ArrayList<>();
    private List<Clientes> clientes = new ArrayList<>();
    @FXML
    private DatePicker dtNascimento;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configuraTabela();
        configuraCBCmpos();
        configuraCBTipo();
        configuraCBUF();
        configuraCbEstadoCivil();
        configuraCBTipoContribuinte();
        // buscaCidades();
    }

    private void buscaClientes() {
        ClientesJpaController cliDao = new ClientesJpaController(emf);
        clientes = cliDao.findClientesEntities();
    }

    private void buscaCidades() {
        CidadeJpaController cidDao = new CidadeJpaController(emf);
        cidades.clear();
        cidades = cidDao.findCidadeEntities();
    }

    private void configuraCBCmpos() {
        this.cbCampos.getItems().addAll("Código", "Nome", "Tipo", "CPF", "CNPJ", "Telefone", "Ativo");
        this.cbCampos.setValue(this.cbCampos.getItems().get(0));
    }

    private void configuraCBTipo() {
        this.cbTipo.getItems().addAll("Física", "Jurídica");
    }

    private void configuraCbEstadoCivil() {
        this.cbEstadoCivil.getItems().clear();
        this.cbEstadoCivil.getItems().addAll("Solteiro(a)", "Casodo(a)", "Viúvo(a)", "Divorciado(a)", "Outros");
        this.cbEstadoCivil.getSelectionModel().selectFirst();
    }

    private void configuraCBTipoContribuinte() {
        this.cbContribuinte.getItems().clear();
        this.cbContribuinte.getItems().addAll("Consumidor Final (não Contribuinte)", "Contribuinte");
    }

    private void configuraCBUF() {
        this.cbUFComercial.getItems().clear();
        this.cbUFDomicilio.getItems().clear();
        EstadoJpaController ufDao = new EstadoJpaController(emf);
        estados = ufDao.findEstadoEntities();
        estados.forEach((e) -> {
            this.cbUFComercial.getItems().add(e.getUf());
            this.cbUFDomicilio.getItems().add(e.getUf());
        });
    }

    private void configuraTabela() {
        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codpessoa"));
        this.colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        this.colCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        this.colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.colAtivo.setCellValueFactory(new PropertyValueFactory<>("ativo"));

    }

    @FXML
    private void btnEnterPressed(KeyEvent event) {
    }

    @FXML
    private void actionBtnPrimeiro(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectFirst();
    }

    @FXML
    private void actionBtnAnterior(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectPrevious();
    }

    @FXML
    private void actionBtnProximo(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectNext();
    }

    @FXML
    private void actionBtnUltimo(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectLast();
    }

    @FXML
    private void actionBtnNovo(ActionEvent event) {
    }

    @FXML
    private void actionBtnEditar(ActionEvent event) {
        Clientes cli = this.tabelaClientes.getSelectionModel().getSelectedItem();
        editarCliente(cli);
    }

    @FXML
    private void actionBtnSalvar(ActionEvent event) {
    }

    @FXML
    private void actionBtnCancelar(ActionEvent event) {
    }

    @FXML
    private void actionBtnInativar(ActionEvent event) {
    }

    @FXML
    private void actionBtnSair(ActionEvent event) {
        principalController.getTelaClientes().close();
    }

    @FXML
    private void actionConsultarClientes(ActionEvent event) {
        this.clientes.clear();
        this.buscaClientes();
        this.tabelaClientes.getItems().clear();
        String campo = this.cbCampos.getValue();
        if (!this.tfConsulta.getText().trim().isEmpty()) {
            CharSequence termo = this.tfConsulta.getText();
            //Código, Nome, Tipo, CPF, CNPJ, Telefone, Ativo
            switch (campo) {
                case "Código":
                    clientes.stream().filter((c) -> (String.valueOf(c.getCodpessoa()).contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Nome":
                    clientes.stream().filter((c) -> (c.getNome().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Tipo":
                    clientes.stream().filter((c) -> (c.getTipo().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "CPF":
                    clientes.stream().filter((c) -> (c.getCpf().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "CNPJ":
                    clientes.stream().filter((c) -> (c.getCnpj().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Telefone":
                    clientes.stream().filter((c) -> (c.getTelefone().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Ativo":
                    clientes.stream().filter((c) -> (c.getAtivo().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
            }

        } else {
            this.tabelaClientes.getItems().addAll(clientes);
        }
    }

    private void editarCliente(Clientes cli) {
        if (!this.tabelaClientes.getItems().isEmpty()) {
            this.painelPrincipal.getSelectionModel().select(this.abaDados);
            // preenchimento dos campos por ordem alfabética
            this.TfRenda.setText(String.valueOf(cli.getRenda()));
            this.tfApelido.setText(cli.getApelido());
            this.tfBairroComercial.setText(cli.getBairro());
            this.tfBairroDomicilio.setText(cli.getBairrodom());
            this.tfCEPComercial.setText(cli.getCep());
            this.tfCEPDomicilio.setText(cli.getCepdom());
            this.tfCNPJ.setText(cli.getCnpj());
            this.tfCPF.setText(cli.getCpf());
            this.tfCelular.setText(cli.getCelular());
            this.tfCompComercial.setText(cli.getComplCom());
            this.tfCompComercial1.setText(cli.getComplDom());
            this.tfConjuge.setText(cli.getConjuge());
            this.tfContato.setText(cli.getPessoacontato());
            //this.tfFax.setText();
            this.tfInscEstadual.setText(cli.getInscest());
            this.tfLocalTrabalho.setText(cli.getLocaltrabalho());
            this.tfMae.setText(cli.getFiliacaoMae());
            this.tfNaturalidade.setText(cli.getNaturalidade());
            this.tfNomeCliente.setText(cli.getNome());
            this.tfNumComercial.setText(cli.getNumCom());
            this.tfNumDomicilio.setText(cli.getNumDom());
            this.tfPai.setText(cli.getFiliacaoPai());
            this.tfProfissao.setText(cli.getProftrabalho());
            this.tfRG.setText(cli.getRg());
            this.tfRazaoSocial.setText(cli.getRazaosocial());
            this.tfRuaComercial.setText(cli.getLograCom());
            this.tfRuaDomicilio.setText(cli.getLograDom());
            this.tfTelTrabalho.setText(cli.getTelefonetrabalho());
            this.tfTelefone.setText(cli.getTelefone());
            this.tfcodCliente.setText(String.valueOf(cli.getCodpessoa()));
            this.tfemail.setText(cli.getEmail());
            this.cbContribuinte.getSelectionModel().select(tipoAliquotaICMS(cli.getTipoaliqicms()));
            this.CarregaCidadesEstadoCliente(cli);// carrega dados dos estados e cidades do cad. Cliente
            this.cbEstadoCivil.getSelectionModel().select(cli.getEstadoCiv());
            this.cbTipo.getSelectionModel().select(carregaTipoCliente(cli.getTipo()));
            carregaDatas(cli);// carrega as datas no formato LocalDate;
            carregaCampoAtivo(cli);
        }
    }
    
    private void carregaCampoAtivo(Clientes cli) {
        // veirificar se S ou N e configurar cor Vermelha ou verde;
    }
    
    private void carregaDatas(Clientes cli) {
        LocalDate ld = toLocalDate(cli.getDtaAdmissao());
        this.dtAdimissao.setValue(ld);
        LocalDate ld1 = toLocalDate(cli.getDtaAdmtrabalho());
        this.dtAdimissaoTrabalho.setValue(ld1);
        LocalDate ld2 = toLocalDate(cli.getDataNasc());
        this.dtNascimento.setValue(ld2);
    }
    
    public static LocalDate toLocalDate(Date d) {
        Instant instant = Instant.ofEpochMilli(d.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
        
        

    private void CarregaCidadesEstadoCliente(Clientes cli) {
        this.buscaCidades();
        cidades.stream().map((c) -> {
            if(c.getId() == cli.getCodcidade()) {
                System.out.println("Entrou aqui : Cidade 1 = " + c.getId());
                this.cbCidadeComercial.getSelectionModel().select(c.getNome());
                this.cbUFComercial.getSelectionModel().select(c.getEstado().getUf());
            }
            return c;
        }).filter((c) -> (c.getId() == cli.getCodcidadedom())).map((c) -> {
            this.cbDomicilio.getSelectionModel().select(c.getNome());
            return c;
        }).forEachOrdered((c) -> {
            this.cbUFDomicilio.getSelectionModel().select(c.getEstado().getUf());
        });
    }

    @FXML
    private void actionSelecionarCidadeTeclado(KeyEvent event) {
        String uf = this.cbUFComercial.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbCidadeComercial);
        }
    }

    @FXML
    private void actionSelecionarCidadeMouse(MouseEvent event) {
        String uf = this.cbUFComercial.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbCidadeComercial);
        }
    }

    private void configuraCBCidadeComercial(String uf, ComboBox cb) {
        cb.getItems().clear();
        ArrayList<Cidade> c;
        for (Estado e : estados) {
            if (e.getUf().equalsIgnoreCase(uf)) {
                c = new ArrayList<>(e.getCidadeCollection());
                for (int i = 0; i < c.size(); i++) {
                    cb.getItems().add(c.get(i).getNome());
                }
            }
        }
    }

    @FXML
    private void actionSelecionarCidadeDomTeclado(KeyEvent event) {
        String uf = this.cbUFDomicilio.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbDomicilio);
        }
    }

    @FXML
    private void actionSelecionarCidadeDomMouse(MouseEvent event) {
        String uf = this.cbUFDomicilio.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbDomicilio);
        }
    }

    private String tipoAliquotaICMS(Integer tipoaliqicms) {
        if (tipoaliqicms == 1) {
            return this.cbContribuinte.getItems().get(0);
        } else {
            return this.cbContribuinte.getItems().get(1);
        }
    }

    private String carregaTipoCliente(String tipo) {
        if(tipo.equalsIgnoreCase("F")) {
            return "Física";
        } else {
            return "Jurídica";
        }
    }

}
